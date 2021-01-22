import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";
    private int n;
    private int m;
    private int[][] adjacencyMatrix;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            String[] paramStr;
            paramStr = bufferedReader.readLine().split(" ");
            n = Integer.parseInt(paramStr[0]);
            m = Integer.parseInt(paramStr[1]);
            Map<Integer, ArrayList<Integer>> graphMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                graphMap.put(i, new ArrayList<Integer>());
            }

            for (int i = 0; i < m; i++) {
                paramStr = bufferedReader.readLine().split(" ");
                graphMap.get(Integer.parseInt(paramStr[0])).add(Integer.parseInt(paramStr[1]));
                graphMap.get(Integer.parseInt(paramStr[1])).add(Integer.parseInt(paramStr[0]));
            }

            List<Integer> tempList;
            for (int i = 1; i < n + 1; i++) {
                tempList = graphMap.get(i);
                printWriter.print(tempList.size() + " ");
                for (Integer val : tempList) {
                    printWriter.print(val + " ");
                }
                printWriter.print("\n");
            }

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}