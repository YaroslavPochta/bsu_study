package com.company.model;


public class FruitPlant extends Plant {
    private final double weight;
    private final SeasonType seasonType;
    private final int growingTime;

    public FruitPlant( String name, SoilType soilType, Origin origin, double weight, SeasonType seasonType, int growingTime ) {
        super(name, soilType, origin);
        this.weight = weight;
        this.seasonType = seasonType;
        this.growingTime = growingTime;
    }

    public double getWeight() {
        return weight;
    }

    public SeasonType getSeasonType() {
        return seasonType;
    }

    public int getGrowingTime() {
        return growingTime;
    }

    @Override
    public SoilType getSoilType() {
        return super.getSoilType();
    }

    @Override
    public Origin getOrigin() {
        return super.getOrigin();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
