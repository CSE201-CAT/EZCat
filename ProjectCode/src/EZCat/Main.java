package EZCat;

import EZCat.view.CommentsLayoutController;
import EZCat.view.LoginLayoutController;
import EZCat.view.MainLayoutController;
import EZCat.view.MovieEditDialogController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    public DatabaseConnector dbCon;
    public boolean isAdmin;

    /**
     * The data as an observable list of Movies.
     */
    private ObservableList<Movie> movieData = FXCollections.observableArrayList();


    /**
     * Returns the data as an observable list of Movies.
     * @return
     */
    public ObservableList<Movie> getMovieData() {
        return movieData;
    }


    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Shows the movie overview inside the root layout.
     */
    public void showMovieOverview() {
        try {
            // Load movie overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainLayout.fxml"));
            AnchorPane movieOverview = (AnchorPane) loader.load();

            // Set movie overview into the center of root layout.
            rootLayout.setCenter(movieOverview);

            // Give the controller access to the main app.
            MainLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified movie. If the user
     * clicks OK, the changes are saved into the provided movie object and true
     * is returned.
     *
     * @param movie the movie object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showMovieEditDialog(Movie movie) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MovieEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Movie");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the movie into the controller.
            MovieEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMovie(movie);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Opens a dialog to view and add comments for the specified movie.
     *
     * @param movie the movie object to be viewed
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showMovieCommentsDialog(Movie movie) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/commentsLayout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Movie Comments");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the movie into the controller.
            CommentsLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMovieComments(movie);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }




    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    /**
     * Constructor
     */
    public Main() {
////         Add some sample data
//        movieData.add(new Movie("title01", "genre01"));
//        movieData.add(new Movie("title02", "genre02"));

        // connect to the database
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";

            dbCon = new DatabaseConnector(username, password);

            // test connection -- uncomment out below
            Statement populateTable = dbCon.databaseConnection.createStatement();
            ResultSet populateResult = populateTable.executeQuery("Select * from movie");
            // Add to the list
            while (populateResult.next()) {
                Movie newMovie = new Movie();
                newMovie.setTitle(populateResult.getString("title"));
                newMovie.setGenre(populateResult.getString("genre"));
                newMovie.setStudio(populateResult.getString("studio"));
                newMovie.setYear(populateResult.getInt("yr"));
                newMovie.setDirector(populateResult.getString("director"));
                newMovie.setId(populateResult.getInt("movie_id"));
                newMovie.setIsPublished(populateResult.getInt("isPublished") == 1);

                // add to list
                movieData.add(newMovie);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("RIP DB CONNECTION");
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EZCat Movie App");

        initRootLayout();

        showMovieOverview();

        if (!displayLogin()) {
            // did not log in but got around login box
            System.exit(0);
        }
    }

    /**
     * Opens a dialog to login to the application.
     *
     * @return true if the user logged in, false otherwise.
     */
    public boolean displayLogin() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/loginLayout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Login To EZCat");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the login controller.
            LoginLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            if (controller.isAuthorised("", dbCon)) {
                // user is authorised
                isAdmin = true;
            } else {
                // user is not authorised
                isAdmin = false;
            }

            return controller.isOkClicked();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
