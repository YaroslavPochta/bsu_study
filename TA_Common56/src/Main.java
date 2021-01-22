import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            long n = Long.parseLong(bufferedReader.readLine());
            List<Integer> powers = new ArrayList<>();

            for (int i = 0; n != 0 ; i++){
                if((n & 1) == 1) {
                    powers.add(i);
                }
                n = n >> 1;
            }

            for (Integer val : powers) {
                printWriter.println(val);
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}