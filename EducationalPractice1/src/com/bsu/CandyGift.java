package com.bsu;

import com.bsu.model.Candy;
import com.bsu.sort.SortStrategy;

import java.util.ArrayList;
import java.util.List;

public class CandyGift{
    private List<Candy> candyList = new ArrayList<>();
    private SortStrategy sorter;

    public CandyGift() {
    }

    public CandyGift( List candyList ) {
        this.candyList = candyList;
    }

    public CandyGift( SortStrategy sorter ) {
        this.sorter = sorter;
    }

    public void addCandy( Candy candy) {
        candyList.add(candy);
    }

    public int size(){
        return candyList.size();
    }

    public Candy get(int index){
        return candyList.get(index);
    }

    public double getCommonWeight() {
        double commonWeight = 0;
        for (Candy candy : candyList) {
            commonWeight += candy.getWeight();
        }
        return commonWeight;
    }

    public double getCommonSugarWeight() {
        double commonSugarWeight = 0;
        for (Candy candy : candyList) {
            commonSugarWeight += candy.getSugarQuantity();
        }
        return commonSugarWeight;
    }

    public Candy findCandy(double lowerBound, double upperBound) {
        for (Candy candy : candyList) {
            if(candy.getSugarQuantity() > lowerBound && candy.getSugarQuantity() < upperBound){
                return candy;
            }
        }
        return null;
    }

    public void print(SortStrategy sortStrategy) {
        sorter = sortStrategy;
        System.out.println(sorter.sort(candyList));
    }

    public void print() {
        CandyGift copyGift = new CandyGift(candyList);
        System.out.println(copyGift);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CandyGift{\n");
        for (Candy candy : candyList) {
            sb.append(candy.toString()).append('\n');
        }
        sb.append('}');
        return sb.toString();
    }
}
