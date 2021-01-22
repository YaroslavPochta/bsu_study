import java.io.*;
import java.util.Arrays;
import java.util.Collections;


public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";
    private int n;
    private int m;
    private int[][] graph;
    private int[] block;
    private int[] keyArr;
    private int mark = 0;

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
            graph = new int[n][n];
            block = new int[n];
            keyArr = new int[n];
            for (int i = 0; i < n; i++) {
                keyArr[i] = 0;
            }
            for (int i = 0; i < m; i++) {
                paramStr = bufferedReader.readLine().split(" ");
                graph[Integer.parseInt(paramStr[0]) - 1][Integer.parseInt(paramStr[1]) - 1] = Integer.parseInt(paramStr[2]);
            }
            int[] tempArr = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (block[i] == 0) {

                    }
                }
            }
            for (int val : keyArr) {
                printWriter.print(val + " ");
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dejkstra(int i){
        for (int j = 0; j < n; j++){
            if(block[j] == )
        }
    }

    public void dfs(int i){
        block[i] = 1;
        mark++;
        keyArr[i] = mark;
        for (int j = 0; j < n; j++){
            if(graph[i][j] == 1 && block[j] == 0){
                dfs(j);
            }
        }
    }
}
