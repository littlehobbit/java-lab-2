import java.util.Scanner;

public class Film {
    private final int id;
    private final String title;
    private int reviewsCount = 0;
    private int reviewsSum = 0;
    
    public Film(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addReview(Review review) {
        reviewsCount++;
        reviewsSum += review.getMark();
    }

    public float getAvarageRating() {
        return reviewsSum / (float)reviewsCount;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public boolean isGoodFilm() {
        return getAvarageRating() >= 4.0;
    }

    public static Film fromString(String string) {
        Scanner scanner = new Scanner(string);
        scanner.useDelimiter(",");

        int id = scanner.nextInt();
        scanner.next();
        String title = scanner.next();

        scanner.close();
        return new Film(id, title);
    }
}
