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
            set1(0, 1, 0, 2, 0, 2, 1, 2);
        }
        else if (random==2){
            set1(0, 0, 1, 0, 2, 1, 2, 2);
        }
        else if (random==3){
            set3(0, 0, 0, 1, 0, 2);
        }
        else if (random==4){
            set3(0, 0, 1, 0, 2, 0);
        }
        else if (random==5){
            set1(1, 1, 1, 2, 1, 2, 0, 2);
        }
        else if (random==6){
            set1(1, 1, 1, 2, 1, 0, 0, 0);
        }
        else if (random==7){
            set8(0, 0, 1, 0, 2, 0, 2, 1);
        }
        else if (random==8){
            set8(0, 0, 1, 0, 2, 0, 0, 1);
        }
    }

    private void set3(int i2, int i3, int i4, int i5, int i6, int i7) {
        values[i2][i3] = true;
        values[i4][i5] = true;
        values[i6][i7] = true;
    }

    private void set8(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        set3(i2, i3, i4, i5, i6, i7);
        values[i8][i9] = true;
    }

    private void set1(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        set8(0, i2, i3, i4, i5, i6, i7, i8);
        values[i9][2] = true;
    }

    public boolean[][] getValues() {
        return values;
    }
}
