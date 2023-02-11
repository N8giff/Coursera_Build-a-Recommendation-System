import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerAverage {

        public void printAverageRatings(String moviefile, String ratingsfile, int x){
            SecondRatings second = new SecondRatings(moviefile, ratingsfile);

            System.out.println("Average rating of movies with at least " + x + " reviews:" + "\n");
            ArrayList<Rating> averages = second.getAverageRatings(x);
            System.out.println("# movies > " + x + ": " + averages.size() + "\n");

            //sort arraylist
            Collections.sort(averages);

            for (Rating average : averages) {
                String movie = average.getItem();
                Double rating = average.getValue();

                System.out.println(rating + "\t" + movie);
            }
            System.out.println("//      //      //      //");
    }
}
