import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";
    private int[] arr;
    private int quantityOfNumbers;
    private boolean isMinHeap = true;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            String[] paramStr;
            quantityOfNumbers = Integer.parseInt(bufferedReader.readLine());
            arr = new int[quantityOfNumbers+1];
            paramStr = bufferedReader.readLine().split(" ");
            for (int i = 0; i < paramStr.length; i++) {
                arr[i+1] = Integer.parseInt(paramStr[i]);

            }
            checkChildren(arr[1], 1);
            printWriter.println(( isMinHeap ) ? "Yes" : "No");
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkChildren( int valOfParent, int i ) {
        if (isMinHeap) {
            if (quantityOfNumbers >= 2 * i) {
                if (valOfParent <= arr[2 * i]) {
                    checkChildren(arr[2 * i], 2 * i);
                } else {
                    isMinHeap = false;
                }
            }
            if (quantityOfNumbers >= 2 * i + 1) {
                if (valOfParent <= arr[2 * i + 1]) {
                    checkChildren(arr[2 * i + 1], 2 * i + 1);
                } else {
                    isMinHeap = false;
                }
            }
        }
    }
}