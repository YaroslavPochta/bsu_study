package com.bsu.sort;

import com.bsu.CandyGift;
import com.bsu.model.Candy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByWeight implements SortStrategy{
    @Override
    public CandyGift sort( List<Candy> candyList ) {
        List<Candy> copyList = new ArrayList<>(candyList);
        Collections.sort(copyList, new Comparator<Candy>() {
            @Override
            public int compare( Candy o1, Candy o2 ) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        return new CandyGift(copyList);
    }
}
