package specification;

import com.epam.model.BallObservable;
import com.epam.specification.BallSpecification;
import com.epam.specification.IDSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IDSpecificationTest {
    private static final int ID = 1;
    private static final int INCORRECT_ID = 123;
    private final BallSpecification ballSpecification = new IDSpecification(ID);

    @Test
    public void testIDSpecificationShouldReturnTrueWhenIDsAreEquals() {
        BallObservable ballObservable = Mockito.mock(BallObservable.class);
        Mockito.when(ballObservable.getID()).thenReturn(ID);
        boolean result = ballSpecification.check(ballObservable);
        Assert.assertTrue(result);
    }

    @Test
    public void testIDSpecificationShouldReturnFalseWhenIDsAreDifferent() {
        BallObservable ballObservable = Mockito.mock(BallObservable.class);
        Mockito.when(ballObservable.getID()).thenReturn(INCORRECT_ID);
        boolean result = ballSpecification.check(ballObservable);
        Assert.assertFalse(result);
    }
}