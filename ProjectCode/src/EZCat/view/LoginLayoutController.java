package EZCat.view;

import EZCat.DatabaseConnector;
import EZCat.Main;
import EZCat.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginLayoutController {
    private Stage dialogStage;
    public Person person;
    private boolean okClicked = false;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;


    @FXML
    private void handleMakeAccountButton() {
        person.setUsername(usernameField.getText());
        person.setPassword(passwordField.getText());
        if (isInputValid(true)) {

            try {
                DatabaseConnector dbCon = new DatabaseConnector("general", "generalPublicPassword");
                if (dbCon.createUser(person)) {
                    System.out.println("Logged in and Account Made");
                    okClicked = true;
                } else {
                    okClicked = false;
                    System.out.println("invalid / already exists");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            dialogStage.close();
        }
    }


    @FXML
    private void handleLogin() {
        person.setUsername(usernameField.getText());
        person.setPassword(passwordField.getText());
        if (isInputValid(false)) {

            try {
                DatabaseConnector dbCon = new DatabaseConnector("general", "generalPublicPassword");
                if (dbCon.loginUser(person.getUsername(), person.getPassword())) {
                    // true if user with password found in DB
                    System.out.println("Logged in");
                    okClicked = true;
                    person.setId(dbCon.getUserID(person.getUsername()));
                } else {
                    okClicked = false;
                    System.out.println("invalid");
                }
                if(isAuthorised(person.getUsername(), dbCon)) {
                    person.setIsAdmin(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }



            dialogStage.close();
        }
    }

    public boolean isAuthorised(String username, DatabaseConnector dbCon) {
        try {
//            DatabaseConnector dbCon = new DatabaseConnector("general", "generalPublicPassword");
            ArrayList<String> adminUsers = dbCon.listAdmins();
            if (username.equals("")) {
                // grab username from current login in LoginLayoutController class
                username = person.getUsername();
            }
            if (adminUsers.contains(username)) {
                // is an admin
                return true;
            }
            // not an admin
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        person = new Person();
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Returns true if the user clicked OK, false otherwise.`
     *
     * @return
     */
    public Person isOkClicked() {
        return person;
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid(boolean isCreating) {
        String errorMessage = "";

        if (usernameField.getText() == null || usernameField.getText().length() == 0) {
            errorMessage += "No username!\n";
        }
        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "No password!\n";
        }

        DatabaseConnector dbCon = null;
        try {
            dbCon = new DatabaseConnector("general", "generalPublicPassword");
            if (!dbCon.loginUser(person.getUsername(), person.getPassword()) && !isCreating) {
                // does not exist and account is not being created
                System.out.println(person.getUsername() + "-" + person.getPassword());
                errorMessage += "No username exists with the given password!\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct the issues");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }



}
