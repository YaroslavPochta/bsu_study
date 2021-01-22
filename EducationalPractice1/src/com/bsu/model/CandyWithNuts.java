package com.bsu.model;

public class CandyWithNuts extends Candy {
    public int numberOfNuts;

    public CandyWithNuts( double weight, double percentOfSugar, String mark, int numberOfNuts ) {
        super(weight, percentOfSugar, mark);
        this.numberOfNuts = numberOfNuts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CandyWithNuts{");
        sb.append(super.toString()).append(", ");
        sb.append("numberOfNuts=").append(numberOfNuts);
        sb.append('}');
        return sb.toString();
    }
}
