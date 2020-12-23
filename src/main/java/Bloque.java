public class Bloque {
    boolean [][]values = new boolean[3][3];

    public Bloque() {
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                values[i][j]=false;
            }
        }

        int random = (int)(Math.random() * (9) + 1);
        if (random==1){
                values[0][0] = true;
                values[1][0] = true;
                values[2][0] = true;
                values[2][1] = true;
                values[2][2] = true;
        }
        else if (random==2){
                values[0][0] = true;
                values[0][1] = true;
                values[0][2] = true;
                values[1][2] = true;
                values[2][2] = true;
        }
        else if (random==3){
                values[0][0] = true;
                values[0][1] = true;
                values[0][2] = true;
        }
        else if (random==4){
            values[0][0] = true;
            values[1][0] = true;
            values[2][0] = true;
        }
        else if (random==5){
            values[0][1] = true;
            values[1][1] = true;
            values[2][1] = true;
            values[2][0] = true;
            values[2][2] = true;
        }
        else if (random==6){
            values[0][1] = true;
            values[1][1] = true;
            values[2][1] = true;
            values[0][0] = true;
            values[0][2] = true;
        }
        else if (random==7){
            values[0][0] = true;
            values[1][0] = true;
            values[2][0] = true;
            values[2][1] = true;
        }
        else if (random==8){
            values[0][0] = true;
            values[1][0] = true;
            values[2][0] = true;
            values[0][1] = true;
        }
    }

    public boolean[][] getValues() {
        return values;
    }
}
