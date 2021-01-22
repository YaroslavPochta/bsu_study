import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            BinaryTree binaryTree = new BinaryTree("output.txt");
            for(int point : pointList){
                binaryTree.add(point);
            }
            binaryTree.bypass();

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

    public static class BinaryTree{
        private Node root;
        private PrintWriter printWriter;

        public BinaryTree( String filename ) throws FileNotFoundException {
            this.printWriter = new PrintWriter(filename);
        }

        public void add( int key ) {
            root = insert(root, key);
        }

        private Node insert( Node curElem, int key ) {
            if (curElem == null) return new Node(key);
            if ((key - curElem.elem) < 0) curElem.leftElem = insert(curElem.leftElem, key);
            if ((key - curElem.elem) > 0) curElem.rightElem = insert(curElem.rightElem, key);
            return curElem;
        }

        public void bypass() {
            bypassRootLeftRightHelper(root);
            this.printWriter.flush();
            this.printWriter.close();
        }

        private void bypassRootLeftRightHelper( Node localRoot ) {
            if (localRoot != null) {
                this.printWriter.println(localRoot.elem);
                bypassRootLeftRightHelper(localRoot.leftElem);
                bypassRootLeftRightHelper(localRoot.rightElem);

            }
        }
    }
}