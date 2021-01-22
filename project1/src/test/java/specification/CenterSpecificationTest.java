package specification;

import com.epam.model.BallObservable;
import com.epam.model.Point;
import com.epam.specification.BallSpecification;
import com.epam.specification.CenterSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CenterSpecificationTest {
    private static final Point POINT1 = new Point(1,1,1);
    private static final Point POINT2 = new Point(2,2,2);
    private final BallSpecification ballSpecification = new CenterSpecification(POINT1);

    @Test
    public void testCenterSpecificationShouldReturnTrueWhenCentersAreEquals() {
        BallObservable ballObservable = Mockito.mock(BallObservable.class);
        Mockito.when(ballObservable.getCenter()).thenReturn(POINT1);
        boolean result = ballSpecification.check(ballObservable);
        Assert.assertTrue(result);
    }

    @Test
    public void testCenterSpecificationShouldReturnFalseWhenCentersAreDifferent(){
        BallObservable ballObservable = Mockito.mock(BallObservable.class);
        Mockito.when(ballObservable.getCenter()).thenReturn(POINT2);
        boolean result = ballSpecification.check(ballObservable);
        Assert.assertFalse(result);
    }
}
