package com.epam.comparators;

import com.epam.model.BallObservable;

import java.util.Comparator;

public class IDComparator implements Comparator<BallObservable> {
    @Override
    public int compare( BallObservable o1, BallObservable o2 ) {
        return o1.getID() - o2.getID();
    }
}
