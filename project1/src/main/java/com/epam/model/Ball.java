package com.epam.model;

import java.util.Objects;

public class Ball {
    private Point center;
    private double radius;

    public Ball( Point center, double radius ) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter( Point center ) {
        this.center = center;
    }

    public void setRadius( double radius ) {
        this.radius = radius;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) {
            return true;
        }
        if (!( o instanceof Ball )) {
            return false;
        }
        Ball ball = (Ball) o;
        return Double.compare(ball.getRadius(), getRadius()) == 0 &&
                this.center.equals(( (Ball) o ).center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCenter(), getRadius());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
}
