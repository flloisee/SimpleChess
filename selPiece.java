package ChessGame;

import java.util.*;
import ChessGame.MainGame.Turn;
import ChessGame.Rook.*;
import ChessGame.Pawn.*;
import ChessGame.Bishop.*;
import ChessGame.Knight.*;
import ChessGame.King.*;
import ChessGame.Queen.*;

public class selPiece {
    public Turn tempTurn;
    static Scanner sc = new Scanner(System.in);
    public void select(MainGame.Turn turn, char[][] board) {
            new fileRecord().record(board);;
            /* turn = Turn.Black; // debug */
            tempTurn = turn;
            System.out.printf("\nCurrent player: %s\n", turn);
            System.out.printf("\nSelect piece: \n(1) King\n(2) Queen\n(3) Rook\n(4) Bishop\n(5) Knight\n(6) Pawn\n(0) Forfeit\n> ");
            int sel = 0;
            try {
                sel = sc.nextInt();
                sc.nextLine();

                boolean cont = new selPiece().confirm(sel), searchPiece = new selPiece().checkForPiece(sel, board);
                
                if (cont == false) {
                    select(turn, board);
                }
                if (searchPiece == false) {
                    System.out.printf("\nPiece not found!\n");
                    select(turn, board);
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
                select(turn, board);
            }
            switch (sel) {
                case 1:
                    if (turn == Turn.White) {
                        new WKing().move(turn, board);
                    } else {
                        new BKing().move(turn, board);
                    }
                    break;
                case 2:
                    if (turn == Turn.White) {
                        new WQueen().move(turn, board);
                    } else {
                        new BQueen().move(turn, board);
                    }
                    break;
                case 3:
                    if (turn == Turn.White) {
                        new WRook().move(turn, board);
                    } else {
                        new BRook().move(turn, board);
                    }
                    break;
                case 4:
                    if (turn == Turn.White) {
                        new WBishop().move(turn, board);
                    } else {
                        new BBishop().move(turn, board);
                    }
                    break;
                case 5:
                    if (turn == Turn.White) {
                        new WKnight().move(turn, board);
                    } else {
                        new BKnight().move(turn, board);;
                    }
                    break;
                case 6:
                    if (turn == Turn.White) {
                        new WPawn().move(turn, board);
                    } else {
                        new BPawn().move(turn, board);
                    }
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not an option!");
                    select(turn, board);
            }
        sc.close();
    }

    public boolean confirm(int sel) {
        String YN;
        switch (sel) {
                case 1:
                    System.out.printf("\nSelected piece: King\nConfirm? Y or N: ");
                    YN = sc.nextLine().trim();
                    if (YN.charAt(0) == 'y')  {
                        return true;
                    }
                    break;
                case 2:
                    System.out.printf("\nSelected piece: Queen\nConfirm? Y or N: ");
                    YN = sc.nextLine().trim();
                    if (YN.charAt(0) == 'y')  {
                        return true;
                    }
                    break;
                case 3:
                    System.out.printf("\nSelected piece: Rook\nConfirm? Y or N: ");
                    YN = sc.nextLine().trim();
                    if (YN.charAt(0) == 'y')  {
                        return true;
                    }
                    break;
                case 4:
                    System.out.printf("\nSelected piece: Bishop\nConfirm? Y or N: ");
                    YN = sc.nextLine().trim();
                    if (YN.charAt(0) == 'y')  {
                        return true;
                    }
                    break;
                case 5:
                    System.out.printf("\nSelected piece: Knight\nConfirm? Y or N: ");
                    YN = sc.nextLine().trim();
                    if (YN.charAt(0) == 'y')  {
                        return true;
                    }
                    break;
                case 6:
                    System.out.printf("\nSelected piece: Pawn\nConfirm? Y or N: ");
                    YN = sc.nextLine().trim();
                    if (YN.charAt(0) == 'y')  {
                        return true;
                    }
                    break;
                default:
                    System.out.println("Not an option!");
                    return false;
            }

            return false;
    }

    // add this as another safeguard
    public boolean checkForPiece(int sel, char[][] board) {
        // linear search algo
        switch (sel) {
                case 1:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (board[i][j] == '♔' || board[i][j] == '♚') {
                                return true;
                            }
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (board[i][j] == '♕' || board[i][j] == '♛') {
                                return true;
                            }
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (board[i][j] == '♖' || board[i][j] == '♜') {
                                return true;
                            }
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (board[i][j] == '♗' || board[i][j] == '♝') {
                                return true;
                            }
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (board[i][j] == '♘' || board[i][j] == '♞') {
                                return true;
                            }
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (board[i][j] == '♙' || board[i][j] == '♟') {
                                return true;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Not an option!");
                    return false;
            }
            return false;
    }
}
