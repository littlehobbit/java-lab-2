public class Main {
    
    public static void main(String[] args) {
        FilmsReviews dataset = new FilmsReviews();

        try {
            System.out.println("Start reading films");
            new FilmsReader(dataset, "./data").readFilms();
            System.out.println("Stop reading films");

            System.out.println("Start reading reviews");
            new ReviewsReader(dataset, "./data").readReviews();
            System.out.println("Stop reading");

            DatasetAnalyzer analyzer = new DatasetAnalyzer(dataset);
            
            Film mostReviewed = analyzer.getMostReviewedFilm();
            System.out.println(mostReviewed.getTitle() + " " + mostReviewed.getReviewsCount());
            
            Film highestReview = analyzer.getHihgestReviewedFilm();
            System.out.println(highestReview.getTitle() + " " + highestReview.getAvarageRating() + " " + highestReview.getReviewsCount());

            Film lowestReviewed = analyzer.getLowestReviewedFilm();
            System.out.println(lowestReviewed.getTitle() + " " + lowestReviewed.getAvarageRating() + " " + lowestReviewed.getReviewsCount());

            User user = analyzer.getMostActiveUser();
            System.out.println("user id: " + user.getId() + " " + user.getReviewsCount());

            var mostUsedMark = analyzer.getMostUsedMark();
            System.out.println("most used mark: " + mostUsedMark[0] + " used " + mostUsedMark[1]);

            var haters = analyzer.getHaters();
            haters.forEach(hater -> System.out.println(hater.getId() + " " + hater.getBadReviewsCount()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error was occured");
            e.printStackTrace();
        }
    }
}