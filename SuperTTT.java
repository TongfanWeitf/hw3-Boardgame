import java.util.Scanner;
//playing superTTT

public class SuperTTT implements BoardGame{
    public String getName(){
        return "Super Tic tec toe";
    }

    //initial the game by create boards and players
    public void Play() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("BigBoard height is?:");
        int Bigsizei = inputV.inputInt(3,5);
        System.out.println("height: " + Bigsizei);

        System.out.println("BigBoard width is?:");
        int Bigsizej = inputV.inputInt(3,5);
        System.out.println("width: " + Bigsizej);

        SuperBoard cBoard=new SuperBoard();

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
        int size=3;

        //play the game until someone quits
        while(NextGame.equals("yes")){
            Player winner=new Player("",0);
            int Turns=0;
            cBoard.newBoard(Bigsizei,Bigsizej);
            cBoard.print();
            while (winner.getName().equals("")){
                Player CurrentP =  null;
                if(Turns%2==0){
                    CurrentP=Pa;
                }else{
                    CurrentP=Pb;
                }

                //validtor for moves
                System.out.println(CurrentP.getName()+"'s move is?:)");
                System.out.println("enter first char in big Board");
                String smoveAc=myObj.nextLine();
                while(Validator.isValidChar(smoveAc,65,64+Bigsizei*Bigsizej)==false){
                    System.out.println("Invalid input");
                    System.out.println("enter first char in big Board");
                    smoveAc=myObj.nextLine();
                }
                char Movec = smoveAc.charAt(0);

                System.out.println("enter first int as row");
                int moveAi = inputV.inputInt(1,size);

                System.out.println("enter second int as col");
                int moveAj = inputV.inputInt(1,size);

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

                //actually moves it
                System.out.println(CurrentP.getName()+"'s move: " + moveAi +", "+moveAj+" in "+Movec);
                cBoard.Move(Movec,moveAi-1,moveAj-1,newP);

                //print the board
                cBoard.print();

                //win condition check
                if(cBoard.BigWin()!=0){
                    winner=cwinner;
                    System.out.println(winner.getName()+" wins!");
                    winner.score++;
                    break;
                }

                Turns++;
                if(Turns>=size*size*9){
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

