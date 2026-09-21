import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char[] board = {'1','2','3','4','5','6','7','8','9'};
        int moves = 0;

        System.out.println("===== TIC TAC TOE =====");
        System.out.println("1. Play with Computer");
        System.out.println("2. Two Player Game");
        System.out.print("Enter your choice: ");
        int mode = sc.nextInt();

        char player = 'X';

        while (true) {

            // Display Board
            System.out.println();
            System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
            System.out.println("---|---|---");
            System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
            System.out.println("---|---|---");
            System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
            System.out.println();

            // -------- PLAYER vs COMPUTER --------
            if (mode == 1) {

                // Player Move
                System.out.print("Enter your move (1-9): ");
                int pos = sc.nextInt();

                if (pos < 1 || pos > 9 || board[pos - 1] == 'X' || board[pos - 1] == 'O') {
                    System.out.println("Invalid Move! Try Again.");
                    continue;
                }

                board[pos - 1] = 'X';
                moves++;

                // Check if Player Wins
                if ((board[0]=='X'&&board[1]=='X'&&board[2]=='X') ||
                    (board[3]=='X'&&board[4]=='X'&&board[5]=='X') ||
                    (board[6]=='X'&&board[7]=='X'&&board[8]=='X') ||
                    (board[0]=='X'&&board[3]=='X'&&board[6]=='X') ||
                    (board[1]=='X'&&board[4]=='X'&&board[7]=='X') ||
                    (board[2]=='X'&&board[5]=='X'&&board[8]=='X') ||
                    (board[0]=='X'&&board[4]=='X'&&board[8]=='X') ||
                    (board[2]=='X'&&board[4]=='X'&&board[6]=='X')) {

                    System.out.println("You Win!");
                    break;
                }

                if (moves == 9) {
                    System.out.println("Match Draw!");
                    break;
                }

                // Computer Move
                int comp;
                do {
                    comp = random.nextInt(9) + 1;
                } while (board[comp - 1] == 'X' || board[comp - 1] == 'O');

                board[comp - 1] = 'O';
                moves++;

                System.out.println("Computer chose: " + comp);

                // Check if Computer Wins
                if ((board[0]=='O'&&board[1]=='O'&&board[2]=='O') ||
                    (board[3]=='O'&&board[4]=='O'&&board[5]=='O') ||
                    (board[6]=='O'&&board[7]=='O'&&board[8]=='O') ||
                    (board[0]=='O'&&board[3]=='O'&&board[6]=='O') ||
                    (board[1]=='O'&&board[4]=='O'&&board[7]=='O') ||
                    (board[2]=='O'&&board[5]=='O'&&board[8]=='O') ||
                    (board[0]=='O'&&board[4]=='O'&&board[8]=='O') ||
                    (board[2]=='O'&&board[4]=='O'&&board[6]=='O')) {

                    System.out.println("Computer Wins!");
                    break;
                }

                if (moves == 9) {
                    System.out.println("Match Draw!");
                    break;
                }

            }

            // -------- TWO PLAYER GAME --------
            else if (mode == 2) {

                System.out.print("Player " + player + ", Enter Position (1-9): ");
                int pos = sc.nextInt();

                if (pos < 1 || pos > 9 || board[pos - 1] == 'X' || board[pos - 1] == 'O') {
                    System.out.println("Invalid Move! Try Again.");
                    continue;
                }

                board[pos - 1] = player;
                moves++;

                if ((board[0]==player&&board[1]==player&&board[2]==player) ||
                    (board[3]==player&&board[4]==player&&board[5]==player) ||
                    (board[6]==player&&board[7]==player&&board[8]==player) ||
                    (board[0]==player&&board[3]==player&&board[6]==player) ||
                    (board[1]==player&&board[4]==player&&board[7]==player) ||
                    (board[2]==player&&board[5]==player&&board[8]==player) ||
                    (board[0]==player&&board[4]==player&&board[8]==player) ||
                    (board[2]==player&&board[4]==player&&board[6]==player)) {

                    System.out.println("Player " + player + " Wins!");
                    break;
                }

                if (moves == 9) {
                    System.out.println("Match Draw!");
                    break;
                }

                // Change Player
                if (player == 'X')
                    player = 'O';
                else
                    player = 'X';
            }

            else {
                System.out.println("Invalid Choice!");
                break;
            }
        }

        // Display Final Board
        System.out.println();
        System.out.println("Final Board:");
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---|---|---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---|---|---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);

        sc.close();
    }
}