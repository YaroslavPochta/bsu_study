import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "in.txt";
    private final String OUTPUT_FILENAME = "out.txt";

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            List<Integer> lengthOfGreenFragmentsList = new ArrayList<>();
            String str;
            int numberOfCells = Integer.parseInt(bufferedReader.readLine());
            int numberOfGreenZones = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.readLine();
           try{
               while (( str = bufferedReader.readLine() ) != null) {
                if (!(str.equals("\n") || str.equals(" ") || str.equals("\n ") || str.equals("\n\t") )) {
                    lengthOfGreenFragmentsList.add(Integer.parseInt(str));
                }
            }}
           catch (NumberFormatException e) {
               System.out.println(e.getMessage() + ", cause:" + e.getCause());
           }
            int numberOfGreenCells = 0;
            for (Integer number : lengthOfGreenFragmentsList) {
                numberOfGreenCells += number;
            }
            int numberOfPositions = numberOfCells - numberOfGreenCells + 1;
            if (numberOfPositions == 0 || numberOfPositions < numberOfGreenZones) {
                printWriter.print(0);
            } else {
                BigInteger[][] binomialArr = new BigInteger[numberOfPositions + 1][numberOfPositions + 1];
                for (int i = 0; i <= numberOfPositions; ++i) {
                    for (int j = 0; j <= i; ++j) {
                        if (( i == j ) || ( j == 0 )) {
                            binomialArr[i][j] = BigInteger.ONE;
                        } else {
                            binomialArr[i][j] = binomialArr[i - 1][j].add(binomialArr[i - 1][j - 1]);
                        }
                    }
                }
                printWriter.print(binomialArr[numberOfPositions][numberOfGreenZones]);
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}