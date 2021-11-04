import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadingTask implements Runnable {
    private Scanner scanner;
    private FilmsReviews filmsReviews;

    public ReadingTask(FilmsReviews dst, File src) throws FileNotFoundException {
        this.scanner = new Scanner(src);
        this.filmsReviews = dst;
    }

    @Override
    public void run() {
        Pattern filmId = Pattern.compile("\\d*:");

        int totalFilmId = 0, lineCount = 0;

        while (scanner.hasNextLine()) {
            lineCount++;
            if (scanner.hasNext(filmId)) {
                totalFilmId = readFilmid();
            } else {
                filmsReviews.addReview(readReview(totalFilmId));
            }
        }

        scanner.close();
        System.out.println("done, readed " + Integer.toString(lineCount) + " lines");
    }

    private int readFilmid() {
        String line = scanner.nextLine();
        return Integer.parseInt(line.split(":")[0]);
    }

    private Review readReview(int filmId) {
        String line = scanner.nextLine();
        Review review = Review.fromString(line);
        review.setFilmId(filmId);
        return review;
    }
}