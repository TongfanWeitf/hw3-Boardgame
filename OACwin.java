//win condition check for OAC
public class OACwin {
    private static gameBoard B;
    public static int winCheck(gameBoard b){
        return 0;
    }
    public static int winOAC(gameBoard b, int i, int j) {
        B = b;
        Cell[][] Board = b.getBoard();
        int size = B.getSize();

        int sum = 0;
        int p = Board[i][j].getId();

        sum = add(Board, i, j, 1, 0, size) + add(Board, i, j, -1, 0, size);
        if (sum == size ) {
            return p;
        }

        sum = add(Board, i, j, 0, 1, size) + add(Board, i, j, 0, -1, size);
        if (sum == size ) {
            return p;

        }

        sum = add(Board, i, j, 1, 1, size) + add(Board, i, j, -1, -1, size);
        if (sum == size ) {
            return p;

        }

        sum = add(Board, i, j, -1, 1, size) + add(Board, i, j, 1, -1, size);
        if (sum == size ) {
            return p;

        }

        return 0;
    }

    private static int add(Cell[][] Board,int ii, int jj, int stepi, int stepj, int size){
        int sum=0;
        int i=ii;
        int j=jj;
        while(i>=0&&i<size&&j>=0&&j<size){
            if(Board[ii][jj].getId()==Board[i][j].getId()){
                sum++;
            }else{
                break;
            }
            i=i+stepi;
            j=j+stepj;
        }
        return sum;
    }
}
