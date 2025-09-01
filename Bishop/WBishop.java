package ChessGame.Bishop;

import java.util.*;
import ChessGame.MainGame.*;
import ChessGame.*;

class checkWBishopMove {
    static char tempBoard[][] = new char[8][8];
    static char blank = '-';


    public void dispMoves(int row, int col, char[][] board) {

        for (int i = 0; i < 8; i++) {
            tempBoard[i] = board[i].clone();
        }

        // diagonals
        // backward 
        // top
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row - 1 - i][col - 2 - i] == blank) {
                    tempBoard[8 - row - 1 - i][col - 2 - i] = '·';
                }  else {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row + 1 + i][col + i] == blank) {
                    tempBoard[8 - row + 1 + i][col + i] = '·';
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        
        // forwards
        // top
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row - 1 - i][col + i] == blank) {
                    tempBoard[8 - row - 1 - i][col + i] = '·';
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row + 1 + i][col - 2 - i] == blank) {
                    tempBoard[8 - row + 1 + i][col - 2 - i] = '·';
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        
        //new showBoard().boardDisp(tempBoard);
        
    }

    public boolean checkMove(int rowF, int colF, char board[][]) {
        if (tempBoard[8 - rowF][colF - 1] == '·' || tempBoard[8 - rowF][colF - 1] == 'X') {
            return true;
        } else {
            return false;
        }
    }

    public void checkAttack(int row, int col, char board[][]) {
        // diagonals
        // backward 
        // top
        boolean targeted = false; // purpose is to break once it hits something, enemy piece
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row - 1 - i][col - 2 - i] != blank && tempBoard[8 - row - 1 - i][col - 2 - i] != '·' && new TeamMate().checkTeam(tempBoard[8 - row - 1 - i][col - 2 - i]) == 0) {
                    tempBoard[8 - row - 1 - i][col - 2 - i] = 'X';
                    targeted = true;
                }  else {
                    continue;
                }

                if (targeted == true) {
                    targeted = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row + 1 + i][col + i] != blank && tempBoard[ 8 - row + 1 + i][col + i] != '·' && new TeamMate().checkTeam(tempBoard[8 - row + 1 + i][col + i]) == 0) {
                    tempBoard[8 - row + 1 + i][col + i] = 'X';
                    targeted = true;
                } else {
                    continue;
                }

                if (targeted == true) {
                    targeted = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        
        // forwards
        // top
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row - 1 - i][col + i] != blank && tempBoard[8 - row - 1 - i][col + i] != '·' && new TeamMate().checkTeam(tempBoard[8 - row - 1 - i][col + i]) == 0) {
                    tempBoard[8 - row - 1 - i][col + i] = 'X';
                    targeted = true;
                } else {
                    continue;
                }

                if (targeted == true) {
                    targeted = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        // bottom
        try {
            for (int i = 0; i < 8; i++) {
                if (tempBoard[8 - row + 1 + i][col - 2 - i] != blank && tempBoard[8 - row + 1 + i][col - 2 - i] != '·' && new TeamMate().checkTeam(tempBoard[8 - row + 1 + i][col - 2 - i]) == 0) {
                    tempBoard[8 - row + 1 + i][col - 2 - i] = 'X';
                    targeted = true;
                } else {
                    continue;
                }

                if (targeted == true) {
                    targeted = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.print("");
        }
        
        new showBoard().boardDisp(tempBoard);
    }
}

public class WBishop {
    static char blank = '-';

    public void move(Turn turn, char board[][]) {
        Scanner sc = new Scanner(System.in);
        showBoard b = new showBoard();

        while (turn == Turn.White) {
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
            if (board[8 - row][col - 1] == '♗') {
                new checkWBishopMove().dispMoves(row, col, board);
                new checkWBishopMove().checkAttack(row, col, board);

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

                if (new checkWBishopMove().checkMove(rowF, colF, board) == false) {
                    System.out.printf("Invalid move! %s to %s", initPos, finalPos);
                    continue;
                } else {
                    // replace init pos with _
                    board[8 - row][col - 1] = blank;
                    // move pawn to final pos
                    board[8 - rowF][colF - 1] = '♗';
                }

                // show board
                b.boardDisp(board);

                turn = Turn.Black; 
                new selPiece().select(turn, board);
            } else {
                System.out.println("Selected piece is not a white bishop!");
                continue; 
            }

            sc.close();
        }
    }
}
