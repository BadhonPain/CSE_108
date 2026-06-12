import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final List<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = "movies.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file = new File("Supporting_Codes/movies.txt");
        }

        if (!file.exists()) {
            System.out.println("Error: movies.txt not found!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                String[] values = line.split(",", -1);
                if (values.length >= 9) {
                    String title = values[0].trim();
                    int releaseYear = Integer.parseInt(values[1].trim());
                    String genre1 = values[2].trim();
                    String genre2 = values[3].trim();
                    String genre3 = values[4].trim();
                    int runningTime = Integer.parseInt(values[5].trim());
                    String productionCompany = values[6].trim();
                    long budget = Long.parseLong(values[7].trim());
                    long revenue = Long.parseLong(values[8].trim());

                    movies.add(new Movie(title, releaseYear, genre1, genre2, genre3, runningTime, productionCompany,
                            budget, revenue));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading movie file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String input = scanner.nextLine().trim();
            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option! Please enter a number between 1 and 8.");
                continue;
            }

            if (option < 1 || option > 8) {
                System.out.println("Invalid option! Please enter a number between 1 and 8.");
                continue;
            }

            if (option == 8) {
                break;
            }

            handleOption(option, scanner);
        }
    }

    private static void printMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1) Search By Movie Title");
        System.out.println("2) Search By Release Year");
        System.out.println("3) Search By Genre");
        System.out.println("4) Search By Production Company");
        System.out.println("5) Search By Running Time");
        System.out.println("6) List of Top 10 Movies");
        System.out.println("7) List of Production Companies and the Count of their Produced Movies");
        System.out.println("8) Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter movie title: ");
                String titleQuery = scanner.nextLine().trim();
                boolean foundTitle = false;
                for (Movie m : movies) {
                    if (m.getTitle().equalsIgnoreCase(titleQuery)) {
                        System.out.println("\n" + m);
                        foundTitle = true;
                    }
                }
                if (!foundTitle) {
                    System.out.println("No such movie with this name");
                }
                break;
            case 2:
                System.out.print("Enter release year: ");
                String yearInput = scanner.nextLine().trim();
                int yearQuery;
                try {
                    yearQuery = Integer.parseInt(yearInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year format!");
                    break;
                }
                boolean foundYear = false;
                for (Movie m : movies) {
                    if (m.getReleaseYear() == yearQuery) {
                        System.out.println("\n" + m);
                        foundYear = true;
                    }
                }
                if (!foundYear) {
                    System.out.println("No such movie with this release year");
                }
                break;
            case 3:
                System.out.print("Enter genre: ");
                String genreQuery = scanner.nextLine().trim();
                boolean foundGenre = false;
                for (Movie m : movies) {
                    boolean matchesGenre = false;
                    for (String g : m.getGenres()) {
                        if (g.equalsIgnoreCase(genreQuery)) {
                            matchesGenre = true;
                            break;
                        }
                    }
                    if (matchesGenre) {
                        System.out.println("\n" + m);
                        foundGenre = true;
                    }
                }
                if (!foundGenre) {
                    System.out.println("No such movie with this genre");
                }
                break;
            case 4:
                System.out.print("Enter production company: ");
                String companyQuery = scanner.nextLine().trim();
                boolean foundCompany = false;
                for (Movie m : movies) {
                    if (m.getProductionCompany().equalsIgnoreCase(companyQuery)) {
                        System.out.println("\n" + m);
                        foundCompany = true;
                    }
                }
                if (!foundCompany) {
                    System.out.println("No such movie with this production company");
                }
                break;
            case 5:
                System.out.print("Enter minimum running time (minutes): ");
                String minInput = scanner.nextLine().trim();
                System.out.print("Enter maximum running time (minutes): ");
                String maxInput = scanner.nextLine().trim();
                int minTime, maxTime;
                try {
                    minTime = Integer.parseInt(minInput);
                    maxTime = Integer.parseInt(maxInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid running time format!");
                    break;
                }
                boolean foundTime = false;
                for (Movie m : movies) {
                    if (m.getRunningTime() >= minTime && m.getRunningTime() <= maxTime) {
                        System.out.println("\n" + m);
                        foundTime = true;
                    }
                }
                if (!foundTime) {
                    System.out.println("No such movie with this running time range");
                }
                break;
            case 6:
                List<Movie> sortedMovies = new ArrayList<>(movies);
                sortedMovies.sort((m1, m2) -> Long.compare(m2.getProfit(), m1.getProfit()));
                int limit = Math.min(10, sortedMovies.size());
                System.out.println("\nTop " + limit + " Movies by Profit:");
                for (int i = 0; i < limit; i++) {
                    System.out.println("\nRank " + (i + 1) + ":");
                    System.out.println(sortedMovies.get(i));
                }
                break;
            case 7:
                Map<String, Integer> companyCounts = new TreeMap<>();
                for (Movie m : movies) {
                    String company = m.getProductionCompany();
                    companyCounts.put(company, companyCounts.getOrDefault(company, 0) + 1);
                }
                System.out.println("\nProduction Companies and Movie Count:");
                for (Map.Entry<String, Integer> entry : companyCounts.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                break;
        }
    }
}
