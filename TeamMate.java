package ChessGame;
import ChessGame.MainGame.Turn;

public class TeamMate {
    char white[] = {'♙', '♘', '♗', '♖', '♔', '♕', '·'};
    char black[] = {'♟', '♞', '♝', '♜', '♚', '♛', '·'};
    MainGame.Turn turn = selPiece.tempTurn;

    // 0 = enemy, 1 = friend
    public int checkTeam(char piece) {
        if (turn == Turn.White) {
            for (char c : white) {
                if (piece == c) {
                    return 1;
                }
            }
            return 0;
        } 

        if (turn == Turn.Black) {
            for (char d : black) {
                if (piece == d) {
                    return 1;
                } 
            }
            return 0;
        }
        return 0; 
    }

    
}
