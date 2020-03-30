package EZCat;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Comment {
	    private final StringProperty comment;
	    private final IntegerProperty personId;
	    private final IntegerProperty movieId;

	    /**
	     * Full Constructor
	     * @param title
	     * @param genre
	     */
	    public Comment(String comment, int personId, int movieId) {
	    	this.comment = new SimpleStringProperty(comment);
	        this.personId = new SimpleIntegerProperty(personId);
	        this.movieId = new SimpleIntegerProperty(movieId);
	    }

	    public Comment() {
	    	this(null, null, null);
		}

		/**
	     * Default constructor.
	     */
	    // public Comment() {
	    //     this(null, null, null);
	    // }



	    @Override
	    public String toString() {
	        return "Comment{" +
	                "Comment=" + comment +
	                ", personId=" + personId +
	                ", movieId=" + movieId +
	                '}';
	    }

		public String getComment() {
			return comment.get();
		}

		public int getPersonId() {
			return personId.get();
		}

		public int getMovieId() {
			return movieId.get();
		}
		
		public void setComment(String comment) {
			this.comment.set(comment);
		}

		public void setPersonId(int pId) {
			this.personId.set(pId);
		}

		public void setMovieId(int mId) {
			this.movieId.set(mId);
		}
}
