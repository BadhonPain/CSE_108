import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private int releaseYear;
    private List<String> genres;
    private int runningTime;
    private String productionCompany;
    private long budget;
    private long revenue;

    public Movie(String title, int releaseYear, String genre1, String genre2, String genre3, int runningTime,
            String productionCompany, long budget, long revenue) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = new ArrayList<>();
        if (genre1 != null && !genre1.trim().isEmpty()) {
            this.genres.add(genre1.trim());
        }
        if (genre2 != null && !genre2.trim().isEmpty()) {
            this.genres.add(genre2.trim());
        }
        if (genre3 != null && !genre3.trim().isEmpty()) {
            this.genres.add(genre3.trim());
        }
        this.runningTime = runningTime;
        this.productionCompany = productionCompany;
        this.budget = budget;
        this.revenue = revenue;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public long getBudget() {
        return budget;
    }

    public long getRevenue() {
        return revenue;
    }

    public long getProfit() {
        return revenue - budget;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("Release Year: ").append(releaseYear).append("\n");
        sb.append("Genres: ").append(String.join(", ", genres)).append("\n");
        sb.append("Running Time: ").append(runningTime).append(" minutes\n");
        sb.append("Production Company: ").append(productionCompany).append("\n");
        sb.append("Budget: ").append(budget).append("\n");
        sb.append("Revenue: ").append(revenue).append("\n");
        sb.append("Profit: ").append(getProfit());
        return sb.toString();
    }
}
