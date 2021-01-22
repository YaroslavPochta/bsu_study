import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.txt";
    private final String OUTPUT_FILENAME = "output.txt";

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            int numberOfMatrix = Integer.parseInt(bufferedReader.readLine());
            int[][] matrixSizesArray = new int[numberOfMatrix][2];
            String str;
            String[] parsedString;
            for (int i = 0; i < numberOfMatrix; i++){
                str = bufferedReader.readLine();
                parsedString = str.split(" ");
                matrixSizesArray[i][0] = Integer.parseInt(parsedString[0]);
                matrixSizesArray[i][1] = Integer.parseInt(parsedString[1]);
            }
            int[] matrixSizes = new int[numberOfMatrix + 1];
            matrixSizes[0] = matrixSizesArray[0][0];
            for (int i = 0; i < numberOfMatrix; i++) {
                matrixSizes[i+1] = matrixSizesArray[i][1];
            }

            int[][] dataOperationsMatrix = new int[numberOfMatrix+2][numberOfMatrix+2];

            for (int rowIndex = 2; rowIndex <= numberOfMatrix; rowIndex++) {
                for (int columnIndex = 1; columnIndex <= numberOfMatrix - rowIndex + 1; columnIndex++) {
                    int parameter = columnIndex + rowIndex - 1;
                    dataOperationsMatrix[columnIndex][parameter] = 999999999;
                    for (int ijConcl = columnIndex; ijConcl <= parameter - 1; ijConcl++) {
                        dataOperationsMatrix[columnIndex][parameter] =
                                Math.min(dataOperationsMatrix[columnIndex][parameter],
                                dataOperationsMatrix[columnIndex][ijConcl] +
                                        dataOperationsMatrix[ijConcl + 1][parameter] +
                                        matrixSizes[columnIndex - 1] * matrixSizes[ijConcl] * matrixSizes[parameter]
                        );
                    }
                }
            }


            for (int i = 0; i < numberOfMatrix; i++) {
                for (int j = 0; j < numberOfMatrix; j++) {
                    System.out.print(dataOperationsMatrix[i][j] + " ");

                }
                System.out.println("\n");
            }

            for (int i = 0; i < numberOfMatrix; i++){
                System.out.println(matrixSizesArray[i][0] + " " +  matrixSizesArray[i][1] + "\n");
            }
            for (int i = 0; i < numberOfMatrix+1; i++){
                System.out.println(matrixSizes[i] + " ");
            }
            System.out.println(dataOperationsMatrix[1][numberOfMatrix]);
            int result = dataOperationsMatrix[1][numberOfMatrix];
            printWriter.print(result);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
