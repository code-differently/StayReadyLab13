import java.util.Arrays;

public class MyCollection <E> {
    protected Object[] expansiveArray;
    protected int capacity;
    protected int size;
    protected final int RESIZE_FACTOR = 2;

    public MyCollection() {
        expansiveArray = new Object[1];
        capacity = 0;
        size = 1;
    }

    public MyCollection(int size) {
        expansiveArray = new Object[size];
        capacity = 0;
        this.size = size;
    }

    public int size() {
        return expansiveArray.length;
    }

    protected void resize() {
        size = size * RESIZE_FACTOR;
        expansiveArray = Arrays.copyOf(expansiveArray, size);
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean contains(E element) {
        return Arrays.asList(expansiveArray).contains(element);
    }

    public void clear() {
        expansiveArray = new Object[size];
    }
}
