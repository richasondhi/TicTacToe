import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameTest {
    private TicTacToeGame game;

    @Before
    public void setUp() {
        this.game = new TicTacToeGame();
    }


    @Test(expected = RuntimeException.class)
    public void whenXOutsideBoardException() {
        game.printBoard(new char[4][2]);

    }
}
