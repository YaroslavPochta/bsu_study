package com.epam.repository;

import com.epam.exceptions.DataException;
import com.epam.model.BallObservable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.specification.BallSpecification;
import java.util.*;

//TODO: Map (ID as a key), equals instead of contains, update wih ID, LOGGER exception only when we process it, null checking everywhere
//TODO: Query instead of FindBy, Map -> List -> List.sort -> return List, ID in map and another ID in Object, save() instead of add and update
//TODO: VolumeRatios should throw Exception when plane isn't intersect the Ball (zero if it touch the ball)
public class BallListRepository implements BallRepository {
    private static final Logger LOGGER = LogManager.getLogger(BallListRepository.class);
    private final Map<Integer, BallObservable> ballMap = new HashMap<>();

    @Override
    public void save( BallObservable ball ) throws DataException {
        if (ballMap.containsKey(ball.getID())) {
            remove(ball);
        }
        ballMap.put(ball.getID(), ball);
        LOGGER.info("Ball was saved");
    }

    @Override
    public void remove( BallObservable ball ) throws DataException {
        if (ballMap.isEmpty()) {
            throw new DataException("Ball set is empty");
        }
        if (ballMap.containsKey(ball.getID())) {
            ballMap.remove(ball.getID());
            LOGGER.info("Ball was removed");
        }
    }


    @Override
    public List<BallObservable> query( BallSpecification ballSpecification ) {
        List<BallObservable> ballList = new ArrayList<>();
        ballMap.forEach(( Integer key, BallObservable ball ) -> {
            if (ballSpecification.check(ball)) {
                ballList.add(ball);
            }
        });
        return ballList;
    }

    public Map<Integer, BallObservable> getBallMap() {
        return ballMap;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BallListRepository{");
        sb.append("ballMap=").append(ballMap);
        sb.append('}');
        return sb.toString();
    }
}
