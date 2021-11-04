import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class DatasetAnalyzer {
    private FilmsReviews filmsReviews;

    public DatasetAnalyzer(FilmsReviews filmsReviews) {
        this.filmsReviews = filmsReviews;
    }

    public Film getMostReviewedFilm() {
        return filmsReviews.getFilms().stream()
                                        .max(Comparator.comparing(Film::getReviewsCount))
                                        .orElseThrow(NoSuchElementException::new);
    }

    public Film getHihgestReviewedFilm() {
        return filmsReviews.getFilms().stream()
                                        .max((lhs, rhs) -> {
                                            boolean isSameRating = lhs.getAvarageRating() == rhs.getAvarageRating();

                                            if (isSameRating) {
                                                return Integer.compare(lhs.getReviewsCount(), rhs.getReviewsCount());
                                            } else {
                                                return Float.compare(lhs.getAvarageRating(), rhs.getAvarageRating());
                                            }
                                        })
                                        .orElseThrow(NoSuchElementException::new);
    }

    public Film getLowestReviewedFilm() {
        return filmsReviews.getFilms().stream()
                                        .min((lhs, rhs) -> {
                                            boolean isSameRating = lhs.getAvarageRating() == rhs.getAvarageRating();

                                            if (isSameRating) {
                                                return Integer.compare(rhs.getReviewsCount(), lhs.getReviewsCount());
                                            } else {
                                                return Float.compare(lhs.getAvarageRating(), rhs.getAvarageRating());
                                            }
                                        })
                                        .orElseThrow(NoSuchElementException::new);
    }

    public User getMostActiveUser() {
        return filmsReviews.getUsers().stream()
                                        .max(Comparator.comparing(User::getReviewsCount))
                                        .orElseThrow(NoSuchElementException::new);
    }

    public List<User> getHaters() {
        Map<Integer, User> hatersPerId = new HashMap<>(); 
        filmsReviews.getReviews().forEach((review) -> {
            User hater;
            int haterId = review.getUserId(), filmId = review.getFilm();

            if (review.isBadMark() && filmsReviews.getFilms().get(filmId-1).isGoodFilm()) {
                if (hatersPerId.containsKey(haterId)) {
                    hater = hatersPerId.get(haterId);
                } else {
                    hater = new User(haterId);
                    hatersPerId.put(haterId, hater);
                } 
                hater.incBadReviewsCount();
            }
        });

        return hatersPerId.values().stream()
                                     .sorted((lhs, rhs) -> Integer.compare(rhs.getBadReviewsCount(), lhs.getBadReviewsCount()))
                                     .limit(10)
                                     .collect(Collectors.toList());
    }

    public int[] getMostUsedMark() {
        var marks = filmsReviews.getMarksCount();
        var arr = new int[2];
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= marks[arr[0]]) {
                arr[0] = i;
                arr[1] = marks[i];
            }
        }
        return arr;
    }

}
