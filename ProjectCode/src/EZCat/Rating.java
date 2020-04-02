package EZCat;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rating {
	    private final DoubleProperty rating;
	    private final IntegerProperty personId;
	    private final IntegerProperty movieId;

	    /**
	     * Full Constructor
	     * @param rating
	     * @param personId
		 * @param movieId
	     */
	    public Rating(double rating, int personId, int movieId) {
	    	this.rating = new SimpleDoubleProperty(rating);
	        this.personId = new SimpleIntegerProperty(personId);
	        this.movieId = new SimpleIntegerProperty(movieId);
	    }

	    /**
	     * Default constructor.
	     */
	    public Rating() {
	        this(-1, -1, -1);
	    }



	    @Override
	    public String toString() {
	        return "Rating{" +
	                "Rating=" + rating +
	                ", personId=" + personId +
	                ", movieId=" + movieId +
	                '}';
	    }

		public double getRating() {
			return rating.get();
		}

		public int getPersonId() {
			return personId.get();
		}

		public int getMovieId() {
			return movieId.get();
		}
		
		public void setRating(Double rating) {
			this.rating.set(rating);
		}

		public void setPersonId(int pId) {
			this.personId.set(pId);
		}

		public void setMovieId(int mId) {
			this.movieId.set(mId);
		}
}
