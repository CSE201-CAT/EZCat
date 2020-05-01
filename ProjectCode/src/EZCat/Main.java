package EZCat;

import EZCat.view.*;
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

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    public DatabaseConnector dbCon;
    public boolean isAdmin = false;
    public Person userPerson;
    public RootLayoutController rootLayoutControllerInMain;
    public MainLayoutController mainLayoutControllerInMain;

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

            // Give the controller access to the main app.
            rootLayoutControllerInMain = loader.getController();
            rootLayoutControllerInMain.setMainApp(this);
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
            mainLayoutControllerInMain = loader.getController();

            mainLayoutControllerInMain.setMainApp(this);
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
            controller.setMovieComments(movie, userPerson);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean showSelfPersonDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/personSelfLayout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Following");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the movie into the controller.
            PersonSelfLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFollowing(userPerson);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean showPersonDialog(boolean showSelf) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/personLayout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("People");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the movie into the controller.
            PersonLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.callSetUserPerson(userPerson);

            if (showSelf) {
                // show the current user's profile
                controller.showPersonDetails(userPerson, true);
            }
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Opens a dialog add a rating for the specified movie.
     *
     * @param movie the movie object to be viewed
     * @param tmpRating
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showMovieRatingDialog(Movie movie, Rating tmpRating) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ratingsLayout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Movie Rating Page");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the movie into the controller.
            RatingLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            controller.setMovieRating(movie, tmpRating, userPerson);

            // update movie rating
            movie.setRating(dbCon.ratingCalculation(movie));

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
        // connect to the database
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";

            dbCon = new DatabaseConnector(username, password);

            populateMovieTable(0);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("RIP DB CONNECTION");
        }
    }


    /**
     * Filter the movie table with movies that meet the criteria
     * @param filter What to filter by. Will filter by genre, studio, director
     * @param adminListType Which type of table to filter: 0 = published, 1 = new / edit requests, 2 = delete requests
     * @throws SQLException
     */
    public void filterMovieTable(String filter, int adminListType) throws SQLException {
        if (userPerson != null) {
            isAdmin = userPerson.getAdmin();
        }
        movieData.clear();

        PreparedStatement preparedStatement = null;

        if (isAdmin && adminListType == 1) {
            // filter new / edit requests
            String query = "SELECT * FROM movie WHERE (director LIKE ?" +
                    "OR genre LIKE ?" +
                    "OR studio LIKE ? ) AND isPublished = 0 and deleteRequest = 0;";
            preparedStatement = dbCon.databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, "%" + filter + "%");
            preparedStatement.setString(2, "%" + filter + "%");
            preparedStatement.setString(3, "%" + filter + "%");
        } else if (isAdmin && adminListType == 2) {
            // filter delete requests
            String query = "SELECT * FROM movie WHERE (director LIKE ?" +
                    "OR genre LIKE ?" +
                    "OR studio LIKE ? ) AND deleteRequest = 1;";
            preparedStatement = dbCon.databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, "%" + filter + "%");
            preparedStatement.setString(2, "%" + filter + "%");
            preparedStatement.setString(3, "%" + filter + "%");
        } else {
            // filter general movie table
            String query = "SELECT * FROM movie WHERE (director LIKE ?" +
                    "OR genre LIKE ?" +
                    "OR studio LIKE ? ) AND isPublished = 1;";
            preparedStatement = dbCon.databaseConnection.prepareStatement(query);
            preparedStatement.setString(1, "%" + filter + "%");
            preparedStatement.setString(2, "%" + filter + "%");
            preparedStatement.setString(3, "%" + filter + "%");
        }

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // Add to the list
        movieTablePopulationLoop(resultSet, movieData);
    }

    /**
     * Populate the movie table with movies
     * @param listType 0 = published, 1 = new / edit requests, 2 = delete requests, 3 = bookmarked (for that user)
     * @throws SQLException
     */
    public void populateMovieTable(int listType) throws SQLException {
        if (userPerson != null) {
            isAdmin = userPerson.getAdmin();
        }
        movieData.clear();
        Statement populateTable = dbCon.databaseConnection.createStatement();
        ResultSet populateResult;
        if (listType == 0) {
            // published
            populateResult = populateTable.executeQuery("Select * from movie where isPublished = 1");
        } else if (isAdmin && listType == 1) {
            // new / edit requests
            populateResult = populateTable.executeQuery("Select * from movie where isPublished = 0 and deleteRequest = 0");
        } else if (isAdmin && listType == 2) {
            // delete
            populateResult = populateTable.executeQuery("Select * from movie where deleteRequest = 1");
        } else {
            // user's bookmarks
            System.out.println("here: id = " + userPerson.getId());
            String query = "SELECT * " +
                    "FROM bookmarks b, movie m, people p " +
                    "WHERE b.person_id = p.person_id AND " +
                    "m.movie_id = b.movie_id AND " +
                    "b.person_id = ?";
            PreparedStatement preparedStatement = dbCon.databaseConnection.prepareStatement(query);
            preparedStatement.setInt(1, userPerson.getId());

            populateResult = preparedStatement.executeQuery();
        }

        // Add to the list
        movieTablePopulationLoop(populateResult, movieData);
    }



    public static void movieTablePopulationLoop(ResultSet populateResult, ObservableList<Movie> movieData) throws SQLException {
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
    }




    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EZCat Movie App");

        initRootLayout();

        showMovieOverview();


        userPerson = displayLogin();
        if (userPerson.getUsername() == null) {
            // did not log in but got around login box
            System.exit(0);
        }

        // set if user is admin or not
        isAdmin = userPerson.getAdmin();
    }

    /**
     * Opens a dialog to login to the application.
     *
     * @return true if the user logged in, false otherwise.
     */
    public Person displayLogin() {
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
                rootLayoutControllerInMain.deleteViewButton.setDisable(false);
                rootLayoutControllerInMain.newEditViewButton.setDisable(false);
                try {
                    movieData.clear();
                    Class.forName("com.mysql.jdbc.Driver");

                    String username = "general";
                    String password = "generalPublicPassword";

                    dbCon = new DatabaseConnector(username, password);

                    populateMovieTable(0);

                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("RIP DB CONNECTION");
                }
            } else {
                rootLayoutControllerInMain.deleteViewButton.setVisible(false);
                rootLayoutControllerInMain.newEditViewButton.setVisible(false);
            }

            return controller.isOkClicked();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
