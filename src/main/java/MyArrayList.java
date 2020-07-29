import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> {
    private T type;
    private int lastIndex;
    private T[] arr;
    private int size;
    private int defaultSize = 0;

    public MyArrayList() {
        this.type = (T) (new Object());
        this.arr = (T[]) (new Object[defaultSize]);
        this.lastIndex = defaultSize - 1;
    }

    public MyArrayList(int size) {
        this();
        this.arr = (T[]) (new Object[size]);
        this.lastIndex = size - 1;
    }

    //Appends the specified element to the end of this list
    public boolean add(T t) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[lastIndex + 1] = t;
        lastIndex++;
        return true;
    }

    // Inserts the specified element at the specified position in this list
    public void add(int index, T t) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = t;
        lastIndex++;
    }

    // Appends all of the elements in the specified collection to the end of this list
    // in the order that they are returned by the specified collection's Iterator
    public boolean addAll(Collection<T> c) {
        T[] typeArr = (T[]) c.toArray();
        for (int i = 0; i < typeArr.length; i++) {
            add(typeArr[i]);
        }
        return typeArr.length != 0;
    }

    // Inserts all of the elements in the specified collection into this list, starting at the specified position
    public boolean addAll(int index, Collection<T> c) {
        T[] typeArr = (T[]) c.toArray();
        for (T elem : typeArr) {
            add(index, elem);
            index++;
        }
        return typeArr.length != 0;
    }

    // Returns the element at the specified position in this list
    public T get(int i) {
        return arr[i];
    }

    // Removes the element at the specified position in this list
    public T remove(int index) {
        T elementRemoved = arr[index];
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr = Arrays.copyOf(arr, arr.length - 1);
        lastIndex--;
        return elementRemoved;
    }

    // Returns the number of elements in this list
    public int size() {
        return arr.length;
    }

}
