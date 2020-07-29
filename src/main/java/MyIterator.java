import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

    private final MyArrayList<T> set;
    private int next = 0;

    MyIterator(MyArrayList<T> set) {
        this.set = set;
    }

    public boolean hasNext() {
        return next < set.size();
    }

    public T next() {
        return set.get(next++);
    }

    public void remove() {
        // No removing
    }
}
