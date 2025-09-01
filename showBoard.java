package ChessGame;

public class showBoard {
    public void boardDisp(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board.length - i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
