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

    private void display(boolean testing){
        if(!testing){
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if(matrix[i][j] == false)
                        logger.info("X");
                    else
                        logger.info(" ");
                }
                logger.info("\n");
            }
        }
    }

    private void playTurn(boolean testing){


        Bloque bloque= new Bloque();
        boolean [][] values= bloque.getValues();

        displayBloque(values,testing);

        int x,y;
        if(!testing) {
            logger.info("Introduzca en x de la esquina superior derecha del bloque:");
            x = scanner.nextInt();
            logger.info("Introduzca en y de la esquina superior derecha del bloque:");
            y = scanner.nextInt();
        }

        else{
            x = (int)(Math.random() * (8 - 2 + 1) + 2);
            y =  (int)(Math.random() *  (6 - 0 + 1) + 0);
        }


        if(!verificarPuedeSerJugado(bloque,x,y)){
            canPlay=false;
        }

        else{
            realizarJugada(bloque,x,y);
        }
    }

    private void displayBloque(boolean[][] values, boolean testing) {
        if(!testing){
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if(values[i][j] == false)
                        logger.info("X");
                    else
                        logger.info(" ");
                }
                logger.info("\n");
            }
        }
    }

    private boolean verificarPuedeSerJugado(Bloque bloque,int x, int y){
        boolean answer=true;
        int temp1=x-2;

        for (int i = 0; i < 3; ++i,++y){
            for (int j = 0; j < 3; ++j,++temp1) {
                if(bloque.getValues()[i][j]== true && matrix[y][temp1] == true)
                    return false;
            }
            temp1=x-2;
        }
        return answer;
    }

    private void realizarJugada(Bloque bloque, int x,int y){
        int temp1=x-2;
        int temp2=y;
        for (int i=0; i <3; ++temp2, ++i) {
            for (int j = 0; j< 3; ++j, ++temp1) {
                matrix[temp2][temp1]= bloque.getValues()[i][j];
            }
            temp1=x-2;
        }

        boolean []filas = new boolean[3];
        boolean []columnas = new boolean[3];
        boolean bloque_valor=true;

        for(int i=0;i<3;++i){
            filas[i]=true;
            columnas[i]=true;
        }


        temp1=x-2;
        for(int it=0;it<3;++it,++temp1,++y){
            for(int i=0; i<9; ++i){
                if(matrix[i][temp1]==false)
                    filas[it]= false;
                if(matrix[y][i]==false)
                    columnas[it]=false;
            }
        }


        bloque_valor = verificarBloque(x, y, bloque_valor);


        adicionarPuntaje(filas, columnas, bloque_valor);

        limpiarAciertos(x, y, filas, columnas, bloque_valor);
    }


    private void limpiarAciertos( int x, int y, boolean [] filas, boolean [] columnas, boolean bloque){
        for(int i=0;i<3;++i){
            if(filas[i]==true)
                limpiarFila(y,i);
            if(columnas[i]==true)
                limpiarColumna(x,i);
        }

        if(bloque){
            int temp1=x-2;
            int temp2=y;
            for (int i=0; i <3; ++temp2, ++i) {
                for (int j = 0; j< 3; ++j, ++temp1) {
                    matrix[temp2][temp1]= false;
                }
                temp1=x-2;
            }
        }
    }

    private void limpiarFila(int y,int i){
        for(int j=0;j<9;++j)
            matrix[y+i][j]=false;
    }

    private void limpiarColumna(int x,int i){
        x-=2;
        for(int j=0;j<9;++j)
            matrix[x+i][j]=false;
    }


    private boolean verificarBloque(int x, int y, boolean bloque_valor) {
        for(int i=0; i<3; ++i){
            for(int j =0; j< 3; ++j){
                if(matrix[j][i]==false)
                    bloque_valor =false;
            }
        }
        return bloque_valor;
    }

    private void adicionarPuntaje(boolean[] filas, boolean[] columnas, boolean bloque_valor) {
        for(int i=0;i<3;++i){
            if(filas[i]==true){
                puntaje += 120;
            }

            if(columnas[i]==true){
                puntaje+=120;
            }
        }

        if (bloque_valor ==true){
            puntaje+=150;
        }
    }

    void playGame(boolean testing){
        while(this.canPlay){
            display(testing);
            playTurn(testing);
        }
        logger.info("GAME OVER");
    }
}
