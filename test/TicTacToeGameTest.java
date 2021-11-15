import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertEquals;

public class TicTacToeGameTest {
    private TicTacToeGame game;

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
    /*When a player turn is placed on already occupied grid in Board, then RuntimeException is thrown */
    @Test
    public void whenOccupiedThenRuntimeException()
    {
        game.play(2, 1);
        exception.expect(RuntimeException.class);
        game.play(2, 1);
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
        game.play(1, 1);
        assertEquals('O', game.nextPlayer());
    }
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