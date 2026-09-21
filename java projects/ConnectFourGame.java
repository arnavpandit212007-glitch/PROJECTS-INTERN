import java.util.Scanner;

public class ConnectFourGame {

    static final int ROWS = 6;
    static final int COLS = 7;
    static char[][] board = new char[ROWS][COLS];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialize board
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }

        char player = 'X';

        while (true) {

            printBoard();

            System.out.print("Player " + player + ", Enter column (0-6): ");
            int col = sc.nextInt();

            if (col < 0 || col >= COLS) {
                System.out.println("Invalid column!");
                continue;
            }

            int row = dropPiece(col, player);

            if (row == -1) {
                System.out.println("Column is full!");
                continue;
            }

            if (checkWin(player)) {
                printBoard();
                System.out.println("Player " + player + " Wins!");
                break;
            }

            if (boardFull()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }

            if (player == 'X')
                player = 'O';
            else
                player = 'X';
        }

        sc.close();
    }

    // Print Board
    static void printBoard() {
        System.out.println();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("0 1 2 3 4 5 6");
    }

    // Drop Piece
    static int dropPiece(int col, char player) {

        for (int row = ROWS - 1; row >= 0; row--) {

            if (board[row][col] == '.') {
                board[row][col] = player;
                return row;
            }
        }

        return -1;
    }

    // Check Winner
    static boolean checkWin(char player) {

        // Horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLS - 4; j++) {

                if (board[i][j] == player &&
                    board[i][j + 1] == player &&
                    board[i][j + 2] == player &&
                    board[i][j + 3] == player)
                    return true;
            }
        }

        // Vertical
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j < COLS; j++) {

                if (board[i][j] == player &&
                    board[i + 1][j] == player &&
                    board[i + 2][j] == player &&
                    board[i + 3][j] == player)
                    return true;
            }
        }

        // Diagonal (\)
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j <= COLS - 4; j++) {

                if (board[i][j] == player &&
                    board[i + 1][j + 1] == player &&
                    board[i + 2][j + 2] == player &&
                    board[i + 3][j + 3] == player)
                    return true;
            }
        }

        // Diagonal (/)
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j <= COLS - 4; j++) {

                if (board[i][j] == player &&
                    board[i - 1][j + 1] == player &&
                    board[i - 2][j + 2] == player &&
                    board[i - 3][j + 3] == player)
                    return true;
            }
        }

        return false;
    }

    // Check Draw
    static boolean boardFull() {

        for (int j = 0; j < COLS; j++) {
            if (board[0][j] == '.')
                return false;
        }

        return true;
    }
}
