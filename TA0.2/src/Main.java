import java.io.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            List<Integer> pointList = new ArrayList<>();
            String str;
            int pointToDelete = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.readLine();
            while (( str = bufferedReader.readLine() ) != null) {
                pointList.add(Integer.parseInt(str));
            }

            BinaryTree binaryTree = new BinaryTree(OUTPUT_FILENAME);
            for (int point : pointList) {
                binaryTree.add(point);
            }

            binaryTree.deletePoint(pointToDelete);
            binaryTree.bypass();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static class Node {
        int elem;
        Node leftElem;
        Node rightElem;

        Node( int val ) {
            this.elem = val;
            this.leftElem = this.rightElem = null;
        }
    }

    public static class BinaryTree {
        private Node root;
        private PrintWriter printWriter;

        public BinaryTree( String filename ) throws FileNotFoundException {
            this.printWriter = new PrintWriter(filename);
        }

        public void add( int key ) {
            root = insert(root, key);
        }

        //Right deleting
        public void deletePoint( int pointToDelete ) {
           this.root = deletingHelper(this.root, pointToDelete);
        }

        private Node deletingHelper( Node curElem, int key ) {
            if (curElem == null) return null;
            if (curElem.elem != key) {
                if (key < curElem.elem) {
                    curElem.leftElem = deletingHelper(curElem.leftElem, key);
                } else {
                    curElem.rightElem = deletingHelper(curElem.rightElem, key);
                }
            } else {
                if (curElem.rightElem != null && curElem.leftElem == null) {
                    curElem = curElem.rightElem;
                } else {
                    if (curElem.leftElem != null && curElem.rightElem == null) {
                        curElem = curElem.leftElem;
                    } else {
                        if (curElem.leftElem != null && curElem.rightElem != null) {
                            curElem.elem = findMinimalPoint(curElem.rightElem).elem;
                            System.out.println( findMinimalPoint(curElem.rightElem).elem);
                            curElem.rightElem = deletingHelper(curElem.rightElem, curElem.elem);
                        } else {
               //             if(curElem.leftElem == null && curElem.rightElem == null)
                                curElem= null;
                        }
                    }
                }
            }
            return curElem;
        }

        private Node findMinimalPoint( Node curElem ) {
            if (curElem.leftElem != null) return findMinimalPoint(curElem.leftElem);
            else return curElem;
        }

        public Node find( int value ) {
            return findHelper(this.root, value);
        }

        private Node findHelper( Node curElem, int key ) {
            if (curElem == null) return null;
            if (key < curElem.elem) findHelper(curElem.leftElem, key);
            if (key > curElem.elem) findHelper(curElem.rightElem, key);
            return curElem;
        }

        private Node insert( Node curElem, int key ) {
            if (curElem == null) return new Node(key);
            if (key < curElem.elem) curElem.leftElem = insert(curElem.leftElem, key);
            if (key > curElem.elem) curElem.rightElem = insert(curElem.rightElem, key);
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