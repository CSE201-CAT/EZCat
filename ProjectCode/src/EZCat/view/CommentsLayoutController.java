package EZCat.view;

import EZCat.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class CommentsLayoutController {
    @FXML
    private void handleSubmitComment() {
    }

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
     * Returns true if the user clicked OK, false otherwise.`
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Sets the movie to be edited in the dialog.
     *
     * @param movie
     */
    public void setMovieComments(Movie movie) {

    }
}
