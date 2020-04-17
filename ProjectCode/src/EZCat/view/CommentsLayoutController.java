package EZCat.view;

import EZCat.Comment;
import EZCat.DatabaseConnector;
import EZCat.Movie;
import EZCat.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentsLayoutController {
    @FXML
    private void handleSubmitComment() {
        String commentText = textCommentField.getText();  // collect text from the text field

        textCommentField.clear();

        // create the comment
        Comment newComment = new Comment(commentText, person.getId(), movie.getId());

        try {
            databaseConnector.addComment(newComment);
            commentData.add(newComment);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Stage dialogStage;
    private Movie movie;
    private Person person;
    private boolean okClicked = false;
    private ObservableList<Comment> commentData = FXCollections.observableArrayList();

    private DatabaseConnector databaseConnector;

    @FXML
    private TableView<Comment> commentTable;
    @FXML
    private TableColumn<Comment, String> commentColumn;
    @FXML
    private TextField textCommentField;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the movie table with the two columns.
        commentColumn.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
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
     * @param userPerson
     */
    public void setMovieComments(Movie selectedMovie, Person userPerson) {
        movie = selectedMovie;  // save the selected movie
        person = userPerson;  // save the current user

        commentTable.setItems(commentData);
        commentData.clear();  // ensure empty to reduce copy size as it will be refreshed anyway
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";
            databaseConnector = new DatabaseConnector(username, password);

            ResultSet list = databaseConnector.populateCommentsTable(movie.getId(), commentData);

            while (list.next()) {
                Comment newComment = new Comment();
                newComment.setComment(list.getString("comment"));
                newComment.setMovieId(list.getInt("movie_id"));
                newComment.setPersonId(list.getInt("person_id"));
                // add to list
                commentData.add(newComment);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("RIP DB CONNECTION");
        }
    }
}
