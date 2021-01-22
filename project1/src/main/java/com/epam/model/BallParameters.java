package com.epam.model;

public class BallParameters {
    private final double volume;
    private final double area;

    public BallParameters( double volume, double area ) {
        this.volume = volume;
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public double getArea() {
        return area;
    }
}
