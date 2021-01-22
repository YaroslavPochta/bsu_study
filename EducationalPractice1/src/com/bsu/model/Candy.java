package com.bsu.model;

abstract public class Candy implements Comparable {
    public double weight;
    public double percentOfSugar;
    public String name;

    public Candy( double weight, double percentOfSugar, String name ) {
        this.weight = weight;
        this.percentOfSugar = percentOfSugar;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPercentOfSugar() {
        return percentOfSugar;
    }

    public String gatName() {
        return name;
    }

    public double getSugarQuantity() {
        return ( weight * percentOfSugar ) / 100;
    }

    @Override
    public int compareTo( Object obj ) {
        Candy o = (Candy)obj;
        if (Double.compare(weight, o.weight) == 0) {
            if (Double.compare(percentOfSugar, o.percentOfSugar) == 0) {
                return name.compareTo(o.name);
            }
            return Double.compare(percentOfSugar, o.percentOfSugar);
        }
        return Double.compare(weight, o.weight);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candy{");
        sb.append("weight=").append(weight);
        sb.append(", percentOfSugar=").append(percentOfSugar);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
