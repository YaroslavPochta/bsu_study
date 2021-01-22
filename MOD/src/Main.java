import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";
    private int n;
    private int[][] graph;
    private int[] visited;
    private List<String> strResult = new ArrayList<>();
    private int counter = 0;
    private PrintWriter printWriter;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            printWriter = new PrintWriter(OUTPUT_FILENAME);
            String[] paramStr;
            n = Integer.parseInt(bufferedReader.readLine());
            graph = new int[n][n];
            visited = new int[n];
            for (int i = 0; i < n; i++) {
                paramStr = bufferedReader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(paramStr[j]);
                }
            }

            if(n ==1 && graph[0][0] == 0){
                printWriter.println(0);
            } else {
                dfs(0);
                boolean connectedOrNot = true;
                for (int i = 0; i < n; i++) {
                    if (visited[i] == 0) {
                        connectedOrNot = false;
                    }
                }
                if (counter == 0) {
                    printWriter.println(-1);
                } else {
                    if (!connectedOrNot) {
                        printWriter.println(-1);
                    } else {
                        printWriter.println(counter);
                        for (String str : strResult) {
                            printWriter.println(str);
                        }
                    }
                }
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dfs( int i ) {
        visited[i] = 1;
        for (int j = 0; j < n; j++) {
            if (graph[i][j] == 1 && visited[j] == 0) {
                counter++;
                strResult.add(( i + 1 ) + " " + ( j + 1 ));
                dfs(j);
            }
        }
    }
}