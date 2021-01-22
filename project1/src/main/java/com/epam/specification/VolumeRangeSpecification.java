package com.epam.specification;

import com.epam.logic.Calculator;
import com.epam.model.BallObservable;

public class VolumeRangeSpecification implements BallSpecification {
    private final Calculator calculator = new Calculator();
    private final double minimalVolume;
    private final double maximalVolume;

    public VolumeRangeSpecification( double minimalVolume, double maximalVolume ) {
        this.minimalVolume = minimalVolume;
        this.maximalVolume = maximalVolume;
    }

    @Override
    public boolean check( BallObservable ballObservable ) {
        double volume = calculator.volume(ballObservable.getRadius());
        return ( volume >= minimalVolume ) & ( volume <= maximalVolume );
    }
}
