package EZCat.view;

import EZCat.Comment;
import EZCat.DatabaseConnector;
import EZCat.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentsLayoutController {
    @FXML
    private void handleSubmitComment() {
    }

    private Stage dialogStage;
    private Movie movie;
    private boolean okClicked = false;
    private ObservableList<Comment> commentData = FXCollections.observableArrayList();

    @FXML
    private TableView<Comment> commentTable;
    @FXML
    private TableColumn<Comment, String> commentColumn;

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
     */
    public void setMovieComments(Movie movie) {
        commentTable.setItems(commentData);
        commentData.clear();  // ensure empty to reduce copy size as it will be refreshed anyway
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String username = "general";
            String password = "generalPublicPassword";
            DatabaseConnector databaseConnector = new DatabaseConnector(username, password);

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
