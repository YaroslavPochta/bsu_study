import java.util.List;
public class MyUtils<T> {
    public static <type> boolean find(type[] array, type elem) {
        for (type i : array){
            if (i.equals(elem))
            {
                return true;
            }
        }
        return false;
    }
    public static <type> boolean find(List<type> array, type elem) { //intList.contains();
        for (type i : array){
            if (i.equals(elem))
            {
                return true;
            }
        }
        return false;
    }
    public int count(List<T> intList, int value) { //Collections.frequency()
        int count = 0;
        for (T i : intList){
            if (i.equals(value))
            {
                count++;
            }
        }
        return count;
    }
    public <U extends  Number> int sum (List<U> numList)
    {
        int sum = 0;
        for (U i : numList ){
            sum += i.intValue();
        }
        return sum;
    }
    public int sr (List<T> intList)
    {
        if (intList.size() == 0) throw new ArithmeticException("Divide by 0");
        return 0;
    }
    public boolean specificProperty (T val)
    {
        return true;
    }
    public int countIf (List<T> numList, EvenPredicate specificProperty) {
        int count = 0;
        for (T num : numList) if (specificProperty(num)) count++;
        return count;
    }

    public void swap (T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public T maxElemRange<T extends Object&Comparable>(List<T> list, int begin, int end)
    {
        T max = list.get(begin);
        for (int i = begin; i<end; i++) if(list.get(i) > max) max = list.get(i);
    }
}
class EvenPredicate<T extends Number>
{
    public boolean test (T val)
    {
        return val.intValue()%2 == 0;
    }
}

