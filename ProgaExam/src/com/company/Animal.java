package com.company;

abstract public class Animal implements Comparable {
    private String name;
    private String habitat;

    public Animal( String name, String habitat ) {
        this.name = name;
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat( String habitat ) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("name='").append(name).append('\'');
        sb.append(", habitat='").append(habitat).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
