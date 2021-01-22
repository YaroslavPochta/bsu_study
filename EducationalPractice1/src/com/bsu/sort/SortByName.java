package com.bsu.sort;

import com.bsu.CandyGift;
import com.bsu.model.Candy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName implements SortStrategy {
    @Override
    public CandyGift sort( List<Candy> candyList ) {
        List<Candy> copyList = new ArrayList<>(candyList);
        Collections.sort(candyList, new Comparator<Candy>() {
            @Override
            public int compare( Candy o1, Candy o2 ) {
                return o1.gatName().compareTo(o2.gatName());
            }
        });
        return new CandyGift(copyList);
    }
}
