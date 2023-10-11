//win condition check for ttt
public class TTTwin implements winConditon{
    private static gameBoard B;
    public static int winCheck(gameBoard b){
        B = b;
        Cell[][] Board=b.getBoard();
        int size = B.getSize();
        int sum=0;
        for(int i=0;i<size;i++){
            sum=0;
            for(int j=0;j<size;j++){
                sum+=Board[i][j].getId();
            }
            if((sum==size)||(0-sum==size)){return sum/size;}
        }
        for(int j=0;j<size;j++){
            sum=0;
            for(int i=0;i<size;i++){
                sum+=Board[i][j].getId();
            }
            if((sum==size)||(0-sum==size)){return sum/size;}
        }
        sum=0;
        for(int i=0;i<size;i++){
            sum+=Board[i][i].getId();
        }
        if((sum==size)||(0-sum==size)){return sum/size;}
        sum=0;
        for(int i=0;i<size;i++){
            sum+=Board[i][size-1-i].getId();
        }
        if((sum==size)||(0-sum==size)){return sum/size;}
        return 0;
    }
}
