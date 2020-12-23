import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BlockudokuTest {
    @Test
    public void testCase0() {
        Blockudoku game = new Blockudoku();
        game.playGame(true);
        assertTrue(true);
    }
}