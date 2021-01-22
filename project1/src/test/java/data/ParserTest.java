package data;

import com.epam.data.Parser;
import com.epam.model.Ball;
import com.epam.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    private static final String INPUT_STRING = "21 34 5 4";
    private static final Ball EXPECTED_BALL = new Ball(new Point(21, 34, 5), 4);

    @Test
    public void testParserShouldReturnCorrect() {
        Parser parser = new Parser();
        Ball resultBall = parser.parse(INPUT_STRING);
        Assert.assertEquals(resultBall, EXPECTED_BALL);
    }
}
