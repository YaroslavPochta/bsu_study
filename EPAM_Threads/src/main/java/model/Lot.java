package model;

import java.util.Objects;

public class Lot {
    private final String name;
    private int startPrice;

    public Lot( String lotName, int lotStartPrice ) {
        this.name = lotName;
        this.startPrice = lotStartPrice;
    }

    public String getName() {
        return name;
    }

    public int getStartPrice() {
        return startPrice;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) {
            return true;
        }
        if (!( o instanceof Lot )) {
            return false;
        }
        Lot lot = (Lot) o;
        return getStartPrice() == lot.getStartPrice()
                && Objects.equals(getName(), lot.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStartPrice());
    }

    @Override
    public String toString() {
        return "Lot{" + "name='" + name + '\''
                + ", startPrice=" + startPrice + '}';
    }
}