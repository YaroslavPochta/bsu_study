import com.epam.exceptions.SingletonException;
import com.epam.observer.BallObserver;
import com.epam.logic.Calculator;
import com.epam.model.BallObservable;
import com.epam.model.BallParameters;
import com.epam.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BallObserverTest {
    private static final double VOLUME = 25.0;
    private static final double AREA_OF_SPHERE = 25.0;
    private static final double DELTA = 0.001;
    BallObservable BALL = new BallObservable(new Point(1, 2, 3), 5);

    @Test
    public void testUpdateShouldUpdateAreaAndVolumeWhenBallSupplied() throws SingletonException {
        Calculator calculator = Mockito.mock(Calculator.class);
        Mockito.when(calculator.squareOfTheSphere(BALL.getRadius())).thenReturn(AREA_OF_SPHERE);
        Mockito.when(calculator.volume(BALL.getRadius())).thenReturn(VOLUME);
        BallObserver.initInstance(calculator);
        BallObserver ballObserver = BallObserver.getInstance();
        ballObserver.update(BALL);
        BallParameters expectedParameters = ballObserver.getParameters(BALL.getID());
        Assert.assertEquals(AREA_OF_SPHERE, expectedParameters.getArea(), DELTA);
        Assert.assertEquals(VOLUME, expectedParameters.getVolume(), DELTA);
        Mockito.verify(calculator).squareOfTheSphere(BALL.getRadius());
        Mockito.verify(calculator).volume(BALL.getRadius());

        Mockito.verifyNoMoreInteractions(calculator);
    }
}
