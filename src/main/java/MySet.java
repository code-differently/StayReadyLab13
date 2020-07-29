import java.util.Collection;
import java.util.Iterator;

public class MySet<T> implements Collection<T> {

    MyArrayList<T> set = new MyArrayList<>();

    public boolean add(T element) {
        if(!set.contains(element)) {
            set.add(element);
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean allAdded = true;
        for (T t : c) {
            if(!this.add(t))
                allAdded = false;
        }
        return allAdded;
    }

    public void clear() {
        set.clear();
    }

    public boolean contains(Object element) {
        return set.contains(element);
    }

    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public Iterator<T> iterator() {
        return new MyIterator<>(this.set);
    }

    public boolean remove(Object element) {
        return set.remove(element);
    }

    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    public int size() {
        return set.size();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }
}
