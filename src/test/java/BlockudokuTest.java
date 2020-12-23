import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BlockudokuTest {
    @Test
    public void testCase0() {
        Blockudoku game = new Blockudoku();
        boolean testingMode=true;
        game.playGame(true);
        assertTrue(testingMode);
    }

    @Test
    public  void test1(){
        Blockudoku game = new Blockudoku();
        boolean testingMode=true;
        game.display(false);
        Bloque bloque =new Bloque();
        game.displayBloque( bloque.getValues(), false);

        game.limpiarColumna(3,1);
        game.limpiarFila(3,1);
    }
}