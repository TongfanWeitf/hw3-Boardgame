import java.util.Scanner;

//general menu
public class Menu {
    public static void main(String args[]) {
        //validators
        System.out.println("Welcome to BoradGame of Tongfan Wei. Press Ctrl + C to exit anytime.");
        System.out.println("what game you want to play?: ");
        System.out.println("A:Tictactoe B:Order&Chaos C:SuperTTT D:Quoridor");
        Scanner myObj = new Scanner(System.in);
        String[] SA = {"A","B","C","D"};
        String Choice=inputV.inputSA(SA);

        //go to the game and play
        if(Choice.equals("A")){
            Ttt Tic= new Ttt();
            Tic.Play();
        }else if(Choice.equals("B")){
            OAC Oc=new OAC();
            Oc.Play();
        }else if(Choice.equals("C")){
            SuperTTT Sttt= new SuperTTT();
            Sttt.Play();
        }else if(Choice.equals("D")){
            Quoridor quoridor = new Quoridor();
            quoridor.Play();
        }
    }
}
