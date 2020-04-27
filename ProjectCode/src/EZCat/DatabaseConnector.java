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

    /**
     * Returns the data as an observable list of People.
     * @return
     */
    public ObservableList<Person> getPeopleData() {
        return peopleData;
    }

    public ObservableList<Person> getFollowingData() {
        return followingData;
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
        String query = " INSERT INTO movie (title, genre, studio, yr, director, isPublished, deleteRequest, editMovieID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        // create prepared statement
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, mv.getTitle());
        preparedStatement.setString(2, mv.getGenre());
        preparedStatement.setString(3, mv.getStudio());
        preparedStatement.setInt(4, mv.getYear());
        preparedStatement.setString(5, mv.getDirector());
        preparedStatement.setInt(6, mv.getPublished() ? 1 : 0);
        preparedStatement.setInt(7, mv.getToDelete() ? 1 : 0);
        preparedStatement.setInt(8, mv.getOldMovieID());
        System.out.println(preparedStatement.toString());
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

    public void deleteMovie(int id) throws SQLException {
        // setup delete statement
        String query = " DELETE FROM movie where movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        // execute prepared statement
        preparedStatement.execute();
    }

    public void updateMovie(Movie mv) throws SQLException {
        // setup update statement
        String query = "update movie set title = ?, genre = ?, studio = ?, yr = ?, director = ?, isPublished = ?, deleteRequest = ?, editMovieID = ? where movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, mv.getTitle());
        preparedStatement.setString(2, mv.getGenre());
        preparedStatement.setString(3, mv.getStudio());
        preparedStatement.setInt(4, mv.getYear());
        preparedStatement.setString(5, mv.getDirector());
        preparedStatement.setInt(6, mv.getPublished() ? 1 : 0);
        preparedStatement.setInt(7, mv.getToDelete() ? 1 : 0);
        preparedStatement.setInt(8, mv.getOldMovieID());
        preparedStatement.setInt(9, mv.getId());

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

    public int getUserID(String username) throws SQLException {
        String query = "SELECT person_id FROM people WHERE username = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, username);

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // Add to the list
        while (resultSet.next()) {
            // add to list
            return resultSet.getInt("person_id");
        }

        // nothing found
        return -1;
    }

    public void addBookmark(Movie selectedMovie, Person person) throws SQLException {
        // setup insert statement
        String query2 = "INSERT INTO bookmarks " +
                "(person_id, movie_id) " +
                "VALUES (?, ?);";

        // create prepared statement
        PreparedStatement preparedStatement2 = databaseConnection.prepareStatement(query2);
        preparedStatement2.setInt(2, selectedMovie.getId());
        preparedStatement2.setInt(1, person.getId());

        // execute prepared statement
        preparedStatement2.execute();
    }

    public void removeBookmark(Movie selectedMovie, Person person) throws SQLException {
        // setup insert statement
        String query2 = "DELETE FROM bookmarks " +
                "WHERE person_id = ? AND " +
                "movie_id = ?;";

        // create prepared statement
        PreparedStatement preparedStatement2 = databaseConnection.prepareStatement(query2);
        preparedStatement2.setInt(2, selectedMovie.getId());
        preparedStatement2.setInt(1, person.getId());

        // execute prepared statement
        preparedStatement2.execute();
    }

    
    public ObservableList<Comment> getCommentList() throws SQLException {
        // query the DB
        Statement testS = databaseConnection.createStatement();
        ResultSet testR = testS.executeQuery("Select * from comments");

        // hold the comments
        ObservableList<Comment> commentDataList = FXCollections.observableArrayList();

        // Add to the list
        commentTablePopulationLoop(testR, commentDataList);

        return commentDataList;
    }
    
    public void addComment(Comment cm) throws SQLException {
        // setup insert statement
        String query = " INSERT INTO comments (person_id,  movie_id, comment) " +
                "VALUES (?, ?, ?);";

        // create prepared statement
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, cm.getPersonId());
        preparedStatement.setInt(2, cm.getMovieId());
        preparedStatement.setString(3, cm.getComment());

        // execute prepared statement
        preparedStatement.execute();
    }

    public void deleteComment(Comment cm) throws SQLException {
        // setup delete statement
        String query = " DELETE FROM comments where comment = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, cm.getComment());

        // execute prepared statement
        preparedStatement.execute();
    }
    
    public void addRating(Rating r) throws SQLException {
        // setup insert statement
        String query = " INSERT INTO ratings (person_id,  movie_id, rating) " +
                "VALUES (?, ?, ?)" +
                " ON DUPLICATE KEY UPDATE" +
                " rating = ?;";

        // create prepared statement
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, r.getPersonId());
        preparedStatement.setInt(2, r.getMovieId());
        preparedStatement.setDouble(3, r.getRating());
        preparedStatement.setDouble(4, r.getRating());

        // execute prepared statement
        preparedStatement.execute();
    }

    public void deleteRating(Rating r) throws SQLException {
        // setup delete statement
        String query = " DELETE FROM ratings where rating = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setDouble(1, r.getRating());

        // execute prepared statement
        preparedStatement.execute();
    }
    
    public ObservableList<Rating> getRatingList() throws SQLException {
        // query the DB
        Statement testS = databaseConnection.createStatement();
        ResultSet testR = testS.executeQuery("Select * from ratings");

        // hold the comments
        ObservableList<Rating> ratingDataList = FXCollections.observableArrayList();

        // Add to the list
        ratingTablePopulationLoop(testR, ratingDataList);

        return ratingDataList;
    }

    public double ratingCalculation(Movie movie) throws SQLException {
        // query the DB
        String query = "SELECT AVG(rating) as avgRating FROM ratings where movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, movie.getId());

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // Add to the list
        while (resultSet.next()) {
            // add to list
            return resultSet.getDouble("avgRating");
        }

        // nothing found
        return -1;
    }
    
    public static void ratingTablePopulationLoop(ResultSet populateResult, ObservableList<Rating> ratingData) throws SQLException {
        while (populateResult.next()) {
            Rating newRating = new Rating();
            newRating.setRating(populateResult.getDouble("comment"));
            newRating.setPersonId(populateResult.getInt("personId"));
            newRating.setMovieId(populateResult.getInt("movieId"));

            // add to list
            ratingData.add(newRating);
        }
    }

    public boolean checkNoRatings(Movie movie) throws SQLException {
        String query = "SELECT rating FROM ratings where movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, movie.getId());

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // check if empty
        if (!resultSet.next()) {
            // no ratings
            return true;
        }

        // found ratings
        return false;
    }

    /**
     * Populate the comments table with movie comments
     * @throws SQLException
     * @return
     */
    public ResultSet populateCommentsTable(int movieID, ObservableList<Comment> commentData) throws SQLException {
        commentData.clear();  // ensure empty
        Statement populateTable = databaseConnection.createStatement();
        ResultSet populateResult;
        String query = "SELECT * " +
             "FROM comments " +
             "WHERE " +
             "movie_id = ?";
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setInt(1, movieID);

            populateResult = preparedStatement.executeQuery();

        // Add to the list
        return populateResult;
    }

    public ResultSet populateMovieCommentsTable(int personID, ObservableList<MovieNameAndComment> commentData) throws SQLException {
        commentData.clear();  // ensure empty
        Statement populateTable = databaseConnection.createStatement();
        ResultSet populateResult;
        String query = "SELECT * " +
                "FROM comments " +
                "WHERE " +
                "person_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, personID);

        populateResult = preparedStatement.executeQuery();

        movieCommentTablePopulationLoop(populateResult, movieCommentData);

        // Add to the list
        return populateResult;
    }

    public ObservableList<Movie> movieData = FXCollections.observableArrayList();

    public ObservableList<Person> followingData = FXCollections.observableArrayList();

    public ResultSet populateMoviesTable(int movieID, ObservableList<Movie> movieData) throws SQLException {
        movieData.clear();  // ensure empty
        Statement populateTable = databaseConnection.createStatement();
        ResultSet populateResult;
        String query = "SELECT * " +
                "FROM movies " +
                "WHERE " +
                "movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, movieID);

        populateResult = preparedStatement.executeQuery();
        populateResult = preparedStatement.executeQuery();

        Main.movieTablePopulationLoop(populateResult, movieData);

        // Add to the list
        return populateResult;
    }

    public ObservableList<MovieNameAndComment> getMovieCommentData() {
        return movieCommentData;
    }

    public ObservableList<Person> peopleData = FXCollections.observableArrayList();
    public ObservableList<MovieNameAndComment> movieCommentData = FXCollections.observableArrayList();

    public ResultSet populatePeopleTable() throws SQLException {
        peopleData.clear();
        Statement populateTable = databaseConnection.createStatement();
        ResultSet populateResult;
        populateResult = populateTable.executeQuery("Select * from people");


        // Add to the list
        peopleTablePopulationLoop(populateResult, peopleData);

        return populateResult;
    }

    public ResultSet populateFollowingTable(Person userPerson) throws SQLException {
        followingData.clear();
        Statement populateTable = databaseConnection.createStatement();
        ResultSet populateResult;
        populateResult = populateTable.executeQuery("Select * from followers WHERE follower_id = " + userPerson.getId());
        // Add to the list
        // followingTablePopulationLoop(populateResult, followingData);

        return populateResult;
    }

    public ObservableList<Person> followingTablePopulationLoop(ResultSet populateResult,
                                                                     ObservableList<Person> followingData) throws SQLException {
        while (populateResult.next()) {
            Person newPerson = new Person();
            newPerson.setId(populateResult.getInt("following_id"));
            // add to list
            followingData.add(newPerson);
        }

        return followingData;
    }

    public static ObservableList<Comment> commentTablePopulationLoop(ResultSet populateResult,
                                                  ObservableList<Comment> commentData) throws SQLException {
        while (populateResult.next()) {
            Comment newComment = new Comment();
            newComment.setComment(populateResult.getString("comment"));
            newComment.setMovieId(populateResult.getInt("movie_id"));
            newComment.setPersonId(populateResult.getInt("person_id"));
            System.out.println(newComment);
            // add to list
            commentData.add(newComment);
        }

        return commentData;
    }

    public ObservableList<MovieNameAndComment> movieCommentTablePopulationLoop(ResultSet populateResult,
                                                                     ObservableList<MovieNameAndComment> commentData) throws SQLException {
        while (populateResult.next()) {
            Comment newComment = new Comment();
            newComment.setComment(populateResult.getString("comment"));
            newComment.setMovieId(populateResult.getInt("movie_id"));
            newComment.setPersonId(populateResult.getInt("person_id"));
            Movie movieName = new Movie();
            movieName = getSpecificMovie(newComment.getMovieId());
            MovieNameAndComment mvncm = new MovieNameAndComment(movieName.getTitle(), newComment);
            movieCommentData.add(mvncm);
        }
        return movieCommentData;
    }

    public static ObservableList<Person> peopleTablePopulationLoop(ResultSet populateResult, ObservableList<Person> peopleData) throws SQLException {
        while (populateResult.next()) {
            Person newPerson = new Person();
            newPerson.setId(populateResult.getInt("person_id"));
            newPerson.setUsername(populateResult.getString("username"));

            // add to list
            peopleData.add(newPerson);
        }
        return peopleData;
    }

    public void filterPersonTable(String filter) throws SQLException {
        peopleData.clear();
        PreparedStatement preparedStatement = null;


        String query = "SELECT * FROM people WHERE (person_id LIKE ?" +
                "OR username LIKE ?" + ")";
        preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, "%" + filter + "%");
        preparedStatement.setString(2, "%" + filter + "%");


        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();
        // Add to the list
        peopleTablePopulationLoop(resultSet, peopleData);
    }



    public Person getSpecificPerson(int person_id) throws SQLException {
        String query = "SELECT username, person_id FROM people WHERE person_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, person_id+"");

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();
        Person specificPerson = new Person();
        while (resultSet.next()) {
            specificPerson.setUsername(resultSet.getString("username"));
            specificPerson.setId(resultSet.getInt("person_id"));
        }
        return specificPerson;
    }

    public Movie getSpecificMovie(int movieID) throws SQLException {
        String query = "SELECT title FROM movie WHERE movie_id = ?";
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, movieID+"");

        // execute prepared statement
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Movie newMovie = new Movie();
            newMovie.setTitle(resultSet.getString("title"));
            // add to list
            movieData.add(newMovie);
        }
        return movieData.get(0);
    }

    public void addFollow(Person follower, Person personFollowed) throws SQLException {
        // Person personToFollow = getSpecificPerson(personFollowed);
        // setup insert statement
        String query = "INSERT INTO followers (throwaway, follower_id, following_id) VALUES (?,?,?);";

        // create prepared statement
        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, follower.getId()*personFollowed.getId()+follower.getId());
        preparedStatement.setInt(2, follower.getId());
        preparedStatement.setInt(3, personFollowed.getId());
        // execute prepared statement
        System.out.println(preparedStatement.toString());
        preparedStatement.execute();
    }

}