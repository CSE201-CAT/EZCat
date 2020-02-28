package EZCat.view;

import javafx.event.ActionEvent;
import EZCat.Main;

public class MainLayoutController {

    // Reference to the main application.
    private Main mainApp;


    public void handleNewMovie(ActionEvent actionEvent) {
    }

    public void handleEditMovie(ActionEvent actionEvent) {
    }

    public void handleDeleteMovie(ActionEvent actionEvent) {
    }

    public void handleViewCommentsPage(ActionEvent actionEvent) {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

    }
}
