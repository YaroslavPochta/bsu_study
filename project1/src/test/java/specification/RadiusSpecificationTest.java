package specification;

import com.epam.model.BallObservable;
import com.epam.specification.BallSpecification;
import com.epam.specification.RadiusSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class RadiusSpecificationTest {
    private static final double RADIUS1 = 1.0;
    private static final double RADIUS2 = 2.0;
    private final BallSpecification ballSpecification = new RadiusSpecification(RADIUS1);

    @Test
    public void testRadiusSpecificationShouldReturnTrueWhenRadiiAreEquals() {
        BallObservable ballObservable = Mockito.mock(BallObservable.class);
        Mockito.when(ballObservable.getRadius()).thenReturn(RADIUS1);
        boolean result = ballSpecification.check(ballObservable);
        Assert.assertTrue(result);
    }

    @Test
    public void testRadiusSpecificationShouldReturnFalseWhenRadiiAreDifferent() {
        BallObservable ballObservable = Mockito.mock(BallObservable.class);
        Mockito.when(ballObservable.getRadius()).thenReturn(RADIUS2);
        boolean result = ballSpecification.check(ballObservable);
        Assert.assertFalse(result);
    }
}