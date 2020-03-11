package EZCat.view;

import EZCat.Main;
import EZCat.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainLayoutController {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    public TableView<Movie> movieTable;
    @FXML
    private TableColumn<Movie, String> titleColumn;
    @FXML
    private TableColumn<Movie, String> genreColumn;
    @FXML
    private Label titleLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label directorLabel;
    @FXML
    private Label ratingLabel;
    @FXML
    private Label studioLabel;
    @FXML
    public Button acceptRequestButton;
    @FXML
    private TextField searchBarField;


    /**
     * Fills all text fields to show details about the movie.
     * If the specified movie is null, all text fields are cleared.
     *
     * @param movie the movie or null
     */
    private void showMovieDetails(Movie movie) {
        if (movie != null) {
            // Fill the labels with info from the movie object.
            titleLabel.setText(movie.getTitle());
            genreLabel.setText(movie.getGenre());
            ratingLabel.setText(Double.toString(movie.getRating()));
            directorLabel.setText(movie.getDirector());
            yearLabel.setText(String.valueOf((movie.getYear())));
            studioLabel.setText(movie.getStudio());
        } else {
            // Movie is null, remove all the text.
            titleLabel.setText("");
            genreLabel.setText("");
            ratingLabel.setText("");
            directorLabel.setText("");
            yearLabel.setText("");
            studioLabel.setText("");
        }
    }

    private void notifyUser(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }


    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteMovie() {
        int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            try {
                if (mainApp.isAdmin) {
                    // admin can just remove
                    mainApp.dbCon.deleteMovie(movieTable.getItems().get(selectedIndex));
                    movieTable.getItems().remove(selectedIndex);
                } else {
                    // not admin - request to remove
                    Movie tmpM = movieTable.getItems().get(selectedIndex);
                    tmpM.setToDelete(true);
                    mainApp.dbCon.updateMovie(tmpM);
                    notifyUser("Request Submitted", "Delete Request Sent To Admins", "");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Movie Selected");
            alert.setContentText("Please select a movie in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new movie.
     */
    @FXML
    private void handleNewMovie() {
        Movie tmpMovie = new Movie();
        boolean okClicked = mainApp.showMovieEditDialog(tmpMovie);
        if (okClicked) {
            try {
                if (mainApp.isAdmin) {
                    // user is admin - autopublish movie
                    tmpMovie.setIsPublished(true);
                    mainApp.getMovieData().add(tmpMovie);
                } else {
                    notifyUser("Request Submitted", "Add Request Sent To Admins", "");
                }
                mainApp.dbCon.addMovie(tmpMovie);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected movie.
     */
    @FXML
    private void handleEditMovie() {
        Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            boolean okClicked = mainApp.showMovieEditDialog(selectedMovie);
            if (okClicked) {
                showMovieDetails(selectedMovie);
                System.out.println("Edited: " + selectedMovie);
                try {
                    if (mainApp.isAdmin) {
                        // user is admin - autopublish movie
                        selectedMovie.setIsPublished(true);
                        mainApp.dbCon.updateMovie(selectedMovie);
                    } else {
                        selectedMovie.setOldMovieID(selectedMovie.getId());  // this is what will be deleted if approved
                        selectedMovie.setId(-1);  // reset actual movie id so it is unique
                        selectedMovie.setIsPublished(false);  // this one is not approved so not published
                        mainApp.dbCon.addMovie(selectedMovie);
                        notifyUser("Request Submitted", "Edit Request Sent To Admins", "");
                        System.out.println("Sent: " + selectedMovie);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Movie Selected");
            alert.setContentText("Please select a movie in the table.");

            alert.showAndWait();
        }
    }


    @FXML
    private void handleViewCommentsPage() {
        Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            boolean okClicked = mainApp.showMovieCommentsDialog(selectedMovie);
            if (okClicked) {
                showMovieDetails(selectedMovie);
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Movie Selected");
            alert.setContentText("Please select a movie in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleAcceptRequest() {
        Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();

        if (selectedMovie != null) {
            // must determine what request action to take
            if (!selectedMovie.getPublished() && selectedMovie.getOldMovieID() == -1) {
                // movie is not published and there is no old movie index
                // -- means new movie request

                selectedMovie.setIsPublished(true);  // set to be a published movie
                try {
                    mainApp.dbCon.updateMovie(selectedMovie);  // update to be published
                    movieTable.getItems().remove(selectedIndex);  // remove from request list
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (!selectedMovie.getPublished() && selectedMovie.getOldMovieID() != -1) {
                // movie is not published and there is an old movie index
                // -- means edit movie request

                try {
                    mainApp.dbCon.deleteMovie(selectedMovie.getOldMovieID());  // remove current published entry
                    selectedMovie.setIsPublished(true);  // set new version to be published
                    selectedMovie.setOldMovieID(-1);  // remove oldMovieID
                    movieTable.getItems().remove(selectedIndex); // remove from request list
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (selectedMovie.getPublished() && selectedMovie.getToDelete()) {
                // movie is already published and delete desire is flagged
                // -- means that movie deletion is desired

                try {
                    mainApp.dbCon.deleteMovie(selectedMovie);  // remove current movie
                    movieTable.getItems().remove(selectedIndex); // remove from request list
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Nothing selected.
            notifyUser("No Selection", "No Movie Request Selected", "Please select a movie in the table");
        }
    }


    @FXML
    private void handleSearchRequest() {
        String request = "";

        // grab text from search bar
        request = searchBarField.getText();

        // submit query search
        try {
            if (mainApp.rootLayoutControllerInMain.newEditClicked) {
                // filter only new / edit movie requests
                System.out.println("filter new edit");
                mainApp.filterMovieTable(request, 1);
            } else if (mainApp.rootLayoutControllerInMain.deleteClicked) {
                // filter only delete movie requests
                System.out.println("Filter delete");
                mainApp.filterMovieTable(request, 2);
            } else {
                // filter general movies only
                System.out.println("filter general");
                mainApp.filterMovieTable(request, 0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        // Initialize the movie table with the two columns.
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        genreColumn.setCellValueFactory(cellData -> cellData.getValue().genreProperty());

        // clear movie details
        showMovieDetails(null);

        // Listen for selection changes and show the movie details when changed
        movieTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showMovieDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        movieTable.setItems(mainApp.getMovieData());
    }
}
