package EZCat;

import javafx.beans.property.*;

public class Person {
    private final StringProperty username;
    private final StringProperty password;
    private final BooleanProperty isAdmin;
    private final IntegerProperty id;

    @Override
    public String toString() {
        return "Person{" +
                "username=" + username +
                ", password=" + password +
                ", isAdmin=" + isAdmin +
                ", id=" + id +
                '}';
    }

    /**
     * Full Constructor
     * @param username
     * @param password
     */
    public Person(String username,
                 String password) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(PasswordEncrypt.hashPassword(password,
                PasswordEncrypt.generateSalt(512).get()).get());

        // Some dummy data, for testing.
        this.isAdmin = new SimpleBooleanProperty(false);
        this.id = new SimpleIntegerProperty(0);
    }

    /**
     * Default constructor.
     */
    public Person() {
        this(null, "");
    }


    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(PasswordEncrypt.hashPassword(password,
                PasswordEncrypt.generateSalt(512).get()).get());
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public boolean getAdmin() {
        return isAdmin.get();
    }

    public void setIsAdmin(boolean flag) {
        this.isAdmin.set(flag);
    }

    public BooleanProperty isAdminProperty() {
        return isAdmin;
    }

}
