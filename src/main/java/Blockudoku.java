import java.util.Scanner;
import java.util.logging.Logger;


public class Blockudoku {
    public int puntaje=0;
    boolean canPlay=true;
    boolean [][] matrix= new boolean[9] [9];
    Scanner scanner = new Scanner(System.in);

    static final Logger logger = Logger.getLogger(Blockudoku.class.getName());

    public Blockudoku() {

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                matrix[i][j] = false;
            }
        }
    }

    private void display(){
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if(matrix[i][j] = false)
                    logger.info("X");
                else
                    logger.info(" ");
            }
            logger.info("\n");
        }
    }

    private void playTurn(){

        logger.info("El bloque aleatorio es:");

        Bloque bloque= new Bloque();
        boolean [][] values= bloque.getValues();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if(values[i][j] = false)
                    logger.info("X");
                else
                    logger.info(" ");
            }
            logger.info("\n");
        }


        logger.info("Introduzca en x de la esquina superior derecha del bloque:");
        int x = scanner.nextInt();
        logger.info("Introduzca en y de la esquina superior derecha del bloque:");
        int y = scanner.nextInt();

        if(!verificarPuedeSerJugado(bloque)){
            canPlay=true;
        }

        else{
            realizarJugada(bloque,x,y);
        }
    }

    private boolean verificarPuedeSerJugado(Bloque bloque){
        boolean answer=true;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if(values[i][j]= true and matrix[i][j] = true)
                    return false;
            }
        }
        return answer;
    }

    private void realizarJugada(Bloque bloque, int x,int y){
        int temp1=x+3;
        int temp2=y+3;
        for (int i=0; x < temp1; ++x, ++i) {
            for (int j = 0; y < temp2; ++j, ++y) {
                matrix[x][y]= values[i][j];
            }
        }

        boolean []filas = new boolean[3];
        for(int i=0;i<9;++i){

        }

    }

    void playGame(){
        while(this.canPlay){
            playTurn();
        }
        logger.info("GAME OVER");
    }

}