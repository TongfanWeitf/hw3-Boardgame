import java.util.Scanner;

//2 loops to input
public class inputV {
    //input loop for int
    public static int inputInt(int min,int max){
        Scanner myObj = new Scanner(System.in);
        System.out.println("input int from "+min+" to "+max);
        String Ssize=myObj.nextLine();
        while (Validator.isValidString(Ssize,min,max)==false){
            System.out.println("invalid input");
            System.out.println("input int from "+min+" to "+max);
            Ssize=myObj.nextLine();
        }
        int i = Integer.parseInt(Ssize);
        return i;
    }
    //loop to input X and O
    public static String inputXO(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("enter X or O as Piece");
        String smoveP=myObj.nextLine();
        while(smoveP!="X" && smoveP =="O"){
            System.out.println("Invalid input");
            System.out.println("enter X or O as Piece");
            smoveP=myObj.nextLine();
        }
        return smoveP;
    }

    public static String inputSA(String[] SA){
        Scanner myObj = new Scanner(System.in);

        Boolean b=true;
        while(b){
            System.out.print("enter "+SA[0]);
            for (int i=1; i<SA.length; i++){
                System.out.print(" or "+SA[i]);
            }
            System.out.print("\n");
            String smoveP=myObj.nextLine();
            for (int i=0; i<SA.length; i++){
                if(smoveP.equals(SA[i])){
                    return smoveP;
                }
            }
            System.out.println("Invalid input");

        }
        return "";
    }
}
