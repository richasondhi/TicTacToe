import java.util.Scanner;

public class TicTacToeGame {

   static char[][] board = {{'\0', '\0', '\0'},
                      {'\0', '\0', '\0'}
                      , {'\0', '\0', '\0'}};
    char lastPlayer = '\0';
    private static final int SIZE = 3;
    public static void main(String[] args) {



        printBoard(board);

    }
    public String play(int x, int y)
    {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin())
        {
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }
    private void checkAxis(int axis)
    {
        if (axis < 1 || axis > 3)
        {
            throw new RuntimeException("X is outside board");
        }
    }

    public void setBox(int x, int y, char lastPlayer)
    {
        if (board[x - 1][y - 1] != '\0')
        {
            throw new RuntimeException("Box is occupied");
        } else
            {
                board[x - 1][y - 1] = lastPlayer;
            }
    }
    /* Winning Condition */
    public boolean isWin()
    {
        for (int i = 0; i < SIZE; i++)
        {
            if (board[0][i] + board[1][i] + board[2][i]== (lastPlayer * SIZE))
            {
                return true;
            }
        }
        return false;
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
