import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;

public class MyCollection <E> {
    private Object[] expansiveArray;
    private int capacity;
    private int size;
    private final int RESIZE_FACTOR = 2;

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

    @SuppressWarnings("unchecked")
    public boolean contains(Object object) {
        return Arrays.asList(expansiveArray).contains((E) object);
    }

    public void clear() {
        expansiveArray = new Object[size];
        capacity = 0;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E elementAtIndex = (E) expansiveArray[index];
        expansiveArray[index] = (E) new Object();
        return elementAtIndex;
    }

    @SuppressWarnings("unchecked")
    public boolean removeElement(E element) {
        boolean elementExists = contains(element);
        E elementAtIndex = (E) new Object();
        if(elementExists) {
            int firstOccurrenceOfElement = findFirstOccurrenceOfElement(element);
            if(firstOccurrenceOfElement != -1) {
                elementAtIndex = (E) expansiveArray[firstOccurrenceOfElement];
                remove(firstOccurrenceOfElement);
            }
        }
        return elementExists;
    }

    private int findFirstOccurrenceOfElement(E element) {
         return IntStream.range(0, expansiveArray.length)
                .filter(i -> element ==  expansiveArray[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
    }

    public Object[] getExpansiveArray() {
        return expansiveArray;
    }

    public void setExpansiveArray(Object[] array) {
        expansiveArray = array;
    }

    @SuppressWarnings("unchecked")
    public E getElementAtIndex(int index) {
        return (E) expansiveArray[index];
    }

    public void setElementAtIndex(int index, E element) {
        expansiveArray[index] = element;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return size() > index;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                E element = (E) getElementAtIndex(index);
                index++;
                return element;
            }
        };
    }
}
