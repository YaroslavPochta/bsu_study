package com.company;

import java.util.Comparator;

public class CompareByMass implements Comparator<Beast> {
    @Override
    public int compare( Beast o1, Beast o2 ) {
        return Double.compare(o1.mass(), o2.mass());
    }
}
