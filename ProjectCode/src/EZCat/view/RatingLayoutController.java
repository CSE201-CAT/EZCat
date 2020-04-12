package EZCat.view;

import EZCat.Main;
import EZCat.Movie;
import EZCat.Person;
import EZCat.Rating;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RatingLayoutController {

    private Stage dialogStage;
    private Movie movie;
    private boolean okClicked = false;

    // UI Elements
    @FXML
    private TextField ratingTextBox;

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
     * Returns true if the user clicked OK, false otherwise.`
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Sets the movie to be edited in the dialog.
     *  @param movie
     * @param rated
     * @param user
     */
    public void setMovieRating(Movie movie, Rating rated, Person user) {
        if (isInputValid()) {
            rated.setRating((double) Integer.parseInt(ratingTextBox.getText()));
            rated.setMovieId(movie.getId());
            rated.setPersonId(user.getId());
        }
    }

    @FXML
    private void handleSubmitRating() {
        if (isInputValid()) {
            // input is valid
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (ratingTextBox.getText() == null || ratingTextBox.getText().length() == 0) {
            errorMessage += "No rating entered!\n";
        } else {
            // try to parse the rating to a Integer
            try {
                int num = Integer.parseInt(ratingTextBox.getText());
                if (num < 1 || num > 5) {
                    errorMessage += "Rating must be between 1 and 5!\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid rating (must be an number)!\n";
            }
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
