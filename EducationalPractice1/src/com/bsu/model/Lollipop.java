package com.bsu.model;

public class Lollipop extends Candy {
    public String colour;

    public Lollipop( double weight, double percentOfSugar, String mark, String colour ) {
        super(weight, percentOfSugar, mark);
        this.colour = colour;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lollipop{");
        sb.append(super.toString()).append(", ");
        sb.append("colour='").append(colour).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
