package repository;

import com.epam.comparators.IDComparator;
import com.epam.comparators.RadiusComparator;
import com.epam.exceptions.DataException;
import com.epam.model.BallObservable;
import com.epam.model.Point;
import com.epam.repository.BallListRepository;
import com.epam.specification.BallSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

public class BallRepositoryTest {
    private final BallObservable ballObservable1 = new BallObservable(new Point(1, 2, 3), 4);
    private final BallObservable ballObservable2 = new BallObservable(new Point(1, 2, 3), 5);
    private final BallObservable ballObservable3 = new BallObservable(new Point(1, 2, 5), 5);
    private final BallListRepository ballRepositoryWithSingleBall = new BallListRepository();
    private final List<BallObservable> expectedFilterList = Arrays.asList(ballObservable2, ballObservable3);

    @Test
    public void testSaveShouldAddNewItemInTheMap() throws DataException {
        ballRepositoryWithSingleBall.save(ballObservable1);
        BallListRepository ballListRepository = new BallListRepository();
        ballListRepository.save(ballObservable1);
        Assert.assertEquals(ballListRepository.getBallMap(), ballRepositoryWithSingleBall.getBallMap());
    }

    @Test
    public void testSaveShouldDeleteOldItemAndAddNewItemInTheMap() throws DataException {
        ballRepositoryWithSingleBall.save(ballObservable1);
        BallListRepository ballListRepository = new BallListRepository();
        ballListRepository.save(ballObservable1);
        ballListRepository.save(ballObservable1);
        Assert.assertEquals(ballListRepository.getBallMap(), ballRepositoryWithSingleBall.getBallMap());
    }

    @Test
    public void testRemoveShouldDeleteOldItemInTheMap() throws DataException {
        BallListRepository ballListRepository = new BallListRepository();
        ballListRepository.save(ballObservable1);
        ballListRepository.remove(ballObservable1);
        Assert.assertEquals(ballListRepository.getBallMap(), ballRepositoryWithSingleBall.getBallMap());
    }

    @Test
    public void testQueryShouldReturnCorrectListUsingSpecification() throws DataException {
        BallSpecification ballSpecification = Mockito.mock(BallSpecification.class);
        Mockito.when(ballSpecification.check(ballObservable1)).thenReturn(false);
        Mockito.when(ballSpecification.check(ballObservable2)).thenReturn(true);
        Mockito.when(ballSpecification.check(ballObservable3)).thenReturn(true);
        BallListRepository ballListRepository = new BallListRepository();
        ballListRepository.save(ballObservable1);
        ballListRepository.save(ballObservable2);
        ballListRepository.save(ballObservable3);

        List<BallObservable> actualList = ballListRepository.query(ballSpecification);
        actualList.sort(new IDComparator());
        expectedFilterList.sort(new IDComparator());
        // without sorting objects in Lists in random order
        Assert.assertEquals(expectedFilterList, actualList);
    }
}
