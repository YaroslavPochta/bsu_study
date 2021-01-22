package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "C:\\Users\\Yaroslav\\Desktop\\TA3.37\\input.txt";

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            int quantityOfNumbers = 15;
            int[] arr = new int[quantityOfNumbers];
            Random rand = new Random();
            for (int j = 0; j < quantityOfNumbers; j++) {
                arr[j] = rand.nextInt(100);
            }
            printWriter.println(quantityOfNumbers);
            for (int i = quantityOfNumbers - 1; i > -1; i--){
                for (int j = quantityOfNumbers - 1; j > -1; j--){
                    printWriter.print(arr[quantityOfNumbers- i -1] + arr[quantityOfNumbers-j-1] + " ");
                }
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
