package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";
    private int hashTableSize;
    private int quantityOfNumbers;
    private int key;
    private int[] arr;
    private int[] hashTable;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            String[] paramStr;
            paramStr = bufferedReader.readLine().split(" ");
            hashTableSize = Integer.parseInt(paramStr[0]);
            key = Integer.parseInt(paramStr[1]);
            quantityOfNumbers = Integer.parseInt(paramStr[2]);
            arr = new int[quantityOfNumbers];
            hashTable = new int[hashTableSize];
            for (int i = 0; i < quantityOfNumbers; i++) {
                arr[i] = Integer.parseInt(bufferedReader.readLine());
            }
            for (int i = 0; i < hashTableSize; i++){
                hashTable[i] = -1;
            }
            int index;
            for (int i = 0; i < quantityOfNumbers; i++) {
                for (int j = 0; j < hashTableSize; j++) {
                    index = hash(arr[i], j);
                    if (hashTable[index] == arr[i]) {
                        j = hashTableSize + 1;
                    } else {
                        if (hashTable[index] == -1) {
                            hashTable[index] = arr[i];
                            j = hashTableSize + 1;
                        }
                    }
                }
            }

            for (int val : hashTable) {
                printWriter.print(val + " ");
            }

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private int hash (int val, int i){
        return ((val % hashTableSize) + key*i)%hashTableSize;
    }
}