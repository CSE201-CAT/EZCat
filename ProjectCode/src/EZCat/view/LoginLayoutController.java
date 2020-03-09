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
    private Person person;
    private boolean okClicked = false;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;


    @FXML
    private void handleMakeAccountButton() {
        person.setUsername(usernameField.getText());
        person.setPassword(passwordField.getText());
        System.out.println(usernameField.getText());
        System.out.println(passwordField.getText());
        System.out.println(person.getPassword());

        System.out.println(person.toString());

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


    @FXML
    private void handleLogin() {
        person.setUsername(usernameField.getText());
        person.setPassword(passwordField.getText());
        System.out.println(usernameField.getText());
        System.out.println(passwordField.getText());
        System.out.println(person.getPassword());
        System.out.println();

        System.out.println(person.toString());

        try {
            DatabaseConnector dbCon = new DatabaseConnector("general", "generalPublicPassword");
            if (dbCon.loginUser(person.getUsername(), person.getPassword())) {
                // true if user with password found in DB
                System.out.println("Logged in");
                okClicked = true;
            } else {
                okClicked = false;
                System.out.println("invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dialogStage.close();
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
    public boolean isOkClicked() {
        return okClicked;
    }


}
