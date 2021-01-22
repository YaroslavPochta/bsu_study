package com.epam.logic;

import com.epam.exceptions.DataException;
import com.epam.model.Ball;
import com.epam.model.Point;

import javax.xml.crypto.Data;

public class Calculator {

    public enum PlanesNames {XY, XZ, YZ}

    public double volume( double radius ) {
        return 4 * Math.pow(radius, 3) * Math.PI / 3;
    }

    private double segmentVolume( double radius, double height ) {
        return ( Math.PI * Math.pow(height, 2) * ( 3 * radius - height ) ) / 3;
    }

    public double squareOfTheSphere( double radius ) {
        return 4 * Math.pow(radius, 2) * Math.PI;
    }

    private double calculateVolumeRatios( double centerCoordinate, double planeCoordinate, double radius ) throws DataException {
        if (Math.abs(centerCoordinate - planeCoordinate) == radius) {
            return 0.0; // Plane touches the ball
        }
        if (Math.abs(centerCoordinate - planeCoordinate) < radius) {
            double height = radius - Math.abs(centerCoordinate - planeCoordinate);
            double segmentVolume = segmentVolume(radius, height);
            double result = ( volume(radius) - segmentVolume ) / segmentVolume;
            return result;
        } else {
            throw new DataException("Incorrect data, plane doesn't intersect the ball");
        }
    }

    public double segmentVolumeRatios( Ball ball, Point point, PlanesNames coordinateAxe ) throws DataException {
        double result = 0.0;
        Point ballCenter = ball.getCenter();
        double radius = ball.getRadius();
        switch (coordinateAxe) {
            case XY: {
                result = calculateVolumeRatios(ballCenter.getZ(), point.getZ(), radius);
            }
            case XZ: {
                result = calculateVolumeRatios(ballCenter.getZ(), point.getZ(), radius);
            }
            case YZ: {
                result = calculateVolumeRatios(ballCenter.getZ(), point.getZ(), radius);
            }
        }
        return result;
    }
}
