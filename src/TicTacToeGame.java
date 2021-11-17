
import java.util.Scanner;

public class TicTacToeGame {

    private  char[][] board = {{'\0', '\0', '\0'},
                             {'\0', '\0', '\0'}
                           , {'\0', '\0', '\0'}};
    private static char lastPlayer = '\0';
    private static final int SIZE = 3;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame obj= new TicTacToeGame();
        String isGameFinished = null;
        int xaxis = 0;
        int yaxis = 0;
        obj.printBoard(obj.board);
        while (true) {
            System.out.println("Where would you like to play which position? (X,Y)");
            try {
                 xaxis = Integer.parseInt(scanner.nextLine());
                 yaxis = Integer.parseInt(scanner.nextLine());
                 isGameFinished = obj.play(xaxis,yaxis);


        } catch (RuntimeException e) {

                System.out.println("Not a Valid Move ! Try again");
                obj.lastPlayer = obj.nextPlayer();
                continue;
        }

            if (obj.isWin(xaxis, yaxis) || obj.isDraw()){

                break;
            }

            obj.printBoard(obj.board);
        }
        obj.printBoard(obj.board);
        System.out.println(isGameFinished);
        scanner.close();
    }

    public  String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin(x, y)) {
            return lastPlayer + " is the Winner";
        } else if (isDraw()) {
            return "The result is Draw";
        } else {
            return "No Winner";
        }
    }

    public  char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    public  void checkAxis(int axis) {
        try {
        if (axis < 1 || axis > SIZE) {
            throw new RuntimeException(axis+ " is Outside Board");
        }
        else
        {
        }
        } catch (RuntimeException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public  void setBox(int x, int y, char lastPlayer)  {

        try {
            if (board[x - 1][y - 1] != '\0') {
              throw new RuntimeException("Box is occupied.  It is not a valid move!");


            } else {
                board[x - 1][y - 1] = lastPlayer;
            }
        } catch (RuntimeException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

      boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * SIZE;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        if (horizontal == playerTotal
                || vertical == playerTotal
                || diagonal1 == playerTotal
                || diagonal2 == playerTotal) {
            return true;
        }
        return false;
    }

    public  boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
    public  void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-----");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-----");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }
    }
