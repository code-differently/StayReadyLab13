import java.util.Arrays;
import java.util.stream.IntStream;

public class MyMap <K, V> {
    //the keys and the values will be synced up via indexes
    private MySet<K> keys;
    private MySet<V> values;

    public MyMap() {
        keys = new MySet<>();
        values = new MySet<>();
    }

//    public MyMap(MyMap<K, V> map) {
//        keys = new MySet<>(size);
//        values = new MySet<>(size);
//    }

    public int size() {
        return keys.getCapacity(); //how many keys are stored, not the size, which would be 1
    }

    public boolean isEmpty() {
        return keys.getCapacity() == 0;
    }

    @SuppressWarnings("unchecked")
    public boolean containsKey(Object element) {
        return keys.contains((K) element);
    }

//    public void clear() {
//        expansiveArray = new Object[size];
//    }
//
//    @SuppressWarnings("unchecked")
//    public E remove(int index) {
//        E elementAtIndex = (E) expansiveArray[index];
//        expansiveArray[index] = (E) new Object();
//        return elementAtIndex;
//    }
//
//    @SuppressWarnings("unchecked")
//    public E removeElement(E element) {
//        boolean elementExists = contains(element);
//        E elementAtIndex = (E) new Object();
//        if(elementExists) {
//            int firstOccurrenceOfElement =
//                    IntStream.range(0, expansiveArray.length)
//                            .filter(i -> element ==  expansiveArray[i])
//                            .findFirst() // first occurrence
//                            .orElse(-1); // No element found
//            if(firstOccurrenceOfElement != -1) {
//                elementAtIndex = (E) expansiveArray[firstOccurrenceOfElement];
//                remove(firstOccurrenceOfElement);
//            }
//        }
//        return elementAtIndex;
//    }
//
//    public Object[] getExpansiveArray() {
//        return expansiveArray;
//    }
//
//    public void setExpansiveArray(Object[] array) {
//        expansiveArray = array;
//    }
//
//    @SuppressWarnings("unchecked")
//    public E getElementAtIndex(int index) {
//        return (E) expansiveArray[index];
//    }
//
//    public void setElementAtIndex(int index, E element) {
//        expansiveArray[index] = element;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
}

