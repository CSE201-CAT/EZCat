package EZCat;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Movie {
    private final StringProperty title;
    private final StringProperty genre;
    private final IntegerProperty year;
    private final StringProperty director;
    private final DoubleProperty rating;

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
}
