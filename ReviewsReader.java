import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReviewsReader {
    private FilmsReviews filmsReviews;

    public ReviewsReader(FilmsReviews filmsReviews, String filePath) throws FileNotFoundException {
        this.filmsReviews = filmsReviews;
    }

    public void readReviews() {
        try {
            Thread thread1 = new Thread(new ReadingTask(new File("../data/combined_data_1.txt")));
            Thread thread2 = new Thread(new ReadingTask(new File("../data/combined_data_2.txt")));
            Thread thread3 = new Thread(new ReadingTask(new File("../data/combined_data_3.txt")));
            Thread thread4 = new Thread(new ReadingTask(new File("../data/combined_data_4.txt")));
            
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("thread error");
        }
    }
}
