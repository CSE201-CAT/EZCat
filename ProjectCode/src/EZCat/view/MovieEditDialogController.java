package EZCat.view;

import EZCat.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MovieEditDialogController {

    @FXML
    private TextField titleField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField directorField;
    @FXML
    private TextField studioField;



    private Stage dialogStage;
    private Movie movie;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
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
     * Sets the movie to be edited in the dialog.
     *
     * @param movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;

        titleField.setText(movie.getTitle());
        directorField.setText(movie.getDirector());
        genreField.setText(movie.getGenre());
        yearField.setPromptText("yyyy");
        studioField.setText(movie.getStudio());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.`
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            movie.setTitle(titleField.getText());
            movie.setDirector(directorField.getText());
            movie.setGenre(genreField.getText());
            movie.setYear(Integer.parseInt(yearField.getText()));
            movie.setStudio(studioField.getText());

            okClicked = true;


            System.out.println(movie.toString());



            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (titleField.getText() == null || titleField.getText().length() == 0) {
            errorMessage += "No movie name!\n";
        }
        if (genreField.getText() == null || genreField.getText().length() == 0) {
            errorMessage += "No genre!\n";
        }
        if (directorField.getText() == null || directorField.getText().length() == 0) {
            errorMessage += "No director!\n";
        }

        if (yearField.getText() == null || yearField.getText().length() == 0) {
            errorMessage += "No year!\n";
        } else {
            // try to parse the rating to a Integer
            try {
                Integer.parseInt(yearField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid year (must be an number)!\n";
            }
        }

        if (studioField.getText() == null || studioField.getText().length() == 0) {
            errorMessage += "No studio name!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct the invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
