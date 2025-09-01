package ChessGame.Pawn;

import ChessGame.MainGame.*;
import ChessGame.*;
import java.util.*;

class checkWPawnMove {
    static char blank = '-';
    static char[][] tempBoard = new char[8][8]; 

    // display possible moves on board
    public void dispMoves(int row, int col, char[][] board) {
        // move

        for (int i = 0; i < 8; i++) {
            tempBoard[i] = board[i].clone();
        }

        try {
            if (tempBoard[8 - row - 1][col - 1] == blank) {
                tempBoard[8 - row - 1][col - 1] = '·';
                    if (tempBoard[8 - row - 2][col - 1] == blank && row == 2) { // row == 2 if pawn started at the beginning (initPos)
                    tempBoard[8 - row - 2][col - 1] = '·';
                }
                
            } 
        } catch (Exception e) {
            
        }

        // new showBoard().boardDisp(tempBoard);
    }

    // now check if final move lands on an '·' 
    public boolean checkMove(int rowF, int colF, char[][] board) {
        // O = legal move, X = legal take
        if (tempBoard[8 - rowF][colF - 1] == '·' || tempBoard[8 - rowF][colF - 1] == 'X') {
            return true;
        } else {
            return false;
        }
    }  

    // check init pos to see its adjacent
    public void checkAttack(int row, int col, char[][] board) {
        // check one square diagonal north
        // set not blank piece to X
        

        if ((col - 1) > 0 && tempBoard[8 - row - 1][col - 2] != blank && new TeamMate().checkTeam(tempBoard[8 - row - 1][col - 2]) == 0) {
            tempBoard[8 - row - 1][col - 2] = 'X';
        } 
        if ((col - 1) < 7 && tempBoard[8 - row - 1][col] != blank && new TeamMate().checkTeam(tempBoard[8 - row - 1][col]) == 0) {
            tempBoard[8 - row - 1][col] = 'X';
        }
        
        // display board with X indicator
        new showBoard().boardDisp(tempBoard);

    }

    // en passant cuh
    public void EnPassant(int row, int col, char[][] board) {

        // System.out.println("En passant test " + (8 - row) + " " + col + " BPawn row: " + BPawn.row);
        if ((col - 1) > 0 && tempBoard[8 - row][col - 2] == '♟' & BPawn.row == 7 & (BPawn.col - 1) < col - 1) {
            tempBoard[8 - row - 1][col - 2] = 'X';
        }
        if ((col - 1) < 7 && tempBoard[8 - row][col] == '♟' & BPawn.row == 7 & (BPawn.col - 1) > col - 1) {
            tempBoard[8 - row - 1][col] = 'X';
        }

    }
}


public class WPawn {
    static char blank = '-';
    static int row, col;
    public void move(MainGame.Turn turn, char[][] board) {
        // make them choose which pawn in the board
        Scanner sc = new Scanner(System.in);
        showBoard b = new showBoard();

        while (turn == Turn.White) {
            String initPos, finalPos;

            try {
                System.out.print("\nInitial Position: ");
                initPos = sc.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println("Invalid input. Try again!");
                continue;
            }
            // separate letter and digit for safety no matter what
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
            if (board[8 - row][col - 1] == '♙') {
                // display moves if true
                new checkWPawnMove().dispMoves(row, col, board);
                new checkWPawnMove().EnPassant(row, col, board);
                new checkWPawnMove().checkAttack(row, col, board);
                // declare final pos
                int rowF, colF;
                System.out.print("\nFinal Position: ");
                try {
                    finalPos = sc.nextLine().toLowerCase();
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again!");
                    continue;
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
                if (new checkWPawnMove().checkMove(rowF, colF, board) == false) {
                    System.out.printf("\nInvalid move! %s to %s\n", initPos, finalPos);
                    continue;
                } 

                // replace init pos with _
                System.out.println(BPawn.row);
                /* if (BPawn.row == 7) {
                    board[8 - rowF + 1][colF - 1] = blank;
                } */
                board[8 - row][col - 1] = blank;
                // move pawn to final pos
                board[8 - rowF][colF - 1] = '♙';

                // check if legible for promotion
                if (board[0][colF - 1] == '♙') {
                    new PawnPromotion().checkPromote(board, rowF, colF);
                }

                // show board
                b.boardDisp(board);

                turn = Turn.Black;
                new selPiece().select(turn, board);
            } else {
                System.out.println("Selected piece is not a white pawn!");
                continue;
            }

        }

        sc.close();
    }
}
