package comparators;

import com.epam.comparators.RadiusComparator;
import com.epam.model.BallObservable;
import com.epam.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class RadiusComparatorTest {
    private static final BallObservable O1 = new BallObservable(new Point(1, 2, 3), 5);
    private static final BallObservable O2 = new BallObservable(new Point(1, 2, 3), 5);
    private static final BallObservable O3 = new BallObservable(new Point(2, 2, 3), 6);
    private static final int RADII_ARE_EQUALS = 0;
    private static final int RADII_ARE_NOT_EQUALS_WITH_THE_DELTA_MINUS_1 = -1;

    @Test
    public void testRadiusComparatorShouldReturnZeroWhenBallsRadiiAreEquals() {
        RadiusComparator radiusComparator = new RadiusComparator();

        int result = radiusComparator.compare(O1, O2);
        Assert.assertEquals(RADII_ARE_EQUALS, result);
    }

    @Test
    public void testRadiusComparatorShouldReturnMinusOneWhenBallsRadiiAreNotEquals() {
        RadiusComparator radiusComparator = new RadiusComparator();

        int result = radiusComparator.compare(O1, O3);
        Assert.assertEquals(RADII_ARE_NOT_EQUALS_WITH_THE_DELTA_MINUS_1, result);
    }
}
