package logic;

import com.epam.exceptions.DataException;
import com.epam.logic.Calculator;
import com.epam.model.Ball;
import com.epam.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();
    private final Ball ballWithZeroRadius = new Ball(new Point(1, 1, 1), 0);
    private final Ball ballWithOneRadius = new Ball(new Point(1, 1, 1), 1);
    private static final double VOLUME_OF_A_BALL_WITH_ONE_RADIUS = 4.18;
    private static final double VOLUME_OF_A_BALL_WITH_ZERO_RADIUS = 0;
    private static final double SQUARE_OF_THE_SPHERE_WITH_ONE_RADIUS = 12.56;
    private static final double SQUARE_OF_THE_SPHERE_WITH_ZERO_RADIUS = 0;
    private static final double SEGMENT_VOLUME_PLANE_INTERSECT_THE_BALL_IN_THE_CENTER = 1;
    private static final double SEGMENT_VOLUME_PLANE_DOES_NOT_INTERSECT_THE_BALL = 0;

    private static final double DELTA = 0.01;

    @Test
    public void testVolumeShouldReturnCorrectWhenRadiusOne() {
        double result = calc.volume(ballWithOneRadius.getRadius());
        Assert.assertEquals(result, VOLUME_OF_A_BALL_WITH_ONE_RADIUS, DELTA);
    }

    @Test
    public void testVolumeShouldReturnCorrectWhenRadiusZero() {
        double result = calc.volume(ballWithZeroRadius.getRadius());
        Assert.assertEquals(result, VOLUME_OF_A_BALL_WITH_ZERO_RADIUS, DELTA);
    }

    @Test
    public void testSquareOfTheSphereShouldReturnCorrectWhenRadiusOne() {
        double result = calc.squareOfTheSphere(ballWithOneRadius.getRadius());
        Assert.assertEquals(result, SQUARE_OF_THE_SPHERE_WITH_ONE_RADIUS, DELTA);
    }

    @Test
    public void testSquareOfTheSphereShouldReturnZeroWhenRadiusZero() {
        double result = calc.squareOfTheSphere(ballWithZeroRadius.getRadius());
        Assert.assertEquals(result, SQUARE_OF_THE_SPHERE_WITH_ZERO_RADIUS, DELTA);
    }

    @Test
    public void testVolumeRatiosShouldReturnOneWhenPlaneIntersectTheBallInTheCenter() throws DataException {
        double result = calc.segmentVolumeRatios(ballWithOneRadius, new Point(1, 1, 1), Calculator.PlanesNames.XY);
        Assert.assertEquals(result, SEGMENT_VOLUME_PLANE_INTERSECT_THE_BALL_IN_THE_CENTER, DELTA);
    }

    @Test
    public void testVolumeRatiosShouldReturnZeroWhenPlaneDoesNotIntersectTheBall() throws DataException {
        double result = calc.segmentVolumeRatios(ballWithOneRadius, new Point(0, 0, 0), Calculator.PlanesNames.XY);
        Assert.assertEquals(result, SEGMENT_VOLUME_PLANE_DOES_NOT_INTERSECT_THE_BALL, DELTA);
    }
}
