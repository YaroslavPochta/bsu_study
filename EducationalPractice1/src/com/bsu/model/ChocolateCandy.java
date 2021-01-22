package com.bsu.model;

public class ChocolateCandy extends Candy{
    private String chocolateType;

    public ChocolateCandy( double weight, double percentOfSugar, String mark, String chocolateType ) {
        super(weight, percentOfSugar, mark);
        this.chocolateType = chocolateType;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChocolateCandy{");
        sb.append(super.toString()).append(", ");
        sb.append("chocolateType='").append(chocolateType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
