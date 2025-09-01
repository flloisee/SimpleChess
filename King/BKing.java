package ChessGame.King;

import java.util.*;
import ChessGame.*;
import ChessGame.MainGame.*;

class checkBKingMove {
    static char tempBoard[][] = new char[8][8];
    static char blank = '-';
    static int moved = 0;


    public void dispMoves(int row, int col, char[][] board) {

        for (int i = 0; i < 8; i++) {
            tempBoard[i] = board[i].clone();
        }

        // show castling moves
        try {
            if (moved <= 0) {
                for (int i = 1; i <= 2; i++) {
                    if (tempBoard[8 - row][col - 1 + i] == blank) {
                        tempBoard[8 - row][col - 1 + i] = '·';
                        if (tempBoard[8 - row][col + 2] == '♜') {
                            tempBoard[8 - row][col + 2] = 'C';
                        }
                    }
                } 
            }
        } catch (Exception e) {
            
        }
        moved = 1;

        // X and Y axis
        // x axis
        try {
            if (tempBoard[8 - row][col - 2] == blank) {
                tempBoard[8 - row][col - 2] = '·';
            } 
        } catch (Exception e) {
            System.out.print("");
        }
        try {
            if (tempBoard[8 - row][col] == blank) {
                    tempBoard[8 - row][col] = '·';
                }
        } catch (Exception e) {
            System.out.print("");
        }

        // y axis
        try {
            if (tempBoard[8 - row - 1][col - 1] == blank) {
                    tempBoard[8 - row - 1][col - 1] = '·';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        try {
            if (tempBoard[8 - row + 1][col - 1] == blank) {
                    tempBoard[8 - row + 1][col - 1] = '·';
                }
        } catch (Exception e) {
            System.out.print("");
        }

        // Diagonal Axis (copy from bishop lmao)
        // backward 
        // top
        try {
            if (tempBoard[8 - row - 1][col - 2] == blank) {
                    tempBoard[8 - row - 1][col - 2] = '·';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            if (tempBoard[8 - row + 1][col] == blank) {
                    tempBoard[8 - row + 1][col] = '·';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        
        // forwards
        // top
        try {
            if (tempBoard[8 - row - 1][col] == blank) {
                    tempBoard[8 - row - 1][col] = '·';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            if (tempBoard[8 - row + 1][col - 2] == blank) {
                    tempBoard[8 - row + 1][col - 2] = '·';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        
        //new showBoard().boardDisp(tempBoard);
        
    }

    public boolean checkMove(int rowF, int colF, char board[][]) {
        if (tempBoard[8 - rowF][colF - 1] == '·' || tempBoard[8 - rowF][colF - 1] == 'X' || tempBoard[8 - rowF][colF - 1] == 'C') {
            return true;
        } else {
            return false;
        }
    }

    public boolean castling(int row, int col, char board[][]) {
        if (tempBoard[8 - row][col + 2] == 'C') {
            // replace pieces on the board
            return true;
        } else {
            return false;
        }
    }

    public void checkAttack(int row, int col, char board[][]) {

        // X and Y Axis
        // x axis
       try {
            if (tempBoard[8 - row][col - 2] != blank && tempBoard[8 - row][col - 2] != '·' && new TeamMate().checkTeam(tempBoard[8 - row][col - 2]) == 0) {
                    tempBoard[8 - row][col - 2] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }

        try {
            if (tempBoard[8 - row][col] != blank & tempBoard[8 - row][col] != '·' && new TeamMate().checkTeam(tempBoard[8 - row][col]) == 0) {
                    tempBoard[8 - row][col] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }

        // y axis
        try {
            if (tempBoard[8 - row - 1][col - 1] != blank & tempBoard[8 - row - 1][col - 1] != '·' && new TeamMate().checkTeam(tempBoard[8 - row - 1][col - 1]) == 0) {
                    tempBoard[8 - row - 1][col - 1] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }

        try {
            if (tempBoard[8 - row + 1][col - 1] != blank & tempBoard[8 - row + 1][col - 1] != '·' && new TeamMate().checkTeam(tempBoard[8 - row + 1][col - 1]) == 0) {
                    tempBoard[8 - row + 1][col - 1] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }

        // Diagonal Axis
         // backward 
        // top
        try {
            if (tempBoard[8 - row - 1][col - 2] != blank && tempBoard[8 - row - 1][col - 2] != '·' && new TeamMate().checkTeam(tempBoard[8 - row - 1][col - 2]) == 0) {
                    tempBoard[8 - row - 1][col - 2] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            if (tempBoard[8 - row + 1][col] != blank && tempBoard[ 8 - row + 1][col] != '·' && new TeamMate().checkTeam(tempBoard[8 - row + 1][col]) == 0) {
                    tempBoard[8 - row + 1][col] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        
        // forwards
        // top
        try {
            if (tempBoard[8 - row - 1][col] != blank && tempBoard[8 - row - 1][col] != '·' && new TeamMate().checkTeam(tempBoard[8 - row - 1][col]) == 0) {
                    tempBoard[8 - row - 1][col] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            if (tempBoard[8 - row + 1][col - 2] != blank && tempBoard[8 - row + 1][col - 2] != '·' && new TeamMate().checkTeam(tempBoard[8 - row + 1][col - 2]) == 0) {
                    tempBoard[8 - row + 1][col - 2] = 'X';
                }
        } catch (Exception e) {
            System.out.print("");
        }
        
        new showBoard().boardDisp(tempBoard);
    }
}

public class BKing {
    static char blank = '-';

    public void move(Turn turn, char board[][]) {
        Scanner sc = new Scanner(System.in);
        showBoard b = new showBoard();

        while (turn == Turn.Black) {
            String initPos = null, finalPos = null;

            int row, col;
            try {
                System.out.print("\nInitial Position: ");
                initPos = sc.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println("Invalid input. Try again!");
            }

            char letter = 0, digit = 0;

            for (char c : initPos.toCharArray()) {
                if (Character.isLetter(c)) {
                    letter = c;
                } else if (Character.isDigit(c)) {
                    digit = c;
                }
            }

            if (letter == 0 || digit == 0) {
                System.out.println("Invalid input! Must be (e.g. e4)");
                continue;
            }

            col = letter - 'a' + 1;
            row = Character.getNumericValue(digit);

            // check if selected is white pawn
            if (board[8 - row][col - 1] == '♚') {
                new checkBKingMove().dispMoves(row, col, board);
                new checkBKingMove().checkAttack(row, col, board);

                // declare final pos
                int rowF, colF;
                try {
                    System.out.print("\nFinal Position: ");
                    finalPos = sc.nextLine().toLowerCase();
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again!");
                }

                letter = digit = 0;
                for (char c : finalPos.toCharArray()) {
                    if (Character.isLetter(c)) {
                        letter = c;
                    } else if (Character.isDigit(c)) {
                        digit = c;
                    }
                }

                if (letter == 0 || digit == 0) {
                    System.out.println("Invalid input! Must be (e.g. e4)");
                    continue;
                }

                colF = letter - 'a' + 1;
                rowF = Character.getNumericValue(digit);

                // check illegal moves
                // check if more than 2 squares moved

                if (new checkBKingMove().checkMove(rowF, colF, board) == false) {
                    System.out.printf("Invalid move! %s to %s", initPos, finalPos);
                    continue;
                } else {
                    // replace init pos with _
                    board[8 - row][col - 1] = blank;
                    // move pawn to final pos
                    board[8 - rowF][colF - 1] = '♚';

                    if (new checkBKingMove().castling(row, col, board) == true) {
                        new Castling().castle(board, row, col);
                    }
                }

                // show board
                b.boardDisp(board);

                turn = Turn.White; 
                new selPiece().select(turn, board);
            } else {
                System.out.println("Selected piece is not a black king!");
                continue; 
            }

            sc.close();
        }
    }
}
