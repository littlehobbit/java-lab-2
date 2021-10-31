import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FilmsReader {
    private FilmsReviews filmsReviews;
    private FileReader fileReader;

    private final String fileName = "movie_titles.csv";

    public FilmsReader(FilmsReviews filmsReviews, String datasetDir) throws FileNotFoundException {
        this.filmsReviews = filmsReviews;
        this.fileReader = new FileReader(new File(datasetDir, fileName));
    }

    public void readFilms() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        while (line != null) {
            filmsReviews.addFilm(Film.fromString(line));
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
    }
}
