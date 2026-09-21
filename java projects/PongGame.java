import java.util.Random;
import java.util.Scanner;

public class PongGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int player1Score = 0;
        int player2Score = 0;

        System.out.println("==================================");
        System.out.println("            PONG GAME");
        System.out.println("==================================");

        System.out.println("1. Play with Computer");
        System.out.println("2. Two Players");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        while (player1Score < 3 && player2Score < 3) {

            String[] direction = {"L", "C", "R"};
            String ball = direction[random.nextInt(3)];

            System.out.println("\nBall is coming...");

            // -------- Player 1 --------
            System.out.print("Player 1 (L/C/R): ");
            String p1 = sc.next().toUpperCase();

            if (!p1.equals(ball)) {
                System.out.println("Missed!");
                player2Score++;
            } else {

                if (choice == 1) {

                    // Computer Turn
                    String computer = direction[random.nextInt(3)];
                    System.out.println("Computer chooses: " + computer);

                    if (!computer.equals(ball)) {
                        System.out.println("Computer Missed!");
                        player1Score++;
                    } else {
                        System.out.println("Great Rally! Nobody scores.");
                    }

                } else {

                    // Player 2 Turn
                    System.out.print("Player 2 (L/C/R): ");
                    String p2 = sc.next().toUpperCase();

                    if (!p2.equals(ball)) {
                        System.out.println("Player 2 Missed!");
                        player1Score++;
                    } else {
                        System.out.println("Great Rally! Nobody scores.");
                    }
                }
            }

            System.out.println("-----------------------");
            if (choice == 1) {
                System.out.println("Player : " + player1Score);
                System.out.println("Computer : " + player2Score);
            } else {
                System.out.println("Player 1 : " + player1Score);
                System.out.println("Player 2 : " + player2Score);
            }
            System.out.println("-----------------------");
        }

        System.out.println("\n========== GAME OVER ==========");

        if (choice == 1) {

            if (player1Score == 3)
                System.out.println("Congratulations! You Win!");
            else
                System.out.println("Computer Wins!");

        } else {

            if (player1Score == 3)
                System.out.println("Player 1 Wins!");
            else
                System.out.println("Player 2 Wins!");
        }

        sc.close();
    }
}