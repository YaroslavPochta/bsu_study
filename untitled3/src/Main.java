import java.io.*;
import java.util.Scanner;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "in.txt";
    private final String OUTPUT_FILENAME = "out.txt";
    private int length;
    private int width;
    private int horses = 0;
    private int[][] chessBoard;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(new File(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            length = scanner.nextInt();
            width = scanner.nextInt();
            chessBoard = new int[length][width];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    chessBoard[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (Math.abs(chessBoard[i][j]) != 1) {
                        horseMove(i, j);
                        chessBoard[i][j] = -1;
                        horses++;
                    }
                }
            }
            printWriter.print(horses);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void horseMove( int x, int y ) {
        if (Math.abs(chessBoard[x][y]) != 1) {
            chessBoard[x][y] = 1;
            for (int shiftX = -2; shiftX <= 2; shiftX++) {
                if (x + shiftX >= 0 && x + shiftX < length && shiftX != 0) {
                    for (int shiftY = -2; shiftY <= 2; shiftY++) {
                        if (y + shiftY >= 0 && y + shiftY < width && shiftY != 0) {
                            if (Math.abs(shiftX) != Math.abs(shiftY))
                                horseMove(x + shiftX, y + shiftY);
                        }
                    }
                }
            }
        }
    }
}