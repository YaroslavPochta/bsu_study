import java.io.IOException;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        try{
            String fileName = "input";
            SquareMatrix matrix = new SquareMatrix(2,5);
            matrix.print();
            matrix.readFromFile(fileName);
            matrix.pow(647).print(); // 647 - max for E3
        }
       catch (IOException | NoSuchElementException e){  // FileNotFound exception is subclass of IOException, InputMismatch exception - of NoSuchElement
             if (e.getMessage() == null) System.out.println(e);
             else System.out.println(e.getMessage());
         }
    }
}
