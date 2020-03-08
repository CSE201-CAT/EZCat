package EZCat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnector {
    protected Connection databaseConnection;


    public DatabaseConnector(String username, String password) throws SQLException {
        databaseConnection = DriverManager.getConnection("jdbc:mysql://35.239.39.240/ezcat_db",
                username, password);
    }


    public ObservableList<Movie> getMoviesList() throws SQLException {
        // query the DB
        Statement testS = databaseConnection.createStatement();
        ResultSet testR = testS.executeQuery("Select * from movie");

        // hold the movies
        ObservableList<Movie> movieDataList = FXCollections.observableArrayList();

        // Add to the list
        while (testR.next()) {
            Movie newMovie = new Movie();
            newMovie.setTitle(testR.getString("title"));
            newMovie.setGenre(testR.getString("genre"));
            newMovie.setStudio(testR.getString("studio"));
            newMovie.setYear(testR.getInt("yr"));
            newMovie.setDirector(testR.getString("director"));

            // add to list
            movieDataList.add(newMovie);
        }

        return movieDataList;
    }

    public void addMovie(Movie mv) throws SQLException {
        // setup insert statement
        String query = " INSERT INTO movie (title, genre, studio, yr, director) " +
                "VALUES (?, ?, ?, ?, ?);";

        // create prepared statement
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, mv.getTitle());
        preparedStatement.setString(2, mv.getGenre());
        preparedStatement.setString(3, mv.getStudio());
        preparedStatement.setInt(4, mv.getYear());
        preparedStatement.setString(5, mv.getDirector());

        // execute prepared statement
        preparedStatement.execute();
    }
}
