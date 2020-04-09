package EZCat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testToString() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void getUsername() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void setUsername() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void getPassword() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void setPassword() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void getId() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void setId() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void getAdmin() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }

    @Test
    void setIsAdmin() {
        // Create default constructor Person object
        Person per = new Person();
        // Check to see if it matches the typical default Person toString() value
        assertEquals(per.toString(),"Person{username=StringProperty [value: null], password=StringProperty [value: ], isAdmin=BooleanProperty [value: false], id=IntegerProperty [value: 0]}");

        // Check each variable, see if any of them change another.
        per.setUsername("SteppinInASlideZone");
        assertEquals(per.getUsername(),"SteppinInASlideZone");
        per.setPassword("Spectrometer");
        assertEquals(per.getPassword(),"Spectrometer");
        per.setIsAdmin(true);
        assertTrue(per.getAdmin());
        per.setId(45233);
        assertEquals(per.getId(),45233);

        // Check to see if the changes are put into the expected toString() function based on the default constructor's toString() function.
        System.out.println(per);
        assertEquals(per.toString(),"Person{username=StringProperty [value: SteppinInASlideZone], password=StringProperty [value: Spectrometer], isAdmin=BooleanProperty [value: true], id=IntegerProperty [value: 45233]}");

    }
}