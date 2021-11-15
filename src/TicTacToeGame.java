import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {

       char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        printBoard(board);

    }
    public void play(int x, int y) {
        /*As board is of grid 3x3 */
        if (x < 1 || x > 3) {
            throw new RuntimeException("X is outside board");
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-----");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-----");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }
    }
