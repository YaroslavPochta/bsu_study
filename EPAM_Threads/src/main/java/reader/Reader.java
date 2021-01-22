package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final Logger LOGGER = LogManager.getLogger(Reader.class);
    private static final String INCORRECT_DATA = "File has incorrect data, please refactor your file";
    private static final String FILE_NOT_FOUND = "File wasn't found. Please, check name of the file.";
    private final ArrayList<String> arrayList = new ArrayList<>();

    public List<String> readFromFile( String filename ) {
        String str;
        try (FileReader fileReader = new FileReader(new File(filename))) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                if (!str.isEmpty()) {
                    arrayList.add(str);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            LOGGER.error(FILE_NOT_FOUND);
        } catch (IOException ex) {
            LOGGER.error(INCORRECT_DATA);
        }
        return arrayList;
    }
}
