import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class SquareMatrix {
    private double[][] matr;
    private int size; //TODO

    public SquareMatrix(int n, double defVal){
        size = n;
        matr = new double[size][size];
        for(double[] arr : matr) for (double x : arr) x = defVal;
    }

    public SquareMatrix (int n, double[][] matr){
        this.size = n;
        this.matr = matr;
    }

    public void readFromFile(String fileName) throws IOException
    {
        Scanner in = new Scanner(new File(fileName));
        this.size = in.nextInt();
        if(this.size <= 0) throw new IOException("Invalid matrix size");
        this.matr = new double[this.size][this.size];
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++){
                if (!in.hasNextDouble()) throw new IOException("Invalid data, matrix isn't completely filled or invalid element. Check element [" + (i+1) + "][" + (j+1) + ']');
                this.matr[i][j] = in.nextDouble();
            }
    }
 //   if (Double.isNaN(this.matr[this.size][this.size])) throw new IOException("Invalid data, matrix isn't completely filled"); // == !in.hasNextDouble()
    }

    public void print()
    {
        for (double [] arr : this.matr){
            for (double elem : arr){
                System.out.print(elem + "\t\t");
            }
            System.out.println();
        }
    }

    public int getSize(){ return this.size; }

    private SquareMatrix multuplyOnMatr(SquareMatrix matr1){
  /*
  if (this.getSize() != matr1.getSize()){
  System.out.println("Square matrix's sizes sre different, matrix cannot be multiplied"); //Exception ????
  return null;
  }
  */
        SquareMatrix result = new SquareMatrix(this.getSize(),0);
        double accumulator;
        for (int i = 0; i < result.getSize(); i++)
            for (int j = 0; j < result.getSize(); j++) {
                accumulator = 0;
                for (int k = 0; k < result.getSize(); k++) {
                    accumulator += this.matr[i][k] * matr1.matr[k][j];
                }
                result.matr[i][j] = accumulator;
            }
        return result;
    }

    public SquareMatrix pow(int p) {
        SquareMatrix newMatr = new SquareMatrix(this.size, this.matr.clone());
        for (int i = 1; i < p; i ++){
            newMatr = newMatr.multuplyOnMatr(this);
        }
        return newMatr;
    }
}
