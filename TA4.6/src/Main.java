import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "input.in";
    private final String OUTPUT_FILENAME = "output.out";
    private int quantityOfPostcards;
    private double[][] postcards;
    private double[][] converts;
    private boolean[][] fitsOrNot;
    private boolean[] visited;
    private int[] path;
    private int count;

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            quantityOfPostcards = Integer.parseInt(bufferedReader.readLine());
            postcards = new double[quantityOfPostcards][2];
            converts = new double[quantityOfPostcards][2];
            String[] paramStr;
            for (int i = 0; i < quantityOfPostcards; i++) {
                paramStr = bufferedReader.readLine().split(" ");
                postcards[i][0] = Double.parseDouble(paramStr[0]);
                postcards[i][1] = Double.parseDouble(paramStr[1]);
            }
            for (int j = 0; j < quantityOfPostcards; j++) {
                paramStr = bufferedReader.readLine().split(" ");
                converts[j][0] = Double.parseDouble(paramStr[0]);
                converts[j][1] = Double.parseDouble(paramStr[1]);
            }

            fitsOrNot = new boolean[quantityOfPostcards][quantityOfPostcards];
            for (int i = 0; i < quantityOfPostcards; i++) {
                for (int j = 0; j < quantityOfPostcards; j++) {
                    fitsOrNot[i][j] = isItFitTrihonometry(postcards[i][0], postcards[i][1], converts[j][0], converts[j][1]);
                }
            }

            visited = new boolean[quantityOfPostcards];
            path = new int[quantityOfPostcards];
            for (int i = 0; i < quantityOfPostcards; i++) {
                path[i] = -1;
            }
            for (int i = 0; i < quantityOfPostcards; i++) {
                visited = new boolean[quantityOfPostcards];
                count += isCanBeCovered(i) ? 1 : 0;
            }
            printWriter.println(( count == quantityOfPostcards ) ? "YES" : "NO\n" + count);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isCanBeCovered( int postcardIndex ) {
        if (!visited[postcardIndex]) {
            visited[postcardIndex] = true;
            for (int convertIndex = 0; convertIndex < quantityOfPostcards; convertIndex++) {
                if (( fitsOrNot[postcardIndex][convertIndex] ) &&
                        ( path[convertIndex] == -1 || isCanBeCovered(path[convertIndex]) )) {
                    path[convertIndex] = postcardIndex;
                    return true;
                }
            }
        }
        return false;
    }

   /* public void dfs( int i ) {
        visited[i] = true;
        for (int j = 0; j <quantityOfPostcards; j++) {
            if (fitsOrNot[i][j] == true && visited[j] == false) {
                count++;

                dfs(j);
            }
        }
    }*/


    private boolean isItFit( double postcardLength, double postcardWight, double convertLength, double convertWight ) {
        if (postcardLength * postcardWight > convertLength * convertWight) {
            return false;
        }

        double temp;

        if (postcardLength < postcardWight) {
            temp = postcardLength;
            postcardLength = postcardWight;
            postcardWight = temp;
        }

        if (convertLength < convertWight) {
            temp = convertLength;
            convertLength = convertWight;
            convertWight = temp;
        }

        if (postcardLength <= convertLength  && postcardWight <= convertWight) {
            return true;
        }

        if (postcardLength > convertLength && postcardWight <= convertWight) {
            return ( convertLength + convertWight ) * ( convertLength + convertWight ) * ( postcardLength - postcardWight ) * ( postcardLength - postcardWight ) +
                    ( convertLength - convertWight ) * ( convertLength - convertWight ) * ( postcardLength + postcardWight ) * ( postcardLength + postcardWight ) >=
                    2 * ( postcardLength - postcardWight ) * ( postcardLength - postcardWight ) * ( postcardLength + postcardWight ) * ( postcardLength + postcardWight );
        }
        return false;
    }

    private boolean isItFitTrihonometry( double postcardLength, double postcardWight, double convertLength, double convertWight ){
        if (isItFit(postcardLength,postcardWight,convertLength,convertWight)) {
            System.out.println(Math.sin(postcardLength/postcardLength) == Math.cos(convertLength - convertWight));

            return  Math.sin(postcardLength/postcardLength) == Math.cos(convertLength - convertWight);
        }
        return false;
    }
}














