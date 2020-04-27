package EZCat.view;

import EZCat.*;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;

public class PersonSelfLayoutController {

    // Reference to the main application.
    private Main mainApp;

    public Person userPerson;
    private boolean okClicked = false;
    private Stage dialogStage;
    private Person person;
    private ObservableList<Person> followingData = FXCollections.observableArrayList();
    private ObservableList<MovieNameAndComment> movieCommentData = FXCollections.observableArrayList();
    private ObservableList<Movie> movieData = FXCollections.observableArrayList();
    private DatabaseConnector databaseConnector;

    @FXML
    public Button searchButton;
    @FXML
    public TableColumn<MovieNameAndComment, String> commentColumn;
    @FXML
    public TableColumn<MovieNameAndComment, String> movieColumn;
    @FXML
    public TableView movieCommentTable;
    @FXML
    public Label usernameLabel;
    @FXML
    public TextField searchBarField;

    @FXML
    private TableView<Person> personTable;

    @FXML
    public TableColumn<Person, String> usernameColumn;



    @FXML
    public void initialize() throws SQLException {
        usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        // clear movie details
        showPersonDetails(null);
        // Listen for selection changes and show the movie details when changed
        personTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    try {
                        showPersonDetails(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                });
    }


    public void setUserPerson(Person person) {userPerson = person;}

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

    public void handleFollowUserButton(ActionEvent actionEvent) throws SQLException {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        databaseConnector.addFollow(userPerson, personTable.getItems().get(selectedIndex));
    }

    private void showPersonDetails(Person person) throws SQLException {
        if (person != null) {
            movieCommentTable.setItems(databaseConnector.getMovieCommentData());
            // Fill the labels with info from the person object.
            usernameLabel.setText(person.getUsername());
            setMovieComment();
            int i = 0;
            movieCommentTable.setItems(databaseConnector.getMovieCommentData());
            commentColumn.setCellValueFactory(cellData -> cellData.getValue().getComment().commentProperty());
            movieColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        } else {
            // Person is null, remove all the text.
            usernameLabel.setText("");
        }
    }



    public void setMovieComment() {
        person = userPerson;  // save the current user
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        System.out.println(personTable.getItems().get(selectedIndex).getId());
        movieCommentData.clear();  // ensure empty to reduce copy size as it will be refreshed anyway
        movieData.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";
            databaseConnector = new DatabaseConnector(username, password);

            ResultSet list = databaseConnector.populateMovieCommentsTable( personTable.getItems().get(selectedIndex).getId(), movieCommentData);

            while (list.next()) {
                Comment newComment = new Comment();
                newComment.setComment(list.getString("comment"));
                newComment.setMovieId(list.getInt("movie_id"));
                newComment.setPersonId(list.getInt("person_id"));
                // add to list
                Movie movieName = databaseConnector.getSpecificMovie(newComment.getMovieId());
                MovieNameAndComment mvncm = new MovieNameAndComment(movieName.getTitle(), newComment);
                movieCommentData.add(mvncm);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("RIP DB CONNECTION");
        }
    }

    public void setMovie(Comment comment) {
        person = userPerson;  // save the current user
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        movieCommentData.clear();  // ensure empty to reduce copy size as it will be refreshed anyway
        movieData.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";
            databaseConnector = new DatabaseConnector(username, password);

            ResultSet list = databaseConnector.populateMovieCommentsTable( personTable.getItems().get(selectedIndex).getId(), movieCommentData);

            while (list.next()) {
                Comment newComment = new Comment();
                newComment.setComment(list.getString("comment"));
                newComment.setMovieId(list.getInt("movie_id"));
                newComment.setPersonId(list.getInt("person_id"));
                // add to list
                Movie movieName = databaseConnector.getSpecificMovie(newComment.getMovieId());
                MovieNameAndComment mvncm = new MovieNameAndComment(movieName.getTitle(), newComment);
                movieCommentData.add(mvncm);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("RIP DB CONNECTION");
        }
    }

    /**
     * Sets the movie to be edited in the dialog.
     */
    public void setFollowing(Person userPerson) {
        person = userPerson;  // save the current user

        personTable.setItems(followingData);
        followingData.clear();  // ensure empty to reduce copy size as it will be refreshed anyway
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";
            databaseConnector = new DatabaseConnector(username, password);

            ResultSet list = databaseConnector.populateFollowingTable(userPerson);
            while (list.next()) {
                Person newPerson = databaseConnector.getSpecificPerson(list.getInt("following_id"));
                // add to list
                followingData.add(newPerson);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("RIP DB CONNECTION");
        }
    }

}
