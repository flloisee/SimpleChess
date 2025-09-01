package ChessGame.Pawn;

import java.util.*;

import ChessGame.selPiece;
import ChessGame.MainGame.Turn;
import ChessGame.MainGame;

public class PawnPromotion {
    MainGame.Turn turn = selPiece.tempTurn;
    static Scanner sc = new Scanner(System.in);
    public void checkPromote(char board[][], int row, int col) {

        System.out.println(turn);
        // make the user choose a piece
        int pieceChoice = 0;
        if (turn == Turn.White) {
            System.out.printf("\nChoose a piece:\n(1) Queen\n(2) Rook\n(3) Bishop\n(4) Knight\n> ");
            pieceChoice = sc.nextInt();
            sc.nextLine();
            switch (pieceChoice) {
                case 1:
                    board[8 - row][col - 1] = '♕';
                    break;
                case 2:
                    board[8 - row][col - 1] = '♖';
                    break;
                case 3:
                    board[8 - row][col - 1] = '♗';
                    break;
                case 4:
                    board[8 - row][col - 1] = '♘';
                    break;
                default:
                    System.out.println("Not an option!");
                    break;
            }
        } else if (turn == Turn.Black) {
            System.out.printf("\nChoose a piece:\n(1) Queen\n(2) Rook\n(3) Bishop\n(4) Knight\n> ");
            pieceChoice = sc.nextInt();
            sc.nextLine();
            switch(pieceChoice) {
                case 1:
                    board[8 - row][col - 1] = '♛';
                    break;
                case 2:
                    board[8 - row][col - 1] = '♜';
                    break;
                case 3:
                    board[8 - row][col - 1] = '♝';
                    break;
                case 4:
                    board[8 - row][col - 1] = '♞';
                    break;
                default:
                    System.out.println("Not an option!");
                    break;
            }
        }
    }
}
