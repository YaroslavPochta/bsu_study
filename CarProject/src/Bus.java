import java.util.Objects;

public class Bus extends Car {
    private int seats;
    private int doors;

    public Bus( String carName, String color, oilEnum oilType, int seats, int doors) {
        super(carName, color, oilType);
        try {
            if (seats <= 0 || doors <= 0) throw new IncorrectInputException("Doors or Seats quantity < 0");
            this.seats = seats;
            this.doors = doors;
        } catch (IncorrectInputException e) {
            System.out.println("Incorrect input" + e.getMessage());
        }
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (!( o instanceof Bus )) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return seats == bus.seats &&
                doors == bus.doors &&
                this.getCarName().equals(bus.getCarName()) &&
                this.getOilType().equals(bus.oilType) &&
                this.getColor().equals(bus.getColor());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nBus{");
        sb.append(super.toString());
        sb.append(", seats=").append(seats);
        sb.append(", doors=").append(doors);
        sb.append("}");
        return sb.toString();
    }
}
