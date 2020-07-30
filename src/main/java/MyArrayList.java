import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<T> implements Collection<T> {

    private T[] list;
    private int size = 0;

    public MyArrayList() {
        list = (T[])new Object[0];
    }

    public MyArrayList(int capacity) {
        list = (T[])new Object[capacity];
    }

    public boolean add(T element) {
        Object[] newList = Arrays.copyOf(list, list.length+1);
        newList[size++] = element;
        list = (T[])newList;
        return true;
    }

    public void add(int index, T element) {
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends T> c) {
        T[] newArray = Arrays.copyOf(list, size + c.size());
        Iterator<? extends T> iterator = c.iterator();
        while(size < newArray.length) {
            if(iterator.hasNext()) {
                newArray[size] = iterator.next();
                size++;
            }
        }
        list = newArray;
        return true;
    }

    public void clear() {
        list = (T[])new Object[0];
        size = 0;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object t : c) {
            if (!contains(t))
                return false;
        }
        return true;
    }

    public T get(int index) {
        return list[index];
    }

    public int indexOf(Object element) {
        for(int i = 0; i < size; i++) {
            if(list[i].equals(element))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() {
        return new MyIterator<>(this);
    }

    public int lastIndexOf(T element) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(element))
                return i;
        }
        return -1;
    }

    public T remove(int index) {
        T ret = null;
        T[] newList = Arrays.copyOf(list, list.length-1);
        for(int i = 0; i < list.length; i++) {
            if(!list[i].equals(list[index])) {
                newList[i] = list[i];
            } else {
                ret = list[i];
            }
        }
        list = newList; size--;
        return ret;
    }

    public boolean remove(Object element) {
        if(this.contains(element)) {
            int index = indexOf(element);
            size--;
            System.arraycopy(list, index + 1, list, index, size - index);
            list[size] = null;
            return true;
        }

        return false;
    }

    public boolean removeAll(Collection<?> c) {
        boolean setChanged = false;
        for(Object t : c) {
            if(contains(t)) {
                remove(t);
                setChanged = true;
            }
        }
        return setChanged;
    }

    public boolean retainAll(Collection<?> c) {
        boolean setChanged = false;
        for(int i = 0; i < size(); i++) {
            if(!c.contains(get(i))) {
                remove(get(i));
                setChanged = true;
            }
        }
        return setChanged;
    }

    public T set(int index, T element) {
        T ret = list[index];
        list[index] = element;
        return ret;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        return Arrays.copyOfRange(list, 0, size);
    }

    public <T> T[] toArray(T[] a) {
        T[] newArray = Arrays.copyOf(a, a.length + list.length);
        for(int i = newArray.length-a.length; i < newArray.length; i++) {
            newArray[i] = (T)list[i - a.length];
        }
        return newArray;
    }

}
