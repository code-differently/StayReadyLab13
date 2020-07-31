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

    public int size() {
        return expansiveArray.length;
    }

    public void add(E element) {
        if(capacity == size) {
            resize();
        }
        expansiveArray[capacity] = element;
        capacity++;
    }

    public void add(int index, E element) {
        if(capacity == size) {
            resize();
        }
        expansiveArray[index] = element;
        capacity++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) expansiveArray[index];
    }

    public void set(int index, E element) {
        expansiveArray[index] = element;
    }

    private void resize() {
        size = size * 2;
        expansiveArray = Arrays.copyOf(expansiveArray, size);
    }
}
