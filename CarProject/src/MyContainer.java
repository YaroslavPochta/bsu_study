import java.util.*;
class MyContainer<T extends Car> extends ArrayList<T>
{
    public void print(){
        System.out.println(this);
    }

    public int frequency( T obj) throws NullPointerException {
        try {
            if (this.isEmpty()) throw new EmptyCollectionException("Container is empty");
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessege());
        }
        return Collections.frequency(this, obj);
    }

    public T maxElem() {
        try {
            if (this.isEmpty()) throw new EmptyCollectionException("Container is empty");
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessege());
        }
        return Collections.max(this, new CompareCars<Car>());
    }

    public Car binarySearch(T obj) {
        List<Car> newCont = new ArrayList<>();  // this
        try {
            if (this.isEmpty()) throw new EmptyCollectionException("Container is empty");
            newCont = (MyContainer<Car>) super.clone();
            newCont.sort(new CompareCars<>());
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessege());
        }
        return newCont.get(Collections.binarySearch(newCont, obj, new CompareCars<>()));
    }
}