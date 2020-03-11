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
    private final BooleanProperty isPublished;
    private final BooleanProperty toDelete;
    private final IntegerProperty oldMovieID;

    /**
     * Full Constructor
     * @param title
     * @param genre
     */
    public Movie(String title,
                 String genre) {
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);

        this.director = new SimpleStringProperty("");
        this.rating = new SimpleDoubleProperty(5.0);
        this.year = new SimpleIntegerProperty(1234);
        this.studio = new SimpleStringProperty("a studio");
        this.id = new SimpleIntegerProperty(-1);
        this.isPublished = new SimpleBooleanProperty(false);
        this.toDelete = new SimpleBooleanProperty(false);
        this.oldMovieID = new SimpleIntegerProperty(-1);
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
                ", id=" + id +
                ", isPublished=" + isPublished +
                ", toDelete=" + toDelete +
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

    public boolean getPublished() {
        return isPublished.get();
    }

    public void setIsPublished(boolean flag) {
        this.isPublished.set(flag);
    }

    public BooleanProperty isPublishedProperty() {
        return isPublished;
    }

    public boolean getToDelete() {
        return toDelete.get();
    }

    public void setToDelete(boolean flag) {
        this.toDelete.set(flag);
    }

    public BooleanProperty toDeleteProperty() {
        return toDelete;
    }

    public int getOldMovieID() {
        return oldMovieID.get();
    }

    public void setOldMovieID(int oldMovieID) {
        this.oldMovieID.set(oldMovieID);
    }

    public IntegerProperty oldMovieIDProperty() {
        return oldMovieID;
    }
}
