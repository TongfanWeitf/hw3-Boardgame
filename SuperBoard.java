//super Board that contains smaller boards
public class SuperBoard implements Board{
    public static gameBoard[][] getBoard() {
        return Board;
    }
    public static gameBoard[][] Board;
    public static gameBoard WinBoard;
    private static int sizei;
    private static int sizej;
    public int getSize(){
        if(sizei<=sizej){return sizei;}
        return sizej;
    }
    public gameBoard getSmall(int i, int j){
        return Board[i][j];
    }
    //initialization
    public static void newBoard(int msizei,int msizej){
        sizei=msizei;
        sizej=msizej;
        Board = new gameBoard[sizei][sizej];
        WinBoard = new gameBoard();
        WinBoard.newBoard(sizei,sizej);
        for(int i=0;i<sizei;i++){
            for(int j=0;j<sizej;j++){
                gameBoard b = new gameBoard();
                b.newBoard(3,3);
                Board[i][j]=b;
            }
        }
    }

    //move the piece
    public void Move(char s, int i, int j, Cell p){
        int si=((int) s)-65;
        int bigi=si/sizei;
        int bigj=si%sizej;
        this.Board[bigi][bigj].Move(i,j,p);
        TTTPiece newP=new TTTPiece(TTTwin.winCheck(this.Board[bigi][bigj]));
        this.WinBoard.Move(bigi, bigj,newP);
        WinBoard.print();
        if(newP.getId()!=0){
            System.out.printf(s+" part is won by "+ newP.getName());
            System.out.printf("\n");
        }
    }

    //win condition check for hte big board by theresults of the smaller boards.
    public int BigWin(){
        return TTTwin.winCheck(WinBoard);
    }
    //pribt the board
    public void print(){
        //print the A,B,C...to represent the big board
        int k=65;
        for(int i=0;i<sizei;i++){
            for(int j=0;j<sizej;j++){
                System.out.printf(((char) k)+" ");
                k++;
            }
            System.out.printf("\n");
        }
        //print the actuall board
        int Sizej=sizej*3*3+1;
        int Sizei=sizei*2*3+1;
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
                        int bigi=(i-1)/2;
                        int bigj=(j-1)/3;
                        gameBoard b = Board[bigi/3][bigj/3];
                        System.out.printf(b.getBoardij(bigi%3,bigj%3));
                    }else{
                        System.out.printf(" ");
                    }
                }
            }
            System.out.printf("\n");
        }
    }
}
