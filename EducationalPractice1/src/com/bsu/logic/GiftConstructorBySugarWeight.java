package com.bsu.logic;

import com.bsu.CandyGift;
import com.bsu.model.Candy;

import java.util.List;
import java.util.Random;

public class GiftConstructorBySugarWeight implements GiftConstructorStrategy {
    @Override
    public CandyGift constructGift(List<Candy> candyList, double maxSugarWeight) {
        CandyGift gift = new CandyGift();
        Random rand = new Random();
        while (gift.getCommonSugarWeight() < maxSugarWeight) {
            gift.addCandy(candyList.get(rand.nextInt(candyList.size())));
        }
        return gift;
    }
}
