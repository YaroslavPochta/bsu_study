package comparators;

import com.epam.comparators.CenterCoordinateXComparator;
import com.epam.model.BallObservable;
import com.epam.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class CenterCoordinateXComparatorTest {
    private static final BallObservable O1 = new BallObservable(new Point(1, 2, 3), 5);
    private static final BallObservable O2 = new BallObservable(new Point(1, 2, 3), 5);
    private static final BallObservable O3 = new BallObservable(new Point(2, 2, 3), 5);
    private static final int X_POINTS_ARE_EQUALS_RESULT = 0;
    private static final int X_POINT_ARE_NOT_EQUALS_RESULT = -1; // O1.center.X < 03.center.X

    @Test
    public void testCenterCoordinateXComparatorShouldReturnZeroWhenBallsEquals() {
        CenterCoordinateXComparator centerCoordinateXComparator = new CenterCoordinateXComparator();

        int result = centerCoordinateXComparator.compare(O1, O2);
        Assert.assertEquals(X_POINTS_ARE_EQUALS_RESULT, result);
    }

    @Test
    public void testCenterCoordinateXComparatorShouldReturnOneWhenBallsEquals() {
        CenterCoordinateXComparator centerCoordinateXComparator = new CenterCoordinateXComparator();

        int result = centerCoordinateXComparator.compare(O1, O3);
        Assert.assertEquals(X_POINT_ARE_NOT_EQUALS_RESULT, result);
    }
}
