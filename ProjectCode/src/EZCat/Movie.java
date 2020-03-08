package EZCat;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Movie {
    private final StringProperty title;
    private final StringProperty genre;
    private final IntegerProperty year;
    private final StringProperty director;
    private final DoubleProperty rating;
    private final StringProperty studio;
    private final IntegerProperty id;

    /**
     * Full Constructor
     * @param title
     * @param genre
     */
    public Movie(String title,
                 String genre) {
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);

        // Some dummy data, for testing.
        this.director = new SimpleStringProperty("some guy");
        this.rating = new SimpleDoubleProperty(5.0);
        this.year = new SimpleIntegerProperty(1234);
        this.studio = new SimpleStringProperty("a studio");
        this.id = new SimpleIntegerProperty(-1);
    }

    /**
     * Default constructor.
     */
    public Movie() {
        this(null, null);
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title=" + title +
                ", genre=" + genre +
                ", year=" + year +
                ", director=" + director +
                ", rating=" + rating +
                ", studio=" + studio +
                '}';
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public String getDirector() {
        return director.get();
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public StringProperty directorProperty() {
        return director;
    }

    public double getRating() {
        return rating.get();
    }

    public void setRating(double rating) {
        this.rating.set(rating);
    }

    public DoubleProperty ratingProperty() {
        return rating;
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public String getStudio() {
        return studio.get();
    }

    public void setStudio(String studio) {
        this.studio.set(studio);
    }

    public StringProperty studioProperty() {
        return studio;
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
}
