package com.epam.comparators;

import com.epam.model.Ball;
import java.util.Comparator;

public class RadiusComparator implements Comparator<Ball> {
    @Override
    public int compare( Ball o1, Ball o2 ) {
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
