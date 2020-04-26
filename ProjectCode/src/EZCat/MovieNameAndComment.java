package EZCat;

import javafx.beans.property.*;

public class MovieNameAndComment {
    private final StringProperty title;
    private final Comment comment;

    public MovieNameAndComment(String title, Comment comment) {
        this.title = new SimpleStringProperty(title);
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Person{" +
                "title=" + title +
                ", comment=" + comment.toString() +
                '}';
    }

    /**
     * Default constructor.
     */
    public MovieNameAndComment() {
        this(null, null);
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

    public Comment getComment() {
        return comment;
    }
}
