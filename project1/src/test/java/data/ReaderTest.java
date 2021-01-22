package data;

import com.epam.data.Reader;
import com.epam.exceptions.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderTest {
    private static final String INPUT_FILENAME = "C:\\Users\\Yaroslav\\IdeaProjects\\project1\\src\\test\\resources\\input.txt";
    private static final String INPUT_FILENAME_EMPTY_FILE = "C:\\Users\\Yaroslav\\IdeaProjects\\project1\\src\\test\\resources\\empty.txt";
    //  private static final String INPUT_FILENAME_RELATIVE_PATH = "input.txt";  FileNotFoundException (?)

    private static final List<String> EXPECTED_LIST = Arrays.asList(
            "1 2 3 4", "1 1s 1 5"
    );

    private static final List<String> EMPTY_LIST = new ArrayList<>();

    @Test
    public void testReaderShouldReturnCorrect() throws DataException {
        Reader reader = new Reader();
        List<String> resultList = reader.readLines(INPUT_FILENAME);
        Assert.assertEquals(resultList, EXPECTED_LIST);
    }

    @Test
    public void testReaderShouldReturnEmptyList() throws DataException {
        Reader reader = new Reader();
        List<String> resultList = reader.readLines(INPUT_FILENAME_EMPTY_FILE);
        Assert.assertEquals(resultList, EMPTY_LIST);
    }
}
