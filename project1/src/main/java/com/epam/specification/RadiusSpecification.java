package com.epam.specification;

import com.epam.model.BallObservable;

public class RadiusSpecification implements BallSpecification {
    private final double radius;

    public RadiusSpecification( double radius ) {
        this.radius = radius;
    }

    @Override
    public boolean check( BallObservable ballObservable ) {
        return ( Double.compare(radius, ballObservable.getRadius()) == 0 );
    }
}
