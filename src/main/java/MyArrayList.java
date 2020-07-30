import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList <E>{
    private Object[] expansiveArray;
    private int capacity;
    private int size;

    public MyArrayList() {
        expansiveArray = new Object[0];
        capacity = 0;
        size = 0;
    }

    public MyArrayList(int size) {
        expansiveArray = new Object[size];
        capacity = 0;
        this.size = size;
    }

    @SuppressWarnings("unchecked")
    public void populateArray(Object elementToSet) {
        Arrays.fill(expansiveArray, (E) elementToSet);
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
}
