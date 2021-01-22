import java.util.Arrays;
import java.util.List;
public class Demo {
    public void main(String[] args) {
        Integer[] intArray = {2,3,5,6,76,4,34,436,43};
        System.out.println("IsFind = " + MyUtils.find(intArray, 6567));
        List<Integer> intList = Arrays.asList(intArray);
        System.out.println(MyUtils.countIf(intList, EvenPredicate.test()));
    }
}
