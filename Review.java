import java.util.Scanner;

public class Review {
    private final int authorId;
    private final int mark;
    private int filmId;

    public Review(int authorId, int mark) {
        this.authorId = authorId;
        this.mark = mark;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public static Review fromString(String string) {
        Scanner scanner = new Scanner(string);
        scanner.useDelimiter(",");

        int id = scanner.nextInt();
        int mark = scanner.nextInt();
        scanner.next();

        scanner.close();
        return new Review(id, mark);
    }
}
