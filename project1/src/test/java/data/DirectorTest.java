package data;

import com.epam.data.Director;
import com.epam.exceptions.DataException;
import com.epam.data.Parser;
import com.epam.data.Reader;
import com.epam.data.Validator;
import com.epam.model.Ball;
import com.epam.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DirectorTest {
    private final String PATH = "src/correctInput.txt";

    private final String STR_BALL_1 = "1 2 3 4";
    private final String STR_BALL_2 = "2 3 4 5";
    private final String STR_BALL_3 = "43.5, 65.7 65.8 89";

    private final Ball ball1 = new Ball(new Point(1, 2, 3), 4);
    private final Ball ball2 = new Ball(new Point(2, 3, 4), 5);
    private final Ball ball3 = new Ball(new Point(43.5, 65.7, 65.8), 89);

    private final List<Ball> expectedList = new ArrayList<Ball>(
            Arrays.asList(ball1, ball2, ball3)
    );
    private final List<String> readerResult = new ArrayList<String>(
            Arrays.asList(STR_BALL_1, STR_BALL_2, STR_BALL_3)
    );

    @Test
    public void testDirectorShouldReturnCorrectWithFileCorrectInput() throws DataException, IOException {
        Reader reader = Mockito.mock(Reader.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(reader.readLines(PATH)).thenReturn(readerResult);

        Validator validator = Mockito.mock(Validator.class, Mockito.RETURNS_DEEP_STUBS);
        for (String strBall : readerResult) {
            Mockito.when(validator.isValid(strBall)).thenReturn(true);
        }

        Parser parser = Mockito.mock(Parser.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(parser.parse(STR_BALL_1)).thenReturn(ball1);
        Mockito.when(parser.parse(STR_BALL_2)).thenReturn(ball2);
        Mockito.when(parser.parse(STR_BALL_3)).thenReturn(ball3);

        Director director = new Director(PATH, reader, parser, validator);

        List<Ball> result = director.process();
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(result.get(i), expectedList.get(i));
        }
        //  Assert.assertEquals(result, expectedList);
    }
}