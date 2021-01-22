package com.epam.specification;

import com.epam.model.BallObservable;
import com.epam.model.Point;

public class CenterSpecification implements BallSpecification {
    private final Point point;

    public CenterSpecification( Point point ) {
        this.point = point;
    }

    @Override
    public boolean check( BallObservable ballObservable ) {
        return point.equals(ballObservable.getCenter());
    }
}
