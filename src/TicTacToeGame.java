import java.util.Scanner;

public class TicTacToeGame {

   static char[][] board = {{'\0', '\0', '\0'},
                      {'\0', '\0', '\0'}
                      , {'\0', '\0', '\0'}};
     char lastPlayer = '\0';
    public static void main(String[] args) {



        printBoard(board);

    }
    public void play(int x, int y)
    {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        lastPlayer = nextPlayer();
    }
    private void checkAxis(int axis)
    {
        if (axis < 1 || axis > 3)
        {
            throw new RuntimeException("X is outside board");
        }
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException ("Box is occupied! Not a valid move");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-----");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-----");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }
    }
