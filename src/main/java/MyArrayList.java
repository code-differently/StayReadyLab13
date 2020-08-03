import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {

    private E[] arr;
    private int initialSize = 0;
    private int lastIndex;

    public MyArrayList() {
        this.arr = (E[]) (new Object[initialSize]);
        this.lastIndex = initialSize - 1;
    }

    public MyArrayList(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size can't be less than 0!");
        this.arr = (E[]) new Object[size];
        this.lastIndex = size - 1;
    }

    public void add(E e) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = e;
        lastIndex++;
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
                lastIndex--;
            }
        }
    }

    public void remove(int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr = Arrays.copyOf(arr, arr.length - 1);
        lastIndex--;
    }

    public void set(int index, E item) {
        arr[index] = item;
    }

    public E get(int i) {
        return arr[i];
    }

    public int size() {
        return arr.length;
    }

    public void clear() {
        this.arr = (E[]) (new Object[initialSize]);
        this.lastIndex = 0;
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

}