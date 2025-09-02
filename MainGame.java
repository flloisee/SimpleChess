package ChessGame;
import java.util.*;

public class MainGame {
    static Scanner sc = new Scanner(System.in);
    public static char blank = '-';
    static char board[][] = {{blank, blank, blank, blank, blank, blank, blank, blank},{blank, blank, blank, blank, blank, blank, blank, blank}, {blank, blank, blank, blank, blank, blank, blank, blank}, {blank, blank, blank, blank, blank, blank, blank, blank}, {blank, blank, blank, blank, blank, blank, blank, blank}, {blank, blank, blank, blank, blank, blank, blank, blank}, {blank, blank, blank, blank, blank, blank, blank, blank}, {blank, blank, blank, blank, blank, blank, blank, blank}};

    static showBoard b = new showBoard();
    
    public enum Turn {
        Black,
        White
    }
    public Turn turn = Turn.White; // set default to white's turn 

    static void pieceSetup() {
        // init white pawns to their places
        for (int i = 0; i < board.length; i++) {
            board[6][i] = '♙';
        }
        // black pawns
        for (int i = 0; i < board.length; i++) {
            board[1][i] = '♟';
        }
        // white knights
        board[7][1] = '♘';
        board[7][6] = '♘';
        // black knights
        board[0][1] = '♞';
        board[0][6] = '♞';
        // white rooks
        board[7][0] = '♖';
        board[7][7] = '♖';
        // black rooks
        board[0][0] = '♜';
        board[0][7] = '♜';
        // white bishop
        board[7][2] = '♗';
        board[7][5] = '♗';
        // blac bishop
        board[0][2] = '♝';
        board[0][5] = '♝';
        // black and white king
        board[7][4] = '♔';
        board[0][4] = '♚';
        // black and white queen
        board[7][3] = '♕';
        board[0][3] = '♛';

        // endgame debug
        /* board[0][1] = '♚';
        board[7][2] = '♖';
        board[6][3] = '♖';
        board[7][7] = '♔'; */
    }

    public static void main (String[] args) {

        // init game
        pieceSetup();
        b.boardDisp(board);
        new fileRecord().clearFile();
        new selPiece().select(new MainGame().turn, board);


        sc.close();
    }
}
