import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class MyArrayList <E>{
    private Object[] expansiveArray;
    private int capacity;
    private int size;
    private final int RESIZE_FACTOR = 2;
    private static final Logger logger = Logger.getLogger("src.main.java.MyArrayList");

    public MyArrayList() {
        expansiveArray = new Object[1];
        capacity = 0;
        size = 1;
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
        fillAtIndexAndUpdateCapacity(capacity, element);
    }

    public void add(int index, E element) {
        fillAtIndexAndUpdateCapacity(index, element);
    }

    private void fillAtIndexAndUpdateCapacity(int index, E element) {
        if(capacity == size) {
            resize();
        }
        boolean isFilled = expansiveArray[capacity] != null;
        expansiveArray[index] = element;
        //only add to capacity when the element is not null
        capacity = isFilled ? capacity : capacity + 1;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) expansiveArray[index];
    }

    public void set(int index, E element) {
        expansiveArray[index] = element;
    }

    private void resize() {
        size = size * RESIZE_FACTOR;
        expansiveArray = Arrays.copyOf(expansiveArray, size);
    }

    public void clear() {
        expansiveArray = new Object[size];
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean contains(E element) {
        return Arrays.asList(expansiveArray).contains(element);
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E elementAtIndex = (E) expansiveArray[index];
        expansiveArray[index] = (E) new Object();
        return elementAtIndex;
    }

    @SuppressWarnings("unchecked")
    public E removeElement(E element) {
        boolean elementExists = contains(element);
        E elementAtIndex = (E) new Object();
        if(elementExists) {
            int firstOccurrenceOfElement = IntStream.range(0, expansiveArray.length)
                                            .filter(i -> element ==  expansiveArray[i])
                                            .findFirst() // first occurrence
                                            .orElse(-1); // No element found
            if(firstOccurrenceOfElement != -1) {
                elementAtIndex = (E) expansiveArray[firstOccurrenceOfElement];
                remove(firstOccurrenceOfElement);
            }
        }
        return elementAtIndex;
    }
}
