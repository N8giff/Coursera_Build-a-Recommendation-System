import java.lang.reflect.Array;
import java.util.*;

public class RecommendationRunner implements Recommender {

    @Override
    public ArrayList<String> getItemsToRate() {
        FirstRatings first = new FirstRatings();
        ArrayList<Movie> allMovies = first.loadMovies("data/ratedmoviesfull.csv");
        ArrayList<String> myMovies = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            int index = (int) (Math.random() * allMovies.size());
            Movie currMove = allMovies.get(index);
            String currTitle = currMove.getTitle();
            myMovies.add(currTitle);
        }
        return myMovies; //return 10 random movies from the list
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings fourth = new FourthRatings();

        ArrayList<String> myMovies = new ArrayList<>();
        ArrayList<Rating> list = fourth.getSimilarRatings(webRaterID, 15, 3);

        if (!list.isEmpty()) {
            System.out.println("10 RECOMMENDED MOVIES...");

            String prefix = "<html><body><table>\n";
            final StringBuilder sb = new StringBuilder(prefix);
            sb.append("<tr>");
            sb.append("<th>");
            sb.append("Movie");
            sb.append("</th>");
            sb.append("</tr>\n");
            for (int x = 0; x < 5; x++) {
                sb.append("<tr>");
                sb.append("<td>");
                sb.append("" + list.get(x));
                sb.append("</td>");
                sb.append("</tr>\n");
                if (x == list.size() - 1) break;
            }
            sb.append("</table>");
            sb.append("</body>");
            sb.append("</html>");
        } else {
            System.out.println("\n" + "NO MOVIES TO RECOMMEND");
        }
    }
}