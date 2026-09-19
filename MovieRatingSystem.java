import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: User Input Handling
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Step 2: Parallel Arrays & Input Validation Loop
        String[] movies = new String[5];
        double[] ratings = new double[5];

        System.out.println("\nPlease enter 5 movies you watched recently and rate them (1 - 10):");

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter movie " + (i + 1) + " name: ");
            movies[i] = scanner.nextLine();

            double rating = -1;
            // Input validation loop ensuring rating is between 1 and 10
            while (rating < 1 || rating > 10) {
                System.out.print("Enter rating for " + movies[i] + " (1-10): ");
                if (scanner.hasNextDouble()) {
                    rating = scanner.nextDouble();
                    if (rating < 1 || rating > 10) {
                        System.out.println("Invalid rating. Please enter a number between 1 and 10.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear invalid token
                }
            }
            ratings[i] = rating;
            scanner.nextLine(); // Clear newline character
        }

        // Step 3: Calculate Average Rating
        double sum = 0;
        for (double r : ratings) {
            sum += r;
        }
        double average = sum / ratings.length;

        System.out.println("\n----------------------------------------");
        System.out.println("Hello, " + name + "!");
        System.out.printf("Your average movie rating is: %.2f\n", average);

        // Step 4: Rating Classification (if-else statements)
        System.out.print("Classification: ");
        if (average >= 9.0) {
            System.out.println("You are a cinephile!");
        } else if (average >= 7.0) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (average >= 5.0) {
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        // Step 5: Check for Favorite Movie (Nested / Specific Checks)
        boolean hasMasterpiece = false;
        boolean hasUnimpressive = false;

        for (double r : ratings) {
            if (r == 10) {
                hasMasterpiece = true;
            }
            if (r < 4) {
                hasUnimpressive = true;
            }
        }

        if (hasMasterpiece) {
            System.out.println("Wow! You found a masterpiece.");
        }
        if (hasUnimpressive) {
            System.out.println("That movie didn't impress you much.");
        }

        // Step 6: Logical Operators (&& and ||)
        boolean allHigh = true;
        boolean hasVeryLow = false;

        for (double r : ratings) {
            if (!(r >= 7)) { // Logical check using short-circuiting logic
                allHigh = false;
            }
            if (r < 3) {
                hasVeryLow = true;
            }
        }

        if (allHigh) {
            System.out.println("You seem to enjoy most movies.");
        } else if (hasVeryLow) {
            System.out.println("You have strong opinions on movies!");
        }

        // Step 7: Switch Statement for Genre Preferences
        System.out.println("\nSelect your favorite genre (Action, Comedy, Horror, Drama, Sci-Fi): ");
        String genre = scanner.nextLine().trim();

        System.out.print("Genre Taste: ");
        switch (genre.toLowerCase()) {
            case "action":
                System.out.println("You love excitement and thrills!");
                break;
            case "comedy":
                System.out.println("You enjoy a good laugh.");
                break;
            case "horror":
                System.out.println("You have a taste for fear!");
                break;
            case "drama":
                System.out.println("You appreciate deep storytelling.");
                break;
            case "sci-fi":
            case "scifi":
                System.out.println("You love futuristic and imaginative worlds!");
                break;
            default:
                System.out.println("You have a unique taste in film!");
                break;
        }

        // Step 8: Conditional (Ternary) Operator for Recommendation
        String recommendation = genre.equalsIgnoreCase("Sci-Fi") ? "Interstellar" : "The Dark Knight";
        System.out.println("Movie Recommendation based on preference: " + recommendation);

        scanner.close();
    }
}