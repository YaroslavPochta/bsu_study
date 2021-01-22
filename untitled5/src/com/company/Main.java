package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "walk.in";
    private final String OUTPUT_FILENAME = "walk.out";
    private int n;
    private int m;
    private int[][] graph;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            String[] paramStr = bufferedReader.readLine().split(" ");
            n = Integer.parseInt(paramStr[0]);
            m = Integer.parseInt(paramStr[1]);
            graph = new int[n][m];
            String str;
            for (int i = 0; i < n; i++) {
                str = bufferedReader.readLine();
                for (int j = 0; j < m; j++) {
                    if (str.charAt(j) == '.') {
                        graph[i][j] = 1;
                    } else{
                        if (str.charAt(j) == '*') {
                            graph[i][j] = 0;
                        } else {
                            if (str.charAt(j) == 'M') {
                                graph[i][j] = 2;
                            } else {
                                graph[i][j] = 3;
                            }
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

}