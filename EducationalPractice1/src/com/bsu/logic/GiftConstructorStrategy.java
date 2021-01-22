package com.bsu.logic;

import com.bsu.CandyGift;
import com.bsu.model.Candy;

import java.util.List;

public interface GiftConstructorStrategy {
    CandyGift constructGift( List<Candy> candyList, double parameter);
}
