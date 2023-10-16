import java.util.Scanner;

public class Quoridor implements BoardGame{
    public String getName(){
        return "Quoridor";
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
        gameBoard qBoard = new gameBoard();

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
            qBoard.newBoard(sizei-1, sizej-1);
            cBoard.Board[0][sizej/2].setId(1);
            cBoard.Board[sizei-1][sizej/2].setId(-1);
            PrintBoard.print(cBoard,qBoard);

            int Walla=sizei;
            int Wallb=sizei;

            while (winner.getName().equals("")){
                Player CurrentP =  null;
                if(Turns%2==0){
                    CurrentP=Pa;
                }else{
                    CurrentP=Pb;
                }

                //validator for move inputs
                System.out.println(CurrentP.getName()+"'s move is?:)");
                System.out.println("enter A to put a wall, enter B to move your piece");
                String[] AB = {"A", "B"};
                String choiceS = inputV.inputSA(AB);
                if(choiceS.equals("A")) {
                    if((Turns%2==0) && Walla<=0){
                        System.out.println("Wall used out, please move piece");
                        choiceS="B";
                    }
                    if((Turns%2==1) && Wallb<=0){
                        System.out.println("Wall used out, please move piece");
                        choiceS="B";
                    }
                }
                if(choiceS.equals("A")) {

                    System.out.println("enter first int as row");
                    int moveAi = inputV.inputInt(1, sizei-1);

                    System.out.println("enter second int as col");
                    int moveAj = inputV.inputInt(1, sizej-1);

                    System.out.println("enter A to put a horizontal wall, B to vertical");
                    String smoveP = inputV.inputSA(AB);

                    TTTPiece newP = new TTTPiece(0);
                    if (smoveP.equals("A")) {
                        newP.setId(1);
                    } else {
                        newP.setId(-1);
                    }

                    //actuall move the pieces
                    System.out.println(CurrentP.getName() + "'s move: " + moveAi + ", " + moveAj);
                    QMove.BuildWall(qBoard,moveAi-1 , moveAj-1 , newP);
                    if(Turns%2==0){
                        Walla--;
                    }else{
                        Wallb--;
                    }
                }else {
                    System.out.println("enter L for left, R for right, or F for forward");
                    String[] LRF = {"L", "R", "F"};
                    String smoveP = inputV.inputSA(LRF);
                    QMove.Move(cBoard, qBoard, smoveP, Turns);

                }
                //print the board
                PrintBoard.print(cBoard,qBoard);

                //win condition check
                if(Qwin.winCheck(cBoard)!=0){
                    winner=CurrentP;
                    System.out.println(winner.getName()+" wins!");
                    winner.score++;
                    break;
                }

                Turns++;
//                if(Turns>=sizei*sizej){
//                    CountS++;
//                    System.out.println("Stalemate");
//                    break;
//                }

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
