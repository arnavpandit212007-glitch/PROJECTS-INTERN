import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int userScore = 0;
    static int computerScore = 0;
    static int draws = 0;
    static int totalRounds = 0;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("  ROCK PAPER SCISSORS GAME");
        System.out.println("=================================");

        boolean playAgain;

        do {
            userScore = 0;
            computerScore = 0;
            draws = 0;
            totalRounds = 0;

            int rounds = chooseGameMode();
            playGame(rounds);
            showFinalSummary();

            playAgain = askPlayAgain();

        } while (playAgain);

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    static int chooseGameMode() {
        System.out.println("\nChoose game mode:");
        System.out.println("1. Best of 3");
        System.out.println("2. Best of 5");
        System.out.println("3. Best of 7");

        int choice;
        while (true) {
            System.out.print("Enter your choice (1-3): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1)
                    return 3;
                if (choice == 2)
                    return 5;
                if (choice == 3)
                    return 7;
            } else {
                scanner.next();
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    static void playGame(int rounds) {
        int roundsToWin = rounds / 2 + 1;

        while (userScore < roundsToWin && computerScore < roundsToWin) {
            totalRounds++;
            System.out.println("\n--- Round " + totalRounds + " ---");

            int userChoice = getUserChoice();
            int computerChoice = random.nextInt(3) + 1;

            System.out.println("You chose: " + getChoiceName(userChoice));
            System.out.println("Computer chose: " + getChoiceName(computerChoice));

            int result = determineWinner(userChoice, computerChoice);

            if (result == 0) {
                draws++;
                System.out.println("Result: Draw!");
            } else if (result == 1) {
                userScore++;
                System.out.println("Result: You Win!");
            } else {
                computerScore++;
                System.out.println("Result: Computer Wins!");
            }

            showScoreboard();
        }
    }

    static int getUserChoice() {
        while (true) {
            System.out.println("\nChoose your move:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.print("Enter your choice (1-3): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    return choice;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid input. Please enter 1, 2, or 3.");
        }
    }

    static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Unknown";
        }
    }

    static int determineWinner(int user, int computer) {
        if (user == computer)
            return 0;

        if ((user == 1 && computer == 3) ||
                (user == 2 && computer == 1) ||
                (user == 3 && computer == 2)) {
            return 1;
        }

        return -1;
    }

    static void showScoreboard() {
        System.out.println("\n=== Scoreboard ===");
        System.out.println("You      : " + userScore);
        System.out.println("Computer : " + computerScore);
        System.out.println("Draws    : " + draws);
    }

    static void showFinalSummary() {
        System.out.println("\n========== Match Summary ==========");
        System.out.println("Total Rounds Played : " + totalRounds);
        System.out.println("Your Wins           : " + userScore);
        System.out.println("Computer Wins       : " + computerScore);
        System.out.println("Draws               : " + draws);

        double winPercentage = totalRounds == 0 ? 0 : (userScore * 100.0) / totalRounds;
        System.out.printf("Your Win Percentage : %.2f%%\n", winPercentage);

        if (userScore > computerScore) {
            System.out.println("Final Result: Congratulations! You won the match!");
        } else if (computerScore > userScore) {
            System.out.println("Final Result: Computer won the match!");
        } else {
            System.out.println("Final Result: The match is a draw!");
        }
    }

    static boolean askPlayAgain() {
        while (true) {
            System.out.print("\nDo you want to play again? (Y/N): ");
            String input = scanner.next().trim().toUpperCase();

            if (input.equals("Y"))
                return true;
            if (input.equals("N"))
                return false;

            System.out.println("Invalid input. Please enter Y or N.");
        }
    }
}