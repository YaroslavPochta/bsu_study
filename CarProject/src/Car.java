import java.util.Objects;

enum oilEnum { PETROL, DIESEL }

abstract public class Car {
     String carName;
     String color;
     oilEnum oilType;

    public Car() {}

    public Car(String carName, java.lang.String color, oilEnum oilType) {
        this.carName = carName;
        this.color = color;
        this.oilType = oilType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("carName='").append(carName).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", oilType=").append(oilType);
        sb.append('}');
        return sb.toString();
    }

    public String getCarName() {
        return carName;
    }

    public String getColor() {
        return color;
    }

    public oilEnum getOilType() {
        return oilType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(color, car.color) &&
                oilType == car.oilType;
    }
}
