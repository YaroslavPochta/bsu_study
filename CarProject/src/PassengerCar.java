import java.util.Objects;

enum seatMaterialEnum {PLASTIC,LEATHER, CLOTH}
public class PassengerCar extends Car {
    private seatMaterialEnum seatMaterial;

    public PassengerCar() {
    }

    public PassengerCar( String carName, String color, oilEnum oilType, seatMaterialEnum seatMaterial) {
        super(carName, color, oilType);
        this.seatMaterial = seatMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerCar)) return false;
        PassengerCar that = (PassengerCar) o;
        return Objects.equals(seatMaterial, that.seatMaterial) &&
                this.getCarName().equals(that.getCarName()) &&
                this.getOilType().equals(that.oilType) &&
                this.getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatMaterial);
    }

    @Override
    public String toString() {
        return "\nPassengerCar{" + super.toString() +
                "seatMaterial='" + seatMaterial + '\'' +
                '}';
    }
}
