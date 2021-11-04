import java.io.File;
import java.io.FileNotFoundException;

public class ReviewsReader {
    private FilmsReviews filmsReviews;
    private String filesPath;

    private final String REVIEW_FILE_FORMAT = "combined_data_%d.txt";

    public ReviewsReader(FilmsReviews filmsReviews, String filesPath) throws FileNotFoundException {
        this.filmsReviews = filmsReviews;
        this.filesPath = filesPath;
    }

    public void readReviews() {
        try {
            // TODO: remake this
            ThreadsList threadsList = new ThreadsList();

            for (int fileId = 1; fileId <= 4; fileId++) {
                threadsList.addThread(createReadingThread(fileId));
            }

            threadsList.startAll();
            threadsList.joinAll();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    private Thread createReadingThread(int fileId) throws FileNotFoundException {
        String srcFileName = String.format(REVIEW_FILE_FORMAT, fileId);
        File srcFile = new File(filesPath, srcFileName);
        Runnable task = new ReadingTask(filmsReviews, srcFile);
        return new Thread(task);
    }
}
