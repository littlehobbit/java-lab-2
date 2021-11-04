import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FilmsReviews {
    private final ArrayList<Film> films = new ArrayList<>(17772);;
    private final Integer[] marksCount = new Integer[6];
    private final List<Review> reviews = new LinkedList<>();;
    private final Map<Integer, User> usersPerId = new HashMap<>();

    public FilmsReviews() {
        for (int i = 0; i < marksCount.length; i++) {
            marksCount[i] = 0;
        }
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public Collection<User> getUsers() {
        return usersPerId.values();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Integer[] getMarksCount() {
        return marksCount;
    }

    public synchronized void addFilm(Film film) {
        films.add(film);
    }

    public synchronized void addReview(Review review) {
        reviews.add(review);
  
        int filmId = review.getFilm();
        films.get(filmId-1).addReview(review);
        marksCount[review.getMark()]++;
        countUser(review);
    }

    private void countUser(Review review) {
        User user;
        int userId = review.getUserId();

        if (usersPerId.containsKey(userId)) {
            user = usersPerId.get(userId);
        } else {
            user = new User(userId);
            usersPerId.put(userId, user);
        }

        user.incReviewsCount();
    }
}
