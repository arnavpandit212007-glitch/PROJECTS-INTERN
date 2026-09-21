import java.util.*;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int games = 0, wins = 0, losses = 0, best = Integer.MAX_VALUE;
        boolean play = true;

        System.out.println("======================================");
        System.out.println("      GUESS THE NUMBER GAME");
        System.out.println("======================================");

        while (play) {
            games++;
            int secret = random.nextInt(100) + 1;
            int attempts = 0, maxAttempts = 10;
            boolean won = false;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");

                while (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next();
                    System.out.print("Enter your guess: ");
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100.");
                    attempts--;
                    continue;
                }

                if (guess == secret) {
                    won = true;
                    wins++;
                    if (attempts < best)
                        best = attempts;
                    int score = (maxAttempts - attempts + 1) * 10;
                    System.out.println("\n🎉 AWESOME! You guessed the number!");
                    System.out.println("Correct Number : " + secret);
                    System.out.println("Attempts Used  : " + attempts);
                    System.out.println("Score          : " + score);
                    break;
                } else if (guess < secret) {
                    if (secret - guess <= 5)
                        System.out.println("Too Low! You're very close. Try Again!");
                    else
                        System.out.println("Too Low! Try Again!");
                } else {
                    if (guess - secret <= 5)
                        System.out.println("Too High! You're very close. Try Again!");
                    else
                        System.out.println("Too High! Try Again!");
                }

                System.out.println("Attempts Left : " + (maxAttempts - attempts));
            }

            if (!won) {
                losses++;
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secret);
            }

            System.out.println("\n========== SESSION STATS ==========");
            System.out.println("Games Played : " + games);
            System.out.println("Games Won    : " + wins);
            System.out.println("Games Lost   : " + losses);
            if (best != Integer.MAX_VALUE)
                System.out.println("Best Score   : " + best + " attempts");

            System.out.print("\nWould you like to play again? (Y/N): ");
            play = sc.next().equalsIgnoreCase("Y");
        }

        System.out.println("\nThank you for playing!");
        System.out.println("Keep Practicing Java. Goodbye!");
        sc.close();
    }
}
