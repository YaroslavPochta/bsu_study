package com.bsu;

import com.bsu.logic.GiftConstructorByWeight;
import com.bsu.logic.GiftConstructorStrategy;
import com.bsu.model.Candy;
import com.bsu.model.CandyWithNuts;
import com.bsu.sort.SortBySugarMass;
import com.bsu.sort.SortByWeight;
import com.bsu.sort.SortStrategy;

import java.util.List;

public class Main {
    private static final String INPUT_FILENAME = "input.xml";
    public static void main(String[] args) {
        final List<Candy> candyList = Reader.parse(INPUT_FILENAME);
        candyList.add(new CandyWithNuts(23,3,"bgvfhcd", Integer.parseInt("1")));
        SortStrategy sorter = new SortBySugarMass();
        sorter.sort(candyList);
        for (Candy candy : candyList) {
            System.out.println(candy);
        }
        CandyGift bigGift = new CandyGift(candyList);
        System.out.println("\n\n\n");
        GiftConstructorStrategy giftConstructor = new GiftConstructorByWeight();
        CandyGift gift = giftConstructor.constructGift(candyList, 100);
        gift.print();
        bigGift.print(new SortByWeight());
        System.out.println(bigGift.findCandy(20,41));
    }
}
