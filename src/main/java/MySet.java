import java.util.Collection;
import java.util.Iterator;

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

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return expansiveArray.length > index;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                E element = (E) expansiveArray[index];
                index++;
                return element;
            }
        };
    }

    public Object[] toArray() {
        return expansiveArray;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean addingAllSuccessful = false;
        for(E element: collection) {
            addingAllSuccessful = add(element);
        }
        return addingAllSuccessful;
    }

    public boolean containsAll(Collection<? extends E> collection) {
        boolean containsAllSuccessful = false;
        for(E element: collection) {
            containsAllSuccessful = contains(element);
        }
        return containsAllSuccessful;
    }

    @SuppressWarnings("unchecked")
    public boolean removeAll(Collection<? extends E> collection) {
        boolean removingAllSuccessful = false;

        for(E element: collection) {
            removingAllSuccessful = removeElement(element) != (E) new Object();
        }
        return removingAllSuccessful;
    }

    public boolean retainAll(Collection<? extends E> collection) {
        int count = 0;
        for(E element: collection) {
            if(!contains(element)) {
               removeElement(element);
               count++;
            }
        }
        return capacity == count;
    }

    public boolean equals(Object object) {
        boolean theSame = false;
        if(object instanceof MySet && super.size() == ((MySet) object).size()) {
           theSame = true;
        }
        return theSame;
    }



}
