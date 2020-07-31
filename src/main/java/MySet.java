public class MySet <E> extends MyCollection<E>{
    public MySet() {
        super();
    }

    public MySet(int size) {
        super(size);
    }

    public boolean add(E element) {
        if (capacity == size) {
            resize();
        }
        boolean successful = false;
        if (!contains(element)) {
            expansiveArray[capacity] =  element;
            capacity++;
            successful = true;
        }
        return successful;
    }

}
