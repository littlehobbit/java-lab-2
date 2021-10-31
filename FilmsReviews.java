import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ConcurrentMap;


public class FilmsReviews {
    private final ArrayList<Film> films;
    private final ArrayList<Integer> marksCount;
    private final ArrayList<Review> reviews;
    

    public FilmsReviews() {
        films = new ArrayList<>(17771);
        marksCount = new ArrayList<>(6);
        reviews = new ArrayList<>();
    }


    public synchronized void addFilm(Film film) {
        films.add(film);
    }

    public synchronized void addReview(Review review) {
        // TODO add review
        // reviews.add(review);
    }
}
