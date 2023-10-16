public class PrintBoard {
    public static void print(gameBoard g, gameBoard q){
        // TODO: print
        //q is the Board of Wall. 1 is horizontal, -1 is vertical, 0 is no wall.
        //qBoard.Board[0][0] is the wall that centered at the lower left corner of gameBoard.Board[0][0]

        // get row and column count
        int row = g.getSizei();
        int col = g.getSizej();
        q.print();
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
            boardStr += "|";
            for (int j = 0; j < col; j++) {
                boardStr += g.getBoardij(pieceIdx, j) + " ";
                if (j != col-1) {
                    if (pieceIdx == 0) {
                        if (q.getBoardOut(0,j) == -1) {
                            boardStr += "*";
                        } else {
                            boardStr += "|";
                        }
                    } else if (pieceIdx == row-1) {
                        if (q.getBoardOut(row-2,j) == -1) {
                            boardStr += "*";
                        } else {
                            boardStr += "|";
                        }
                    } else {
                        if (q.getBoardOut(pieceIdx-1,j) == -1 || q.getBoardOut(pieceIdx,j) == -1) {
                            boardStr += "*";
                        } else {
                            boardStr += "|";
                        }
                    }
                }
            }
            boardStr += "|\n";

            // construct wall string
            if (pieceIdx != row - 1) {
                boardStr += "";
                // construct initial wall strings
                String[] wallStrs = new String[3*col];
                for (int j = 0; j < 3*col; j++) {
                    // construct wall strings
                    int curWallId0 = q.getBoardOut(wallIdx,j/3);
                    int curWallId = q.getBoardOut(wallIdx,j/3-1);
                    int curWallId2 = q.getBoardOut(wallIdx,j/3-2);
                    if(j%3==0){
                        if(curWallId==0){
                            wallStrs[j]   = "+";
                        }else{
                            wallStrs[j]   = "*";
                        }
                    }
                    if(j%3!=0){
                        if(curWallId==1 || curWallId0==1){
                            wallStrs[j]   = "*";
                        }else{
                            wallStrs[j]   = "-";
                        }
                    }
//                    if (curWallId1 == 1) {
//                        wallStrs[j+2]   = "**";
//                        wallStrs[j+3] = "*";
//                        wallStrs[j+4] = "**";
//                    } else if (curWallId1 == -1) {
//                        wallStrs[j+2] = "*";
//                    }
//                    int curWallId2 = q.getBoardOut(wallIdx,j+1);
//                    if (curWallId2 == 1) {
//                        wallStrs[j+2]   = "**";
//                        wallStrs[j+3] = "*";
//                        wallStrs[j+4] = "**";
//                    } else if (curWallId2 == -1) {
//                        wallStrs[j+2] = "*";
//                    }
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
