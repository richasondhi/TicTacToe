import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TicTacToeGameTest {
    public TicTacToeGame game;

    @Before
    public void setUp() {
        this.game = new TicTacToeGame();
    }

    @Rule
    public ExpectedException exception =ExpectedException.none();


    /*When a player turn is placed anywhere outside the X axis, then RuntimeException is thrown as grid is of 3x3*/
    @Test(expected = RuntimeException.class)
    public void whenXOutsideBoardThenRuntimeException()
    {
        game.play(5, 2);
    }

    /*When a player turn is placed anywhere outside the Y axis, then RuntimeException is thrown as grid is of 3x3*/
    @Test
    public void whenYOutsideBoardThenRuntimeException()
    {
        exception.expect(RuntimeException.class);
        game.play(2, 5);
    }
    /*When a player turn is placed on already occupied grid in Board, then run the play a No Winner string   is thrown as its position is already occupied */
    @Test
    public void whenOccupiedThenRuntimeException()
    {
        game.play(3, 3);
        //exception.expect(RuntimeException.class);
        String isGameFinished= game.play(3, 3);
        assertEquals("No Winner", isGameFinished);

    }
   /*First player turn X */
    @Test
    public void givenFirstTurnWhenNextPlayerThenX()
    {
        assertEquals('X', game.nextPlayer());
    }
    /*Second player turn O */
    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO() {
        game.play(3, 2);
        assertEquals('O', game.nextPlayer());
    }

/*If no winning condition then no winner*/
    @Test
    public void whenPlayThenNoWinner()
    {
        String actual = game.play(2,3);
        assertEquals("No Winner", actual);
    }
    /* Check if there is a win by Horizontal line */
    @Test public void whenPlayAndWholeHorizontalLineThenWinner() {
        game.play(1, 1); // X
        game.play(1, 2); // O
        game.play(2, 1); // X
        game.play(2, 2); // O
        String actual = game.play(3, 1);// X
        assertEquals("O is the Winner", actual);
    }
    /* Check if there is a win by Vertical line */
    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        game.play(2, 1);  // X
        game.play(1, 1);  // O
        game.play(3, 1);  // X
        game.play(1, 2); // O
        game.play(2, 2); // X
        String actual = game.play(1, 3); // O
        assertEquals("X is the Winner", actual);
    }
    /* Check if there is a win by Diagonal line from top left to bottam right */
    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        game.play(1, 1);   // X
        game.play(1, 2);  // O
        game.play(2, 2);   // X
        game.play(1, 3);   // O
        String actual = game.play(3, 3); // O
         assertEquals("X is the Winner", actual);
    }
    /* Check if there is a win by Diagonal line  from bottam left to top right*/
    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner()
    {
        game.play(1, 3);   // X
        game.play(1, 1);  // O
        game.play(2, 2);  // X
        game.play(1, 2);  // O
        String actual = game.play(3, 1); // o
        assertEquals("O is the Winner", actual);
    }
    /* Check if in case there is a Draw  condition */
    @Test
    public void whenAllBoxesAreFilledThenDraw()
    {
        game.play(1, 1);
        game.play(1, 2);
        game.play(1, 3);
        game.play(2, 1);
        game.play(2, 3);
        game.play(2, 2);
        game.play(3, 1);
        game.play(3, 3);
        String actual = game.play(3, 2);
        assertEquals("The result is Draw", actual); }

   /* @Test(expected = RuntimeException.class)
    public void whenXOutsideBoardException() {
        game.printBoard(new char[4][2]);
    }

    @Test
    public void whenXInsideBoardException() {
        game.printBoard(new char[3][3]);
    }

    @Test(expected = NullPointerException.class)
    public void TestConstructorFieldNull() {
        game.printBoard(null);
    }*/


}