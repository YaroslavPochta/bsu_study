import java.io.IOException;

public class Main {
    public static void main(String[] args) {

      try {
        MyContainer<Bus> busList = ReaderUtils.readFromFileBus("input1.txt");
        busList.print();
        System.out.println(busList.maxElem());
        System.out.println(busList.frequency(new Bus("Audi", "red", oilEnum.valueOf("DIESEL"), 15, 4)));
        Car findBus = busList.binarySearch(new Bus("Audi", "red", oilEnum.valueOf("DIESEL"), 15, 4));
        if (findBus == null) {
          System.out.println("Car wasn't found");
        } else {
          System.out.println(findBus);
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage() + ", cause: " + e.getCause());
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

      try {
        MyContainer<PassengerCar> passCarList = ReaderUtils.readFromFilePaseengerCar("input2.txt");
        passCarList.print();
        System.out.println(passCarList.maxElem());
        System.out.println(passCarList.frequency(new PassengerCar("Audi", "red", oilEnum.valueOf("DIESEL"), seatMaterialEnum.valueOf("LEATHER"))));
        Car findCar = passCarList.binarySearch(new PassengerCar("Audi", "red", oilEnum.valueOf("DIESEL"), seatMaterialEnum.valueOf("LEATHER")));
        if (findCar == null) {
          System.out.println("Car wasn't found");
        } else {
          System.out.println(findCar);
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage() + ", cause: " + e.getCause());
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
}
