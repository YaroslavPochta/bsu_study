package com.company.model;

public class Flower extends Plant{
    private final double sizeOfFlowerInCm;
    private final int numberOfFlowers;
    private final Colour colour;

    public Flower( String name, SoilType soilType, Origin origin, double sizeOfFlowerInCm, int numberOfFlowers, Colour colour ) {
        super(name, soilType, origin);
        this.sizeOfFlowerInCm = sizeOfFlowerInCm;
        this.numberOfFlowers = numberOfFlowers;
        this.colour = colour;
    }

    public double getSizeOfFlowerInCm() {
        return sizeOfFlowerInCm;
    }

    public int getNumberOfFlowers() {
        return numberOfFlowers;
    }

    public Colour getColour() {
        return colour;
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
