import java.util.Scanner; 
//playing ttt
public class Ttt implements BoardGame{
    public String getName(){
        return "Tic tec toe";
    }

    //initial the game by creating the board and players
    public void Play() {
      Scanner myObj = new Scanner(System.in);
      System.out.println("height is?");
      int sizei = inputV.inputInt(3,20);
      System.out.println("height: " + sizei);

      System.out.println("width is?");
      int sizej = inputV.inputInt(3,20);
      System.out.println("width: " + sizej);

      gameBoard cBoard=new gameBoard();

      System.out.println("Player A's name is?: ");
      String sPa=myObj.nextLine();
      Player Pa = new Player(sPa, 0);
      System.out.println("Player A: " + Pa.getName()+". Piece is X");
      System.out.println("Player B's name is?: ");
      String sPb=myObj.nextLine();
      Player Pb = new Player(sPb,0);
      System.out.println("Player B: " + Pb.getName()+". Piece is O");
      String NextGame="yes";
      int CountS=0;

      //actually playing the game until someone quits
      while(NextGame.equals("yes")){
        Player winner=new Player("",0);
        int Turns=0;
        cBoard.newBoard(sizei, sizej);
        cBoard.print();
        while (winner.getName().equals("")){
            Player CurrentP =  null;
            if(Turns%2==0){
                CurrentP=Pa;
            }else{
                CurrentP=Pb;
            }

            //validator for move inputs
            System.out.println(CurrentP.getName()+"'s move is?:)");

            System.out.println("enter first int as row");
            int moveAi = inputV.inputInt(1,sizei);

            System.out.println("enter second int as col");
            int moveAj = inputV.inputInt(1,sizej);

            String smoveP=inputV.inputXO();
            Player cwinner= new Player("",0);
            TTTPiece newP=new TTTPiece(0);
            if (smoveP.equals("X")){
                newP.setId(1);
                if (Turns%2==1){
                    System.out.println("WARNING: not your piece");
                }
                cwinner=Pa;

            }else{
                newP.setId(-1);
                if (Turns%2==0){
                    System.out.println("WARNING: not your piece");
                }
                cwinner=Pb;
            }

            //actuall move the pieces
            System.out.println(CurrentP.getName()+"'s move: " + moveAi +", "+moveAj);
            cBoard.Move(moveAi-1,moveAj-1,newP);

            //print the board
            cBoard.print();

            //win condition check
            if(TTTwin.winCheck(cBoard)!=0){
                winner=cwinner;
                System.out.println(winner.getName()+" wins!");
                winner.score++;
                break;
            }
            
            Turns++;
            if(Turns>=sizei*sizej){
                CountS++;
                System.out.println("Stalemate");
                break;
            }

        }
        System.out.println("Do you want to play again?");
        System.out.println("Enter yes to continue, everything else than yes to quit");
        NextGame=myObj.nextLine();
      }
      System.out.println(Pa.getName()+" wins: " + Pa.score);
      System.out.println(Pb.getName()+" wins: " + Pb.score);
      System.out.println("Stalemates: " + CountS);
    }
}
    
