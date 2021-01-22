package comparators;
import com.epam.comparators.IDComparator;
import com.epam.model.BallObservable;
import com.epam.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class IDComparatorTest {
    private static final BallObservable O1 = new BallObservable(new Point(1, 2, 3), 5);
    private static final BallObservable O2 = new BallObservable(new Point(1, 2, 3), 5);
    private static final int IDS_ARE_EQUALS = 0;

    @Test
    public void testIDComparatorShouldReturnNotEqualsWhenDifferentIDs() {
        IDComparator idComparator = new IDComparator();

        int result = idComparator.compare(O1, O2);
        Assert.assertNotEquals(IDS_ARE_EQUALS, result);
    }
}
