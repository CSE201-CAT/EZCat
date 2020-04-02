package EZCat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    @Test
    void testToString() {
        // A default comment should have a null string, -1 person ID, and -1 movie ID.
        Comment com = new Comment();
        assertEquals(com.toString(),"Comment{Comment=StringProperty [value: null], personId=IntegerProperty [value: -1], movieId=IntegerProperty [value: -1]}");

        // A comment made with the constructor should automatically show the three variables in its toString() method.
        Comment com2 = new Comment("Bro this movie slaps",42,64);
        assertEquals(com2.toString(),"Comment{Comment=StringProperty [value: Bro this movie slaps], personId=IntegerProperty [value: 42], movieId=IntegerProperty [value: 64]}");

    }

    @Test
    void getComment() {
        // A comment made with the default constructor should have a null comment.
        Comment com = new Comment();
        assertNull(com.getComment());

        // Even a default comment should be able to be set to a regular one.
        com.setComment("Test!");
        assertEquals(com.getComment(),"Test!");

        // Creating a comment with the constructor should not affect it any differently.
        Comment com2 = new Comment("Testing...",10,20);
        assertEquals(com2.getComment(),"Testing...");


        int personID = com2.getPersonId();
        int movieID = com2.getMovieId();
        com2.setComment("I hate this movie!");
        // Changing the comment should not alter the IDs.
        assertEquals(com2.getPersonId(),personID);
        assertEquals(com2.getMovieId(),movieID);

        // Likewise, altering the movie or person IDs should not change the comment.
        String oldComment = com2.getComment();
        com2.setMovieId(10101);
        com2.setPersonId(29292);
        assertEquals(com2.getComment(),oldComment);
    }

    @Test
    void getPersonId() {
        // A comment made with the default constructor should have a -1 personID.
        Comment com = new Comment();
        assertEquals(com.getPersonId(),-1);

        // Even a default comment should be able to be set to a regular one.
        com.setPersonId(54);
        assertEquals(com.getPersonId(),54);

        // Creating a comment with the constructor should not affect it any differently.
        Comment com2 = new Comment("Testing...",10,20);
        assertEquals(com2.getPersonId(),10);


        String oldComment = com2.getComment();
        int movieID = com2.getMovieId();
        com2.setPersonId(1352);
        // Changing the person ID should not alter the movie ID or comment.
        assertEquals(com2.getComment(),oldComment);
        assertEquals(com2.getMovieId(),movieID);

        // Likewise, altering the movie or person IDs should not change the comment.
        int personID = com2.getPersonId();
        com2.setComment("Dab dab muscle up.");
        com2.setMovieId(15);
        assertEquals(com2.getPersonId(),personID);
    }

    @Test
    void getMovieId() {
        // A comment made with the default constructor should have a -1 movieID.
        Comment com = new Comment();
        assertEquals(com.getMovieId(),-1);

        // Even a default comment should be able to be set to a regular one.
        com.setMovieId(54);
        assertEquals(com.getMovieId(),54);

        // Creating a comment with the constructor should not affect it any differently.
        Comment com2 = new Comment("Testing...",10,20);
        assertEquals(com2.getMovieId(),20);


        String oldComment = com2.getComment();
        int personID = com2.getPersonId();
        com2.setMovieId(9999);
        // Changing the person ID should not alter the movie ID or comment.
        assertEquals(com2.getComment(),oldComment);
        assertEquals(com2.getPersonId(),personID);

        // Likewise, altering the movie or person IDs should not change the comment.
        int movieID = com2.getMovieId();
        com2.setComment("step to the left and step to the right and");
        com2.setPersonId(15);
        assertEquals(com2.getMovieId(),movieID);
    }

    @Test
    void setComment() {
        // A comment made with the default constructor should have a null comment.
        Comment com = new Comment();
        assertNull(com.getComment());

        // Even a default comment should be able to be set to a regular one.
        com.setComment("Test!");
        assertEquals(com.getComment(),"Test!");

        // Creating a comment with the constructor should not affect it any differently.
        Comment com2 = new Comment("Testing...",10,20);
        assertEquals(com2.getComment(),"Testing...");


        int personID = com2.getPersonId();
        int movieID = com2.getMovieId();
        com2.setComment("I hate this movie!");
        // Changing the comment should not alter the IDs.
        assertEquals(com2.getPersonId(),personID);
        assertEquals(com2.getMovieId(),movieID);

        // Likewise, altering the movie or person IDs should not change the comment.
        String oldComment = com2.getComment();
        com2.setMovieId(10101);
        com2.setPersonId(29292);
        assertEquals(com2.getComment(),oldComment);
    }

    @Test
    void setPersonId() {
        // A comment made with the default constructor should have a -1 personID.
        Comment com = new Comment();
        assertEquals(com.getPersonId(),-1);

        // Even a default comment should be able to be set to a regular one.
        com.setPersonId(54);
        assertEquals(com.getPersonId(),54);

        // Creating a comment with the constructor should not affect it any differently.
        Comment com2 = new Comment("Testing...",10,20);
        assertEquals(com2.getPersonId(),10);


        String oldComment = com2.getComment();
        int movieID = com2.getMovieId();
        com2.setPersonId(1352);
        // Changing the person ID should not alter the movie ID or comment.
        assertEquals(com2.getComment(),oldComment);
        assertEquals(com2.getMovieId(),movieID);

        // Likewise, altering the movie or person IDs should not change the comment.
        int personID = com2.getPersonId();
        com2.setComment("Dab dab muscle up.");
        com2.setMovieId(15);
        assertEquals(com2.getPersonId(),personID);
    }

    @Test
    void setMovieId() {
        // A comment made with the default constructor should have a -1 movieID.
        Comment com = new Comment();
        assertEquals(com.getMovieId(),-1);

        // Even a default comment should be able to be set to a regular one.
        com.setMovieId(54);
        assertEquals(com.getMovieId(),54);

        // Creating a comment with the constructor should not affect it any differently.
        Comment com2 = new Comment("Testing...",10,20);
        assertEquals(com2.getMovieId(),20);


        String oldComment = com2.getComment();
        int personID = com2.getPersonId();
        com2.setMovieId(9999);
        // Changing the person ID should not alter the movie ID or comment.
        assertEquals(com2.getComment(),oldComment);
        assertEquals(com2.getPersonId(),personID);

        // Likewise, altering the movie or person IDs should not change the comment.
        int movieID = com2.getMovieId();
        com2.setComment("step to the left and step to the right and");
        com2.setPersonId(15);
        assertEquals(com2.getMovieId(),movieID);
    }
}