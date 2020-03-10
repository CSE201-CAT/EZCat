package EZCat.view;

import EZCat.Main;
import EZCat.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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


    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteMovie() {
        int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            try {
                mainApp.dbCon.deleteMovie(movieTable.getItems().get(selectedIndex));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            movieTable.getItems().remove(selectedIndex);
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
            mainApp.getMovieData().add(tmpMovie);
            try {
                if (mainApp.isAdmin) {
                    // user is admin - autopublish movie
                    tmpMovie.setIsPublished(true);
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
                try {
                    if (mainApp.isAdmin) {
                        // user is admin - autopublish movie
                        selectedMovie.setIsPublished(true);
                    }
                    mainApp.dbCon.updateMovie(selectedMovie);
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
