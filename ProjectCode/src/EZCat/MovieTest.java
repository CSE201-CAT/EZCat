package EZCat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testToString() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getTitle() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setTitle() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getGenre() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setGenre() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getDirector() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setDirector() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getRating() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setRating() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getYear() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setYear() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getStudio() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setStudio() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getId() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setId() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getPublished() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setIsPublished() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getToDelete() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void setToDelete() {
        // Test default constructor
        Movie mov = new Movie();
        // Test toString() method and test default constructor variables
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: null], genre=StringProperty [value: null], year=IntegerProperty [value: 1234], director=StringProperty [value: ], rating=-1.0, studio=StringProperty [value: a studio], id=IntegerProperty [value: -1], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

        // Test all changes
        mov.setTitle("Bruh Momentum");
        assertEquals(mov.getTitle(),"Bruh Momentum");
        mov.setGenre("Psychological");
        assertEquals(mov.getGenre(),"Psychological");
        mov.setYear(1999);
        assertEquals(mov.getYear(),1999);
        mov.setDirector("Dr. Phil");
        assertEquals(mov.getDirector(),"Dr. Phil");
        mov.setRating(4.9);
        assertEquals(4.9,mov.getRating());
        mov.setStudio("SHAFT");
        assertEquals(mov.getStudio(),"SHAFT");
        mov.setId(6);
        assertEquals(mov.getId(),6);
        mov.setIsPublished(false);
        assertFalse(mov.getPublished());
        mov.setToDelete(false);
        assertFalse(mov.getToDelete());

        // Test toString() and test if changing one variable will change any others
        assertEquals(mov.toString(),"Movie{title=StringProperty [value: Bruh Momentum], genre=StringProperty [value: Psychological], year=IntegerProperty [value: 1999], director=StringProperty [value: Dr. Phil], rating=4.9, studio=StringProperty [value: SHAFT], id=IntegerProperty [value: 6], isPublished=BooleanProperty [value: false], toDelete=BooleanProperty [value: false]}");

    }

    @Test
    void getOldMovieID() {
        // Create new Movie object.
        Movie mov = new Movie();
        // Old Movie ID should be -1 by default.
        assertEquals(-1, mov.getOldMovieID());
        mov.setId(10);
        mov.setId(20);
        assertEquals(-1, mov.getOldMovieID());
        mov.setOldMovieID(30);
        assertEquals(30, mov.getOldMovieID());
    }

    @Test
    void setOldMovieID() {
    }
}