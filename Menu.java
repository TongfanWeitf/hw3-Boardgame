import java.util.Scanner;

//general menu
public class Menu {
    public static void main(String args[]) {
        //validators
        System.out.println("Welcome to BoradGame of Tongfan Wei. Press Ctrl + C to exit anytime.");
        System.out.println("what game you want to play?: ");
        System.out.println("A:Tictactoe B:Order&Chaos C:SuperTTT");
        System.out.println("press A or B or C to continue");
        Scanner myObj = new Scanner(System.in);
        String Choice=myObj.nextLine();
        while(!(Choice.equals("A")) && !(Choice.equals("B")) && !(Choice.equals("C"))) {
            System.out.println("Invalid input");
            System.out.println("what game you want to play?: ");
            System.out.println("A:Tictactoe B:Order&Chaos C:SuperTTT");
            System.out.println("press A or B or C to continue");
            Choice = myObj.nextLine();
        }

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
        }
    }
}
