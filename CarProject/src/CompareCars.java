import java.util.Comparator;

public class CompareCars<T extends Car> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if(o1.getCarName().equals(o2.getCarName())){
            if (o1.getOilType().equals(o2.getOilType())){
                return 0;
            }
            else
                return -o1.getOilType().compareTo(o2.getOilType());
        }
        else
            return -o1.getCarName().compareTo(o2.getCarName());
    }
}

/*
public class CompareCars<T extends Car> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if(o1.getCarName().equals(o2.getCarName()))
                return -o1.getOilType().compareTo(o2.getOilType());
            return -o1.getCarName().compareTo(o2.getCarName());
    }
}
 */