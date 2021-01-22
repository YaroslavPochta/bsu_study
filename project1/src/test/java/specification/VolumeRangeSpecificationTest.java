package specification;

import com.epam.model.BallObservable;
import com.epam.specification.BallSpecification;
import com.epam.specification.VolumeRangeSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class VolumeRangeSpecificationTest {
    private static final double RADIUS1 = 1.5;
    private static final double RADIUS2 = 3.0;
    private static final double MINIMAL_VOLUME = 4.18; //  Volume of the ball with radius = 1.0
    private static final double MAXIMAL_VOLUME = 33.5; //  Volume of the ball with radius = 2.0
    private final BallSpecification ballSpecification = new VolumeRangeSpecification(MINIMAL_VOLUME, MAXIMAL_VOLUME);

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