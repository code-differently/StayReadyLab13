import java.util.Collection;

public class MySet <E> extends MyCollection<E> implements Collection<E> {
    public MySet() {
        super();
    }

    public MySet(int size) {
        super(size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean add(Object element) {
        if (getCapacity() == size()) {
            resize();
        }
        boolean successful = false;
        if (!contains(element)) {
            setElementAtIndex(getCapacity(), (E) element);
            setCapacity(getCapacity() + 1);
            successful = true;
        }
        return successful;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object object) {
        return super.removeElement((E) object);
    }

    @Override
    public boolean contains(Object object) {
        return super.contains(object);
    }

    @Override
    public Object[] toArray() {
        return getExpansiveArray();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) getExpansiveArray();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection collection) {
        boolean addingAllSuccessful = false;
        for(Object element: collection) {
            addingAllSuccessful = add((E) element);
        }
        return addingAllSuccessful;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean containsAllSuccessful = false;
        for(Object element: collection) {
            containsAllSuccessful = contains((E) element);
        }
        return containsAllSuccessful;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean removingAllSuccessful = false;

        for(Object element: collection) {
            removingAllSuccessful = removeElement((E) element);
        }
        return removingAllSuccessful;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(Collection<?> collection) {
        int count = 0;
        for(Object element: collection) {
            if(!contains((E) element)) {
               removeElement((E) element);
               count++;
            }
        }
        return getCapacity() == count;
    }

    @Override
    public boolean equals(Object object) {
        boolean theSame = false;
        if(object instanceof MySet && super.size() == ((MySet) object).size()) {
           theSame = true;
        }
        return theSame;
    }
}
