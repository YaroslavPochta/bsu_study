package com.bsu.logic;

import com.bsu.CandyGift;
import com.bsu.model.Candy;

import java.util.List;
import java.util.Random;

public class GiftConstructorByWeight implements GiftConstructorStrategy {
    @Override
    public CandyGift constructGift( List<Candy> candyList, double maxWeight) {
        CandyGift gift = new CandyGift();
        Random rand = new Random();
        while (gift.getCommonWeight() < maxWeight) {
            gift.addCandy(candyList.get(rand.nextInt(candyList.size())));
        }
        return gift;
    }
}
