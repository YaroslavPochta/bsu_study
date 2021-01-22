import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderUtils {
    static MyContainer<Bus> readFromFileBus( String filename) throws IOException
    {
        MyContainer<Bus> list = new MyContainer<>();
        String str;
        BufferedReader bufferedReader = new BufferedReader( new FileReader(filename));
        while((str = bufferedReader.readLine()) != null)
        {
            String[] data = str.split(" ");
            list.add(new Bus(data[0], data[1], oilEnum.valueOf(data[2]), Integer.valueOf(data[3]), Integer.valueOf(data[4]) ));
        }
        return list;
    }
    static MyContainer<PassengerCar> readFromFilePaseengerCar(String filename) throws IOException
    {
        MyContainer<PassengerCar> list = new MyContainer<>();
        String str;
        BufferedReader bufferedReader = new BufferedReader( new FileReader(filename));
        while((str = bufferedReader.readLine()) != null)
        {
            String[] data = str.split(" ");
            list.add(new PassengerCar(data[0], data[1], oilEnum.valueOf(data[2]), seatMaterialEnum.valueOf(data[3])));
        }
        return list;
    }
}
