package EZCat.view;

import EZCat.*;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class PersonLayoutController {


    // Reference to the main application.
    private Main mainApp;

    public Person userPerson;
    private boolean okClicked = false;
    private Stage dialogStage;
    private Person person;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private ObservableList<MovieNameAndComment> movieCommentData = FXCollections.observableArrayList();
    private ObservableList<Movie> movieData = FXCollections.observableArrayList();
    private DatabaseConnector databaseConnector;

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
    public TableView<Person> personTable;

    @FXML
    public TableColumn<Person, String> usernameColumn;

    @FXML
    public void initialize() throws SQLException {
        setPeople();
        personTable.setItems(databaseConnector.getPeopleData());
        // Initialize the movie table with the  columns.
        usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());

        // clear movie details
        showPersonDetails(null, false);

        // Listen for selection changes and show the movie details when changed
        personTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    try {
                        showPersonDetails(newValue, false);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                });
    }

    public void callSetUserPerson(Person person) {setUserPerson(person);}

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

    public void handleSearchUsersButton(ActionEvent actionEvent) {
        String request = "";

        // grab text from search bar
        request = searchBarField.getText();
        // submit query search
        try {
            databaseConnector.filterPersonTable(request);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void handleFollowUserButton(ActionEvent actionEvent) throws SQLException {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        databaseConnector.addFollow(userPerson, personTable.getItems().get(selectedIndex));
    }

    public void showPersonDetails(Person person, boolean currentUser) throws SQLException {
        if (person != null) {
            movieCommentTable.setItems(databaseConnector.getMovieCommentData());
            // Fill the labels with info from the person object.
            usernameLabel.setText(person.getUsername());

            if (currentUser) {
                // show current user profile by default
                setMovieComment(true);
            } else {
                setMovieComment(false);
            }

            int i = 0;
            movieCommentTable.setItems(databaseConnector.getMovieCommentData());
            commentColumn.setCellValueFactory(cellData -> cellData.getValue().getComment().commentProperty());
            movieColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        } else {
            // Person is null, remove all the text.
            usernameLabel.setText("");
        }
    }

    /**
     * Sets the movie to be edited in the dialog.
     */
    public void setPeople() {
        person = userPerson;  // save the current user

        personTable.setItems(personData);
        personData.clear();  // ensure empty to reduce copy size as it will be refreshed anyway
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";
            databaseConnector = new DatabaseConnector(username, password);

            ResultSet list = databaseConnector.populatePeopleTable();

            while (list.next()) {
                Person newPerson = new Person();
                newPerson.setUsername(list.getString("username"));
                newPerson.setId(list.getInt("person_id"));
                // add to list
                personData.add(newPerson);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("RIP DB CONNECTION");
        }
    }

    public void setMovieComment(boolean currentUser) {
        person = userPerson;  // save the current user
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        movieCommentData.clear();  // ensure empty to reduce copy size as it will be refreshed anyway
        movieData.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";
            databaseConnector = new DatabaseConnector(username, password);

            ResultSet list;
            if (currentUser) {
                // show current user by default
                 list = databaseConnector.populateMovieCommentsTable(person.getId(), movieCommentData);
            } else {
                list = databaseConnector.populateMovieCommentsTable(personTable.getItems().get(selectedIndex).getId(),
                        movieCommentData);
            }


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


}
