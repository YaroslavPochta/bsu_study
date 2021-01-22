package observer;

import com.epam.model.BallObservable;
import com.epam.model.Point;
import com.epam.observer.BallObserver;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class BallObservableTest {
    private final BallObservable ballObservable = new BallObservable(new Point(2, 3, 4), 5);

    @Test
    public void testObservableShouldCallUpdateWhenSetNewCenter() {
        BallObserver ballObserver = Mockito.mock(BallObserver.class);
        ballObservable.addObserver(ballObserver);
        ballObservable.setCenter(new Point(1, 1, 1));
        verify(ballObserver).update(ballObservable);
        verifyNoMoreInteractions(ballObserver);
    }

    @Test
    public void testObservableShouldCallUpdateWhenSetNewRadius() {
        BallObserver ballObserver = Mockito.mock(BallObserver.class);
        ballObservable.addObserver(ballObserver);
        ballObservable.setRadius(6);
        verify(ballObserver).update(ballObservable);
        verifyNoMoreInteractions(ballObserver);
    }
}
