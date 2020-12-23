import java.util.Scanner;
import java.util.logging.Logger;


public class Blockudoku {
    private int puntaje=0;
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

    void display(boolean testing){
        if(!testing){
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if(!matrix[i][j])
                        logger.info("X");
                    else
                        logger.info(" ");
                }
                logger.info("\n");
            }
        }
    }

    void playTurn(boolean testing){


        Bloque bloque= new Bloque();
        boolean [][] values= bloque.getValues();

        displayBloque(values,testing);

        int x;
        int y;
        if(!testing) {
            logger.info("Introduzca en x de la esquina superior derecha del bloque:");
            x = scanner.nextInt();
            logger.info("Introduzca en y de la esquina superior derecha del bloque:");
            y = scanner.nextInt();
            return;
        }

        else{

            x =  bloque.getRandomNumberInRange(2,8);
            y =  bloque.getRandomNumberInRange(0,6);
        }


        if(!verificarPuedeSerJugado(bloque,x,y)){
            canPlay=false;
        }

        else{
            realizarJugada(bloque,x,y);
        }
    }

    void displayBloque(boolean[][] values, boolean testing) {
        if(!testing){
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if(!values[i][j])
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
                if(bloque.getValues()[i][j] && matrix[y][temp1])
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
        boolean bloqueValor=true;

        for(int i=0;i<3;++i){
            filas[i]=true;
            columnas[i]=true;
        }


        temp1=x-2;
        for(int it=0;it<3;++it,++temp1,++y){
            for(int i=0; i<9; ++i){
                if(!matrix[i][temp1])
                    filas[it]= false;
                if(!matrix[y][i])
                    columnas[it]=false;
            }
        }


        bloqueValor = verificarBloque(x, y, bloqueValor);


        adicionarPuntaje(filas, columnas, bloqueValor);

        limpiarAciertos(x, y, filas, columnas, bloqueValor);
    }


    private void limpiarAciertos( int x, int y, boolean [] filas, boolean [] columnas, boolean bloque){
        for(int i=0;i<3;++i){
            if(filas[i])
                limpiarFila(y,i);
            if(columnas[i])
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

    void limpiarFila(int y,int i){
        for(int j=0;j<9;++j)
            matrix[y+i][j]=false;
    }

    void limpiarColumna(int x,int i){
        x-=2;
        for(int j=0;j<9;++j)
            matrix[x+i][j]=false;
    }


    private boolean verificarBloque(int x, int y, boolean bloqueValor) {
        for(int i=0; i<3; ++i){
            for(int j =0; j< 3; ++j){
                if(!matrix[j][i])
                    bloqueValor =false;
            }
        }
        return bloqueValor;
    }

    private void adicionarPuntaje(boolean[] filas, boolean[] columnas, boolean bloqueValor) {
        for(int i=0;i<3;++i){
            if(filas[i]){
                this.puntaje += 120;
            }

            if(columnas[i]){
                this.puntaje+=120;
            }
        }

        if (bloqueValor ){
            this.puntaje+=150;
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
