import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {
    
    public static void main(String[] args) {
        FilmsReviews dataset = new FilmsReviews();

        try {
            System.out.println("Start reading films");
            new FilmsReader(dataset, "../data").readFilms();
            System.out.println("Stop reading films");

            System.out.println("Start reading reviews");
            new ReviewsReader(dataset, "../data").readReviews();
            System.out.println("Stop reading");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error was occured");
            e.printStackTrace();
        }
    }
}