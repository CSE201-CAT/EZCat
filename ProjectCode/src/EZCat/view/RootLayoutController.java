package EZCat.view;

import EZCat.DatabaseConnector;
import EZCat.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;

import java.sql.SQLException;

public class RootLayoutController {
    private Main mainApp;

    @FXML
    public Button newEditViewButton;
    @FXML
    public Button deleteViewButton;
    @FXML
    public Button bookmarksButton;

    public boolean newEditClicked = false;
    public boolean deleteClicked = false;
    public boolean bookmarkClicked = false;

    @FXML
    private void handleViewProfileButton() {
        System.out.println("in view profile");
    }

    @FXML
    private void handlePeopleViewButton() {
        System.out.println("in people view");
    }

    @FXML
    private void handleBookmarksViewButton() {
        System.out.println("in bookmarks view");
        try {
            if (!bookmarkClicked) {
                // not triggered
                mainApp.populateMovieTable(3);
                bookmarkClicked = true;
                bookmarksButton.setText("View Published");
                newEditViewButton.setText("New / Edit Requests");
                deleteViewButton.setText("Delete Requests");
                mainApp.mainLayoutControllerInMain.editButton.setVisible(false);
                mainApp.mainLayoutControllerInMain.newButton.setVisible(false);
                mainApp.mainLayoutControllerInMain.acceptRequestButton.setVisible(false);
            } else {
                // triggered - revert
                mainApp.populateMovieTable(0);
                bookmarkClicked = false;
                bookmarksButton.setText("View Bookmarks");
                newEditViewButton.setText("New / Edit Requests");
                deleteViewButton.setText("Delete Requests");
                mainApp.mainLayoutControllerInMain.editButton.setVisible(true);
                mainApp.mainLayoutControllerInMain.newButton.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleNewEditViewButton() {
        // show all movies that are flagged as not published
        // if user accepts new / edit database will add or update movie
        try {
            if (!newEditClicked) {
                // not triggered
                mainApp.populateMovieTable(1);
                newEditClicked = true;
                newEditViewButton.setText("View Published");
                deleteViewButton.setText("Delete Requests");

                mainApp.mainLayoutControllerInMain.bookmarkButton.setText("Veto");
                mainApp.mainLayoutControllerInMain.acceptRequestButton.setDisable(false);
                mainApp.mainLayoutControllerInMain.editButton.setVisible(true);
                mainApp.mainLayoutControllerInMain.newButton.setVisible(true);
                mainApp.mainLayoutControllerInMain.acceptRequestButton.setVisible(true);
            } else {
                // triggered - revert
                mainApp.populateMovieTable(0);
                newEditClicked = false;
                deleteClicked = false;
                newEditViewButton.setText("New / Edit Requests");

                mainApp.mainLayoutControllerInMain.bookmarkButton.setText("Bookmark");
                mainApp.mainLayoutControllerInMain.acceptRequestButton.setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteViewButton() {
        // show all movies that are flagged as a delete request
        // if user accepts request database will remove movie
        try {
            if (!deleteClicked) {
                // not triggered
                mainApp.populateMovieTable(2);
                deleteClicked = true;
                deleteViewButton.setText("View Published");
                newEditViewButton.setText("New / Edit Requests");
                mainApp.mainLayoutControllerInMain.acceptRequestButton.setDisable(false);
                mainApp.mainLayoutControllerInMain.bookmarkButton.setText("Veto");
                mainApp.mainLayoutControllerInMain.editButton.setVisible(true);
                mainApp.mainLayoutControllerInMain.newButton.setVisible(true);
                mainApp.mainLayoutControllerInMain.acceptRequestButton.setVisible(true);
            } else {
                // triggered - revert
                mainApp.populateMovieTable(0);
                deleteClicked = false;
                newEditClicked = false;
                deleteViewButton.setText("Delete Requests");

                mainApp.mainLayoutControllerInMain.bookmarkButton.setText("Bookmark");
                mainApp.mainLayoutControllerInMain.acceptRequestButton.setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        if (mainApp.isAdmin) {
            newEditViewButton.setVisible(true);
            deleteViewButton.setVisible(true);
        }
    }
}
