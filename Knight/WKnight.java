package ChessGame.Knight;

import java.util.*;
import ChessGame.MainGame.*;
import ChessGame.*;

class checkWKnightMove {
    static char tempBoard[][] = new char[8][8];
    static char blank = '-';


    public void dispMoves(int row, int col, char[][] board) {
        // L pattern all directions
        for (int i = 0; i < 8; i++) {
            tempBoard[i] = board[i].clone();
        }

        // Cardinal directions haha hardcoded
        // WEST
        // NNW L
        if ((col - 2) >= 0 & (8 - row - 2) >= 0) {
            if (tempBoard[8 - row - 2][col - 2] == blank) {
                tempBoard[8 - row - 2][col - 2] = '·';
            }
        }
        // WNW L
        if ((col - 3) >= 0 & (8 - row - 1) >= 0) {
            if (tempBoard[8 - row - 1][col - 3] == blank) {
                tempBoard[8 - row - 1][col - 3] = '·';
            }
        }
        // SWS L
        if ((col - 2) >= 0 & (8 - row + 2) < 7) {
            if (tempBoard[8 - row + 2][col - 2] == blank) {
                tempBoard[8 - row + 2][col - 2] = '·';
            }
        }
        // WSW L
        if ((col - 3) >= 0 & (8 - row + 1) < 7) {
            if (tempBoard[8 - row + 1][col - 3] == blank) {
                tempBoard[8 - row + 1][col - 3] = '·';
            }
        }

        // EAST
        // NNE L
        if ((col) <= 7 & (8 - row - 2) >= 0) {
        if (tempBoard[8 - row - 2][col] == blank) {
                tempBoard[8 - row - 2][col] = '·';
            }
        }
        // ENE
        if ((col + 1) <= 7 & (8 - row - 1) >= 0) {
            if (tempBoard[8 - row - 1][col + 1] == blank) {
                tempBoard[8 - row - 1][col + 1] = '·';
            }
        }
        // ESE
        if ((col + 1) <= 7 & (8 - row + 1) <= 7) {
            if (tempBoard[8 - row + 1][col + 1] == blank) {
                tempBoard[8 - row + 1][col + 1] = '·';
            }
        }
        // SSE
        if ((col) <= 7 & (8 - row + 2) <= 7) {
            if (tempBoard[8 - row + 2][col] == blank) {
                tempBoard[8 - row + 2][col] = '·';
            }
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
        // Cardinal directions haha hardcoded
        // WEST
        // NNW L
        if ((col - 2) >= 0 && (8 - row - 2) >= 0) {
            if (tempBoard[8 - row - 2][col - 2] != blank && tempBoard[8 - row - 2][col - 2] != '·' && new TeamMate().checkTeam(board[8 - row - 2][col - 2]) == 0) {
                System.out.println("NNW");
                tempBoard[8 - row - 2][col - 2] = 'X';
            }
        }
        // WNW L
        if ((col - 3) >= 0 && (8 - row - 1) >= 0) {
            if (tempBoard[8 - row - 1][col - 3] != blank && tempBoard[8 - row - 1][col - 3] != '·' && new TeamMate().checkTeam(board[8 - row - 1][col - 3]) == 0) {
                System.out.println("WNW");
                tempBoard[8 - row - 1][col - 3] = 'X';
            }
        }
        // SWS L
        if ((col - 2) >= 0 && (8 - row + 2) < 7) {
            if (tempBoard[8 - row + 2][col - 2] != blank && tempBoard[8 - row + 2][col - 2] != '·' && new TeamMate().checkTeam(board[8 - row + 2][col - 2]) == 0) {
                System.out.println("SSW");
                tempBoard[8 - row + 2][col - 2] = 'X';
            }
        }
        // WSW L
        if ((col - 3) >= 0 && (8 - row + 1) < 7) {
            if (tempBoard[8 - row + 1][col - 3] != blank && tempBoard[8 - row + 1][col - 3] != '·' && new TeamMate().checkTeam(board[8 - row + 1][col - 3]) == 0) {
                System.out.println("WSW");
                tempBoard[8 - row + 1][col - 3] = 'X';
            }
        }

        // EAST
        // NNE L
        if ((col) <= 7 && (8 - row - 2) >= 0) {
            if (tempBoard[8 - row - 2][col] != blank && tempBoard[8 - row - 2][col] != '·' && new TeamMate().checkTeam(tempBoard[8 - row - 2][col]) == 0) {
                System.out.println("NNE");
                    tempBoard[8 - row - 2][col] = 'X';
                }
        }
        // ENE
        if ((col + 1) <= 7 && (8 - row - 1) >= 0) {
            if (tempBoard[8 - row - 1][col + 1] != blank && tempBoard[8 - row - 1][col + 1] != '·' && new TeamMate().checkTeam(board[8 - row - 1][col + 1]) == 0) {
                System.out.println("ENE");
                tempBoard[8 - row - 1][col + 1] = 'X';
            }
        }
        // ESE
        if ((col + 1) <= 7 && (8 - row + 1) <= 7) {
            if (tempBoard[8 - row + 1][col + 1] != blank && tempBoard[8 - row + 1][col + 1] != '·' && new TeamMate().checkTeam(board[8 - row + 1][col + 1]) == 0) {
                System.out.println("ESE");
                tempBoard[8 - row + 1][col + 1] = 'X';
            }
        }
        // SSE
        if ((col) <= 7 && (8 - row + 2) <= 7) {
            if (tempBoard[8 - row + 2][col] != blank && tempBoard[8 - row + 2][col] != '·' && new TeamMate().checkTeam(board[8 - row + 2][col]) == 0) {
                System.out.println("SSE");
                tempBoard[8 - row + 2][col] = 'X';
            }
        }
        
        new showBoard().boardDisp(tempBoard);
    }
}

public class WKnight {
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
            if (board[8 - row][col - 1] == '♘') {
                new checkWKnightMove().dispMoves(row, col, board);
                new checkWKnightMove().checkAttack(row, col, board);

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

                if (new checkWKnightMove().checkMove(rowF, colF, board) == false) {
                    System.out.printf("Invalid move! %s to %s", initPos, finalPos);
                    continue;
                } else {
                    // replace init pos with _
                    board[8 - row][col - 1] = blank;
                    // move pawn to final pos
                    board[8 - rowF][colF - 1] = '♘';
                }

                // show board
                b.boardDisp(board);

                turn = Turn.Black; // debug, switch back to black after
                new selPiece().select(turn, board);
            } else {
                System.out.println("Selected piece is not a white knight!");
                continue; 
            }

            sc.close();
        }
    }
}
