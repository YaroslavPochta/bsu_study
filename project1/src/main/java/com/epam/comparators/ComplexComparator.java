package com.epam.comparators;

import com.epam.model.BallObservable;

import java.util.Comparator;

public class ComplexComparator implements Comparator<BallObservable> {
    @Override
    public int compare( BallObservable o1, BallObservable o2 ) {
        if (o1.getID() == o2.getID()) {
            return Double.compare(o1.getRadius(), o2.getRadius());
        }
        return o1.getID() - o2.getID();
    }
}
