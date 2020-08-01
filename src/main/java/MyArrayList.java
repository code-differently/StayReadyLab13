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
        return (E) getElementAtIndex(index);
    }

    public void set(int index, E element) {
        setElementAtIndex(index, element);
    }

    public void add(E element) {
        fillAtIndexAndUpdateCapacity(getCapacity(), element);
    }

    public void add(int index, E element) {
        fillAtIndexAndUpdateCapacity(index, element);
    }

    private void fillAtIndexAndUpdateCapacity(int index, E element) {
        if(getCapacity() == size()) {
            resize();
        }
        boolean isFilled = get(index) != null;
        setElementAtIndex(index, element);
        //only add to capacity when the element is not null
        setCapacity(isFilled ? getCapacity() : getCapacity() + 1);
    }
}
