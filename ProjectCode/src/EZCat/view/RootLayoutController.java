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

    private boolean newEditClicked = false;
    private boolean deleteClicked = false;

    @FXML
    private void handleViewProfileButton() {
        System.out.println("in view profile");
    }

    @FXML
    private void handlePeopleViewButton() {
        System.out.println("in people view");
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
//                deleteViewButton.setText("Delete Requests");
            } else {
                // triggered - revert
                mainApp.populateMovieTable(0);
                newEditClicked = false;
                deleteClicked = false;
                newEditViewButton.setText("New / Edit Requests");
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
//                newEditViewButton.setText("New / Edit Requests");
            } else {
                // triggered - revert
                mainApp.populateMovieTable(0);
                deleteClicked = false;
                newEditClicked = false;
                deleteViewButton.setText("Delete Requests");
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
