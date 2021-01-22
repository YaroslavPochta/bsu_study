package com.bsu.model;

public class Marmalade extends Candy {
    public String fruit;

    public Marmalade( double weight, double percentOfSugar, String mark, String fruit ) {
        super(weight, percentOfSugar, mark);
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Marmalade{");
        sb.append(super.toString()).append(", ");
        sb.append("fruit='").append(fruit).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
