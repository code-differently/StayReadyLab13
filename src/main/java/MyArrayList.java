import java.lang.reflect.Array;

public class MyArrayList <E extends Comparable>{
    private E[] expansiveArray;

    @SuppressWarnings("unchecked")
    public MyArrayList(Class <E> myClass) {
        expansiveArray = (E[])  Array.newInstance(myClass, 0);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(Class <E> myClass, int size) {
        expansiveArray = (E[])  Array.newInstance(myClass, size);
//        int index = 0;
//        for(E element: expansiveArray) {
//            expansiveArray[index] = ;
//            index++;
//        }
    }

    public int size() {
        return expansiveArray.length;
    }

    public E get(int index) {
        return expansiveArray[index];
    }

    public E set(int index, E element) {
        E temp = expansiveArray[index];
        expansiveArray[index] = element;
        return temp;
    }

//    public void add(E element) {
//
//    }
}
