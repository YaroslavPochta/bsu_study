package com.company;
import java.util.Arrays;
import java.util.Objects;

public class Beast extends Animal {
    private String[] production;

    public Beast( String name, String habitat, String[] production ) {
        super(name, habitat);
        this.production = production;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Beast{");
        sb.append(super.toString());
        sb.append("production=").append(Arrays.toString(production));
        sb.append(", mass = " ).append(mass());
        sb.append('}');
        return sb.toString();
    }


    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (!( o instanceof Beast )) return false;
        Beast beast = (Beast) o;
        return Objects.equals(production, beast.production);
    }

    @Override
    public int compareTo( Object o ) {
        if(this.getHabitat().equals(( (Beast) o ).getHabitat()))
            return this.getName().compareTo(((Beast)o).getName());
        return this.getHabitat().compareTo(( (Beast) o ).getHabitat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(production);
    }

    public String[] getProduction() {
        return production;
    }

    public void setProduction( String[] production ) {
        this.production = production;
    }

    public double mass(){
        return (production.length * Math.PI);
    }


}
