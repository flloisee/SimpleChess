package ChessGame.King;

import ChessGame.selPiece;
import ChessGame.MainGame;
public class Castling {
    MainGame.Turn turn = new selPiece().tempTurn;
    public void castle(char board[][], int row, int col) {
        if (turn == MainGame.Turn.White) {
            board[8 - row][col] = '♖';
            board[8 - row][col + 1] = '♔';
            board[8 - row][col + 2] = MainGame.blank;
        } else {
            board[8 - row][col] = '♜';
            board[8 - row][col + 1] = '♚';
            board[8 - row][col + 2] = MainGame.blank;
        }
    }
}
