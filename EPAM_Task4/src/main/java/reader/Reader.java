package reader;

import exceptions.FileException;
import java.io.*;

public class Reader {
    public String readFromFile( String file ) throws FileException {
        StringBuilder string = new StringBuilder(" ");
        String line;
        try (FileReader fileReader = new FileReader(new File(file))) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                if (!line.isEmpty()) {
                    string.append(line).append("\n");
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
        return string.toString();
    }
}

