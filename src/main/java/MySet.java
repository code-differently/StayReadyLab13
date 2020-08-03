import java.util.Arrays;
import java.util.Collection;

public class MySet<E> {

    private E[] arr;
    private int initialSize = 0;

    public MySet() {
        this.arr = (E[]) (new Object[initialSize]);
    }

    public MySet(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size can't be less than 0!");
        this.arr = (E[]) new Object[size];
    }

    public void add(E e) {
        if (contains(e)) {
            throw new IllegalArgumentException("Element already in set!");
        }
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = e;
    }

    public void addAll(Collection<E> c) {
        E[] collectionArr = (E[]) c.toArray();
        for (int i = 0; i < collectionArr.length; i++) {
            add(collectionArr[i]);
        }
    }

    public void remove(E e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[i] = arr[i + 1];
                }
                arr = Arrays.copyOf(arr, arr.length - 1);
            }
        }
    }

    public void clear() {
        this.arr = (E[]) (new Object[initialSize]);
    }

    public int size() {
        return arr.length;
    }

    public int hashCode() {
        return arr.hashCode();
    }

    public boolean contains(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(E[] e) {
        for (int i = 0; i < arr.length; i++) {
            if (e[i] == null || arr[i] != e[i])
                return false;
        }
        return true;
    }

}
