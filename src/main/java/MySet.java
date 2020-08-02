import java.util.Arrays;
import java.util.Collection;

public class MySet<E> {
    private E[] arr;
    private int defaultSize = 0;

    public MySet() {
        this.arr = (E[]) (new Object[defaultSize]);
    }

    public MySet(int size) {
        this();
        if (size < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        E empty = (E) new Object();
        this.arr = (E[]) new Object[size];
        //Arrays.fill(arr, empty);
    }

    // Adds the specified element to this set if it is not already present (optional operation).
    public boolean add(E e) {
        if (!contains(e)) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = e;
            return true;
        } else {
            return false;
        }
    }

    public boolean addAll(Collection<E> c) {
        E[] typeArr = (E[]) c.toArray();
        for (int i = 0; i < typeArr.length; i++) {
            add(typeArr[i]);
        }
        return typeArr.length != 0;
    }

    public void clear() {
        arr = (E[]) (new Object[defaultSize]);
    }

    public boolean contains(E e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<E> c) {
        E[] typeArr = (E[]) c.toArray();
        for (int i = 0; i < typeArr.length; i++) {
            if (!contains(typeArr[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return arr.hashCode();
    }

    public boolean isEmpty() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean remove(E e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[i] = arr[i + 1];
                }
                arr = Arrays.copyOf(arr, arr.length - 1);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return arr.length;
    }
}