public class QMove {
    public static void Move(gameBoard g, gameBoard q, String m, int Turns){
        //TODO: validator
        //q is board of walls, 1 is horizontal, -1 is vertical, 0 is no wall.
        //in gameBoard, 0 is no piece, 1 is player 2 's piece (from top, odd Turns ), -1 is player 1 's piece (from bottom, even Turns)
        //Turns start from 0, not 1
        //String m is L for left, R for right, or F for forward(left and right are based on players' side)
        //move the piece if legal, print a warning and jump the turn is illegal
        //only the piece move, not the wall move

        // get target piece
        int targetPieceId = 0;
        Cell targetCell = null;
        if (Turns % 2 == 0) {
            targetPieceId = -1;
        } else {
            targetPieceId = 1;
        }

        // get target piece current location
        int curRow = -1;
        int curCol = -1;
        for (int i = 0; i < g.getSizei(); i++) {
            for (int j = 0; j < g.getSizej(); j++) {
                if (g.getBoard()[i][j].getId() == targetPieceId) {
                    curRow = i;
                    curCol = j;
                    targetCell = g.getBoard()[i][j];
                    break;
                }
            }
        }

        // get piece location
        int oldRow = curRow;
        int oldCol = curCol;
        if (m.equals("L")) { // move left
            if (targetPieceId == 1) { // from top
                if (curCol == g.getSizej() - 1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == 0 && q.getBoard()[0][curCol].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == g.getSizei()-1 && q.getBoard()[curRow-1][curCol].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if ((curRow != 0 && curRow != g.getSizei()-1) &&
                        (q.getBoard()[curRow-1][curCol].getId() == -1 ||
                        q.getBoard()[curRow][curCol].getId() == -1)) {
                    System.out.println("Illegal move!");
                    return;
                }
                curCol++;
            } else { // from bottom
                if (curCol == 0) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == 0 && q.getBoard()[0][curCol-1].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == g.getSizei()-1 && q.getBoard()[curRow-1][curCol-1].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if ((curRow != 0 && curRow != g.getSizei()-1) && (
                        q.getBoard()[curRow-1][curCol-1].getId() == -1 ||
                        q.getBoard()[curRow][curCol-1].getId() == -1)) {
                    System.out.println("Illegal move!");
                    return;
                }
                curCol--;
            }
        } else if (m.equals("R")) { // move right
            if (targetPieceId == 1) { // from top
                if (curCol == 0) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == 0 && q.getBoard()[0][curCol-1].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == g.getSizei()-1 && q.getBoard()[curRow-1][curCol-1].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if ((curRow != 0 && curRow != g.getSizei() - 1) &&
                        (q.getBoard()[curRow-1][curCol-1].getId() == -1 ||
                        q.getBoard()[curRow][curCol-1].getId() == -1)) {
                    System.out.println("Illegal move!");
                    return;
                }
                curCol--;
            } else { // from bottom
                if (curCol == g.getSizej() - 1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == 0 && q.getBoard()[0][curCol].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curRow == g.getSizei()-1 && q.getBoard()[curRow-1][curCol].getId() == -1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if ((curRow != 0 && curRow != g.getSizei() - 1) &&
                        (q.getBoard()[curRow-1][curCol].getId() == -1 ||
                        q.getBoard()[curRow][curCol].getId() == -1)) {
                    System.out.println("Illegal move!");
                    return;
                }
                curCol++;
            }
        } else { // move forward
            if (targetPieceId == 1) { // from top
                if (curRow == g.getSizei()-1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curCol == 0 && q.getBoard()[curRow][0].getId() == 1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curCol == g.getSizej()-1 && q.getBoard()[curRow][curCol-1].getId() == 1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if ((curCol != 0 && curCol != g.getSizej() - 1) &&
                        (q.getBoard()[curRow][curCol-1].getId() == 1 ||
                        q.getBoard()[curRow][curCol].getId() == 1)) {
                    System.out.println("Illegal move!");
                    return;
                }
                curRow++;
            } else { // from bottom
                if (curRow == 0) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curCol == 0 && q.getBoard()[curRow-1][0].getId() == 1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if (curCol == g.getSizej()-1 && q.getBoard()[curRow-1][curCol-1].getId() == 1) {
                    System.out.println("Illegal move!");
                    return;
                }
                if ((curCol != 0 && curCol != g.getSizej() - 1) &&
                        (q.getBoard()[curRow-1][curCol-1].getId() == 1 ||
                        q.getBoard()[curRow-1][curCol].getId() == 1)) {
                    System.out.println("Illegal move!");
                    return;
                }
                curRow--;
            }
        }

        if(g.getBoard()[curRow][curCol].getId()!=0 && !m.equals("F")) {
            System.out.println("Illegal move!");
            return;
        }
        if(g.getBoard()[curRow][curCol].getId()!=0 && m.equals("F")) {
            if(Turns%2==0){
                curRow--;
            }else{
                curRow++;
            }
        }
        // check move is valid or not
        g.Move(curRow, curCol, targetCell);
        g.getBoard()[oldRow][oldCol] = new TTTPiece(0);
    }

    public static void BuildWall(gameBoard q, int i, int j, TTTPiece p){
        System.out.println("i: "+i+" j: "+j);
        int sizei= q.getSizei();
        int sizej= q.getSizej();
        Cell[][] Board = q.Board;
        //I will write this
        if(i<0||j<0||i>sizei||j>sizej){
            System.out.println("Illiegal move!");
            return;
        }
        if(Board[i][j].getId()!=0) {
            System.out.println("Illiegal move!");
            return;
        }
        if(p.getId()==-1){
            int upper=0;
            if(j-1<0){
                upper=0;
            }else{
                upper=Board[i][j-1].getId();
            }
            int lower=0;
            if(j+1>=sizej){
                lower=0;
            }else{
                lower=Board[i][j+1].getId();
            }
            if((upper==-1) ||(lower==-1)){
                System.out.println("Illiegal move!");
                return;
            }
        } else if (p.getId()==1) {
            int left=0;
            if(i-1<0){
                left=0;
            }else{
                left=Board[i-1][j].getId();
            }
            int right=0;
            if(i+1>=sizei){
                right=0;
            }else{
                right=Board[i+1][j].getId();
            }
            if((left==1) ||(right==1)){
                System.out.println("Illiegal move!");
                return;
            }
        }
        Board[i][j]=p;
    }
}
