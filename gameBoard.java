//basic gameboard for TTT
public class gameBoard implements Board{
    public Cell[][] getBoard() {
        return Board;
    }
    public String getBoardij(int i, int j) {
        return Board[i][j].getName();
    }

    public int getBoardOut(int i, int j){
//        i=i+1;
//        j=j+1;
        if(i<0 || i>=sizei || j<0 || j>=sizej){return 0;}
        return Board[i][j].getId();
    }
    public Cell[][] Board;
    private int sizei;
    private int sizej;

    public int getSize(){
        if(sizei>=sizej){
            return sizej;
        }
        return sizei;
    }
    public int getSizei(){
        return sizei;
    }
    public int getSizej(){
        return sizej;
    }

    //initialization
    public void newBoard(int msizei, int msizej){
        sizei=msizei;
        sizej=msizej;
        Board = new TTTPiece[sizei][sizej];

        for(int i=0;i<sizei;i++){
            for(int j=0;j<sizej;j++){
                Cell p=new TTTPiece(0);
                Board[i][j]=p;
            }
        }
    }

    //print the board
    public void print(){
        int Sizei=sizei*2+1;
        int Sizej=sizej*3+1;
        for (int i=0;i<Sizei;i++){
            if((i%2)==0){
                for (int j=0;j<Sizej;j++){
                    if((j%3)==0){
                        System.out.printf("+");
                    }else{
                        System.out.printf("-");
                    }
                }
            }else{
                for (int j=0;j<Sizej;j++){
                    if((j%3)==0){
                        System.out.printf("|");
                    }else if ((j%3)==1){
                        System.out.printf(Board[(i-1)/2][(j-1)/3].getName());
                    }else{
                        System.out.printf(" ");
                    }
                }
            }
            System.out.printf("\n");
        }
    }

    //move the pieces
    public void Move(int i, int j, Cell p){
        if(i<0||j<0||i>sizei||j>sizej){
            System.out.println("Illiegal move!");
            return;
        }
        if(Board[i][j].getId()!=0) {
            System.out.println("Illiegal move!");
            return;
        }
        this.Board[i][j]=p;
    }

}
