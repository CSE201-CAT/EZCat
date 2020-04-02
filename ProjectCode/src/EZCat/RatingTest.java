package EZCat;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Rating rat = new Rating();

        // Since rat is a default Rating, it should match with the default toString() output.
        assertEquals(rat.toString(),"Rating{Rating=DoubleProperty [value: -1.0], personId=IntegerProperty [value: -1], movieId=IntegerProperty [value: -1]}");

        rat.setMovieId(64);
        rat.setPersonId(9000);
        rat.setRating(4.6);
        // Now that rat has some actual values, it should automatically change the output of toString().
        assertEquals(rat.toString(),"Rating{Rating=DoubleProperty [value: 4.6], personId=IntegerProperty [value: 9000], movieId=IntegerProperty [value: 64]}");
    }

    @org.junit.jupiter.api.Test
    void getRating() {
        Rating rat = new Rating();

        // Default-constructed Rating should have a rating of -1.0.
        assertEquals(rat.getRating(),-1.0);

        // setting the rating should update the getRating method.
        rat.setRating(4.6);
        assertEquals(rat.getRating(),4.6);

        // Let's store the other variables.
        int personId = rat.getPersonId();
        int movieId = rat.getMovieId();

        // setting the rating should update the getRating method.
        rat.setRating(3.4);
        assertEquals(rat.getRating(),3.4);

        // Setting and Getting the rating should not have altered the previous person or movie IDs.
        assertEquals(rat.getPersonId(),personId);
        assertEquals(rat.getMovieId(),movieId);
    }

    @org.junit.jupiter.api.Test
    void getPersonId() {
        Rating rat = new Rating();

        // Default-constructed Rating should have a person ID of -1.
        assertEquals(rat.getPersonId(),-1);

        // setting the person ID should update the getPersonId() method.
        rat.setPersonId(200);
        assertEquals(rat.getPersonId(),200);

        // Let's store the other variables.
        double rating = rat.getRating();
        int movieId = rat.getMovieId();

        // setting the person ID should update the getPersonID() method.
        rat.setPersonId(500);
        assertEquals(rat.getPersonId(),500);

        // Setting and Getting the person ID should not have altered the previous rating or movie ID.
        assertEquals(rat.getRating(),rating);
        assertEquals(rat.getMovieId(),movieId);
    }

    @org.junit.jupiter.api.Test
    void getMovieId() {
        Rating rat = new Rating();

        // Default-constructed Rating should have a person ID of -1.
        assertEquals(rat.getMovieId(),-1);

        // setting the movie ID should update the getMovieId() method.
        rat.setMovieId(200);
        assertEquals(rat.getMovieId(),200);

        // Let's store the other variables.
        double rating = rat.getRating();
        int personId = rat.getPersonId();

        // setting the movie ID should update the getMovieID() method.
        rat.setMovieId(500);
        assertEquals(rat.getMovieId(),500);

        // Setting and Getting the movie ID should not have altered the previous rating or person ID.
        assertEquals(rat.getRating(),rating);
        assertEquals(rat.getPersonId(),personId);
    }

    @org.junit.jupiter.api.Test
    void setRating() {
        Rating rat = new Rating();

        // Default-constructed Rating should have a rating of -1.0.
        assertEquals(rat.getRating(),-1.0);

        // setting the rating should update the getRating method.
        rat.setRating(4.6);
        assertEquals(rat.getRating(),4.6);

        // Let's store the other variables.
        int personId = rat.getPersonId();
        int movieId = rat.getMovieId();

        // setting the rating should update the getRating method.
        rat.setRating(3.4);
        assertEquals(rat.getRating(),3.4);

        // Setting and Getting the rating should not have altered the previous person or movie IDs.
        assertEquals(rat.getPersonId(),personId);
        assertEquals(rat.getMovieId(),movieId);
    }

    @org.junit.jupiter.api.Test
    void setPersonId() {
        Rating rat = new Rating();

        // Default-constructed Rating should have a person ID of -1.
        assertEquals(rat.getPersonId(),-1);

        // setting the person ID should update the getPersonId() method.
        rat.setPersonId(200);
        assertEquals(rat.getPersonId(),200);

        // Let's store the other variables.
        double rating = rat.getRating();
        int movieId = rat.getMovieId();

        // setting the person ID should update the getPersonID() method.
        rat.setPersonId(500);
        assertEquals(rat.getPersonId(),500);

        // Setting and Getting the person ID should not have altered the previous rating or movie ID.
        assertEquals(rat.getRating(),rating);
        assertEquals(rat.getMovieId(),movieId);
    }

    @org.junit.jupiter.api.Test
    void setMovieId() {
        Rating rat = new Rating();

        // Default-constructed Rating should have a person ID of -1.
        assertEquals(rat.getMovieId(),-1);

        // setting the movie ID should update the getMovieId() method.
        rat.setMovieId(200);
        assertEquals(rat.getMovieId(),200);

        // Let's store the other variables.
        double rating = rat.getRating();
        int personId = rat.getPersonId();

        // setting the movie ID should update the getMovieID() method.
        rat.setMovieId(500);
        assertEquals(rat.getMovieId(),500);

        // Setting and Getting the movie ID should not have altered the previous rating or person ID.
        assertEquals(rat.getRating(),rating);
        assertEquals(rat.getPersonId(),personId);
    }
}