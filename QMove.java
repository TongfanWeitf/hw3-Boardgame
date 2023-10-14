public class QMove {
    public static void Move(gameBoard g, gameBoard q, String m, int Turns){
        //TODO: validator
        //q is board of walls, 1 is horizontal, -1 is vertical, 0 is no wall.
        //in gameBoard, 0 is no piece, 1 is player 2 's piece (from top, odd Turns ), -1 is player 1 's piece (from bottom, even Turns)
        //Turns start from 0, not 1
        //String m is L for left, R for right, or F for forward(left and right are based on players' side)
        //move the piece if legal, print a warning and jump the turn is illegal
        //only the piece move, not the wall move
    }

    public static void BuildWall(gameBoard q, int i, int j, TTTPiece p){
        //I will write this
    }
}
