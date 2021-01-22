package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//TODO: StackOverflowException, invalid type for big amounts

public class Main implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run(){
      try{  BufferedReader bufferedReader = new BufferedReader( new FileReader("input.txt"));
        List<Integer> pointList = new ArrayList<>();
        String str;
        while((str = bufferedReader.readLine()) != null) {
           pointList.add(Integer.parseInt(str));
        }
        BinaryTree binaryTree = new BinaryTree();
        for(int point : pointList){
            binaryTree.add(point);
        }
        binaryTree.sum();
        PrintWriter printWriter = new PrintWriter("output.txt");
        printWriter.print(binaryTree.amount);
        printWriter.flush();
        printWriter.close();
      } catch (IOException e){
          System.out.println(e.getMessage());
      }
    }

    private static class Node {
        int elem;
        Node leftElem;
        Node rightElem;

        Node(int val ) {
            this.elem = val;
            this.leftElem = this.rightElem = null;
        }
    }

    public static class BinaryTree {
        private Node root;
        public long amount = 0;


        public void add(int key ) {
            root = insert(root, key);
        }

        private Node insert( Node curElem, int key ) {
            if (curElem == null) return new Node(key);
            if ((key - curElem.elem) < 0) curElem.leftElem = insert(curElem.leftElem, key);
            if ((key - curElem.elem) > 0) curElem.rightElem = insert(curElem.rightElem, key);
            return curElem;
        }

        public void sum() {
            bypassRootLeftRightHelper(root);
        }

        private void bypassRootLeftRightHelper( Node localRoot ) {
            if (localRoot != null) {
                amount += localRoot.elem;
                bypassRootLeftRightHelper(localRoot.leftElem);
                bypassRootLeftRightHelper(localRoot.rightElem);

            }
        }
    }
}