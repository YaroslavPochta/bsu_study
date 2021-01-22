import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";
    private static Queue<Integer> queue = new LinkedList<>();
    private int n;
    private int[][] graph;
    private int[] visited;
    private int[] keyArr;
    private int mark = 1;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            String[] paramStr;
            n = Integer.parseInt(bufferedReader.readLine());
            graph = new int[n][n];
            visited = new int[n];
            keyArr = new int[n];
            for (int i = 0; i < n; i++) {
                keyArr[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                paramStr = bufferedReader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(paramStr[j]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                    while (queue.isEmpty() == false) {
                        int tempNode = queue.poll();
                        keyArr[tempNode] = mark;
                        mark++;
                        for (int j = 0; j < n; j++)
                            if (graph[tempNode][j] == 1 && visited[j] == 0) {
                                visited[j] = 1;
                                queue.add(j);
                            }
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
}