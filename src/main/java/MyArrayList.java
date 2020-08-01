import java.util.logging.Logger;
import java.util.stream.IntStream;

public class MyArrayList <E> extends MyCollection<E>{
    private static final Logger logger = Logger.getLogger("src.main.java.MyArrayList");

    public MyArrayList() {
        super();
    }

    public MyArrayList(int size) {
        super(size);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) expansiveArray[index];
    }

    public void set(int index, E element) {
        expansiveArray[index] = element;
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
        boolean isFilled = expansiveArray[index] != null;
        expansiveArray[index] = element;
        //only add to capacity when the element is not null
        capacity = isFilled ? capacity : capacity + 1;
    }
}
