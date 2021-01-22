package com.company;

import java.util.Objects;

public class Cleaner extends Employee {
    private Integer numberOfRooms;

    public Cleaner( String name, Positions position, int salary, String pathToIcon, Integer numberOfRooms ) {
        super(name, position, salary, pathToIcon);
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (!( o instanceof Cleaner )) return false;
        if (!super.equals(o)) return false;
        Cleaner cleaner = (Cleaner) o;
        return Objects.equals(numberOfRooms, cleaner.numberOfRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfRooms);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cleaner{");
        sb.append(super.toString());
        sb.append(", numberOfRooms=").append(numberOfRooms);
        sb.append('}');
        return sb.toString();
    }
}
