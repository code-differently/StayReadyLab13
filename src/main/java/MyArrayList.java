import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList <E extends Object>{
    private Object[] expansiveArray;

    public MyArrayList() {
        expansiveArray = new Object[0];
    }

    public MyArrayList(int size) {
        expansiveArray = new Object[size];
    }

    @SuppressWarnings("unchecked")
    private void populateArray(Object[] array, Object elementToSet) {
        Arrays.fill(array, (E) elementToSet);
    }

    public int size() {
        return expansiveArray.length;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) expansiveArray[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        E temp = (E) expansiveArray[index];
        expansiveArray[index] = element;
        return temp;
    }

//    public void add(E element) {
//
//    }
}
