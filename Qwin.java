// wincheck for Quoridor
public class Qwin implements winConditon{
    private static gameBoard B;
    public static int winCheck(gameBoard b){
        B = b;
        Cell[][] Board=b.getBoard();
        int size = B.getSize();
        for(int i=0;i<size;i++){
            if(Board[0][i].getId()==-1){return -1;}
            if(Board[size-1][i].getId()==1){return 1;}
        }
        return 0;
    }
}
