import java.util.Scanner;

public class Film {
    private final int id;
    private final String title;
    
    public Film(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Film fromString(String string) {
        // System.out.println(string);

        Scanner scanner = new Scanner(string);
        scanner.useDelimiter(",");

        int id = scanner.nextInt();
        scanner.next();
        String title = scanner.next();

        scanner.close();
        return new Film(id, title);
    }
}
