package EZCat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

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
        Main.movieTablePopulationLoop(testR, movieDataList);

        return movieDataList;
    }

    public void addMovie(Movie mv) throws SQLException {
        // setup insert statement
        String query = " INSERT INTO movie (title, genre, studio, yr, director, isPublished) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        // create prepared statement
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, mv.getTitle());
        preparedStatement.setString(2, mv.getGenre());
        preparedStatement.setString(3, mv.getStudio());
        preparedStatement.setInt(4, mv.getYear());
        preparedStatement.setString(5, mv.getDirector());
        preparedStatement.setInt(6, mv.getPublished() ? 1 : 0);

        // execute prepared statement
        preparedStatement.execute();
    }

    public void deleteMovie(Movie mv) throws SQLException {
        // setup delete statement
        String query = " DELETE FROM movie where movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, mv.getId());

        // execute prepared statement
        preparedStatement.execute();
    }

    public void updateMovie(Movie mv) throws SQLException {
        // setup update statement
        String query = "update movie set title = ?, genre = ?, studio = ?, yr = ?, director = ?, isPublished = ? where movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, mv.getTitle());
        preparedStatement.setString(2, mv.getGenre());
        preparedStatement.setString(3, mv.getStudio());
        preparedStatement.setInt(4, mv.getYear());
        preparedStatement.setString(5, mv.getDirector());
        preparedStatement.setInt(6, mv.getId());
        preparedStatement.setInt(7, mv.getPublished() ? 1 : 0);

        // execute prepared statement
        preparedStatement.execute();
    }

    public ArrayList<String> listAdmins() throws SQLException {
        Statement testS = databaseConnection.createStatement();
        ResultSet testR = testS.executeQuery("SELECT username FROM people WHERE isAdmin = 1");

        // hold the movies
       ArrayList<String> adminUsers = new ArrayList<>();

        // Add to the list
        while (testR.next()) {
            // add to list
            adminUsers.add(testR.getString("username"));
        }

        return adminUsers;
    }

    public boolean loginUser(String usern, String passwd) throws SQLException {
        String query = "SELECT username FROM people WHERE passwd = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, passwd);

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // Add to the list
        while (resultSet.next()) {
            // add to list
            if (usern.equals(resultSet.getString("username"))) {
                return true;
            }
            System.out.println(resultSet.getString("username"));
        }

        // user not found
        return false;
    }

    public boolean createUser(Person person) throws SQLException {
        String query = "SELECT username FROM people";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // Add to the list
        while (resultSet.next()) {
            // add to list
            if (person.getUsername().equals(resultSet.getString("username"))) {
                System.out.println("User Exists");
                return false;
            }
            System.out.println(resultSet.getString("username"));
        }

        // setup insert statement
        String query2 = " INSERT INTO people (username, passwd, isAdmin) " +
                "VALUES (?, ?, ?);";

        // create prepared statement
        PreparedStatement preparedStatement2 = databaseConnection.prepareStatement(query2);
        preparedStatement2.setString(1, person.getUsername());
        preparedStatement2.setString(2, person.getPassword());
        preparedStatement2.setInt(3, person.getAdmin() ? 1 : 0);

        // execute prepared statement
        preparedStatement2.execute();

        // user account made / now logged in
        return true;
    }
}
