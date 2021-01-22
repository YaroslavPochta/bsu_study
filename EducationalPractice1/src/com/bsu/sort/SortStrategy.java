package com.bsu.sort;

import com.bsu.CandyGift;
import com.bsu.model.Candy;

import java.util.List;

public interface SortStrategy {
    CandyGift sort( List<Candy> candyList );
}
