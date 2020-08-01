public class MySet <E> extends MyCollection<E>{
    public MySet() {
        super();
    }

    public MySet(int size) {
        super(size);
    }

    public boolean add(E element) {
        if (getCapacity() == size()) {
            resize();
        }
        boolean successful = false;
        if (!contains(element)) {
            setElementAtIndex(getCapacity(), element);
            setCapacity(getCapacity() + 1);
            successful = true;
        }
        return successful;
    }

    public Object[] toArray() {
        return getExpansiveArray();
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(MySet<E> set) {
        boolean addingAllSuccessful = false;
        for(Object element: set.getExpansiveArray()) {
            addingAllSuccessful = add((E) element);
        }
        return addingAllSuccessful;
    }

    @SuppressWarnings("unchecked")
    public boolean containsAll(MySet<E> set) {
        boolean containsAllSuccessful = false;
        for(Object element: set.getExpansiveArray()) {
            containsAllSuccessful = contains((E) element);
        }
        return containsAllSuccessful;
    }

    @SuppressWarnings("unchecked")
    public boolean removeAll(MySet<E> set) {
        boolean removingAllSuccessful = false;

        for(Object element: set.getExpansiveArray()) {
            removingAllSuccessful = removeElement((E) element) != (E) new Object();
        }
        return removingAllSuccessful;
    }

    @SuppressWarnings("unchecked")
    public boolean retainAll(MySet<E> set) {
        int count = 0;
        for(Object element: set.getExpansiveArray()) {
            if(!contains((E) element)) {
               removeElement((E) element);
               count++;
            }
        }
        return getCapacity() == count;
    }

    public boolean equals(Object object) {
        boolean theSame = false;
        if(object instanceof MySet && super.size() == ((MySet) object).size()) {
           theSame = true;
        }
        return theSame;
    }



}
