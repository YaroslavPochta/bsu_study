import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";
    private int n;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            String[] paramStr;
            n = Integer.parseInt(bufferedReader.readLine());
            int[] canonicalForm = new int[n];

            for (int i = 0; i < n; i++) {
                paramStr = bufferedReader.readLine().split(" ");
                for (int j = 0; j < n; j++){
                    if(Integer.parseInt(paramStr[j]) == 1)
                        canonicalForm[j] = i+1;
                }
            }

            for (Integer val : canonicalForm) {
                printWriter.print(val + " ");
            }


            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}