package ChessGame;

import java.io.*;

public class fileRecord {
    int count = 0;
    String path = "Game_record.txt";
    public void record(char[][] board) {
        File f = new File(path);

        // create file
        try {
            if (f.createNewFile()) {
                System.out.printf("\nCreated new file: %s\n", f.getName());
            } else {

            }
        } catch (Exception e) {
            
        }

        // write to file (append)
        try {
            FileWriter fw = new FileWriter(f, true);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    fw.write(board[i][j] + " ");
                }
                fw.write("\n");
            }

            fw.close();
        } catch (Exception e) {

        }
    }

    public void clearFile() {
        try {
                FileWriter fw = new FileWriter(path, false);

                fw.write("");

                fw.close();
            } catch (Exception e) {

            }
    }
}
