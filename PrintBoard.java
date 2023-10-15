public class PrintBoard {
    public static void print(gameBoard g, gameBoard q){
        // TODO: print
        //q is the Board of Wall. 1 is horizontal, -1 is vertical, 0 is no wall.
        //qBoard.Board[0][0] is the wall that centered at the lower left corner of gameBoard.Board[0][0]

        // get row and column count
        int row = g.getSizei();
        int col = g.getSizej();

        // construct board header
        String boardStr = "";
        for (int i = 0; i < col; i++) {
            boardStr += "+--";
        }
        boardStr += "+\n";

        // construct board content
        int pieceIdx = 0;
        int wallIdx = 0;
        while (pieceIdx < row) {
            // construct piece string
            for (int j = 0; j < col; j++) {
                boardStr += "|" + g.getBoardij(pieceIdx, j) + " ";
            }
            boardStr += "|\n";

            // construct wall string
            if (pieceIdx != row - 1) {
                boardStr += "+";
                // construct initial wall strings
                String[] wallStrs = new String[2*col-1];
                for (int k = 0; k < wallStrs.length; k++) {
                    if (k % 2 == 0) {
                        wallStrs[k] = "--";
                    } else {
                        wallStrs[k] = "+";
                    }
                }
                for (int j = 0; j < col-1; j++) {
                    // construct wall strings
                    int curWallId = q.Board[wallIdx][j].getId();
                    if (curWallId == 1) {
                        wallStrs[j]   = "——";
                        wallStrs[j+1] = "——";
                        wallStrs[j+2] = "——";
                    } else if (curWallId == -1) {
                        wallStrs[j+1] = "|";
                    }
                }
                for (int k = 0; k < wallStrs.length; k++) {
                    boardStr += wallStrs[k];
                }
                boardStr += "+\n";
                wallIdx++;
            }
            pieceIdx++;
        }

        // construct board tail
        for (int i = 0; i < col; i++) {
            boardStr += "+--";
        }
        boardStr += "+\n";

        // print board
        System.out.println(boardStr);
    }
}
