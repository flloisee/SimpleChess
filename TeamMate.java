package ChessGame;

public class TeamMate extends MainGame {
    char white[] = {'♙', '♘', '♗', '♖', '♔', '♕', '·'};
    char black[] = {'♟', '♞', '♝', '♜', '♚', '♛', '·'};
    Turn turn = new selPiece().tempTurn;

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
