import java.util.Arrays;
import java.util.Iterator;

public class MySet<T> {
    private Object[] set;
    private int realSize;

    public MySet(){
        set = new Object[16];
        realSize = 0;
    }

    public MySet(int initialSize){
        set = new Object[initialSize];
        realSize = 0;
    }

    public void add(T element){
        if(isAtLoadFactor())
            resize();

        if(!(contains(element))) {
            set[realSize] = element;
            realSize++;
        }
    }

    public void addAll(T[] arr){
        if(isAtLoadFactor())
            resize();

        for(T num: arr){
            add(num);

            if(isAtLoadFactor())
                resize();
        }
    }

    public void clear(){

        Object[] emptySet = new Object[16];
        set = emptySet;

        realSize = 0;
    }

    public boolean contains(T element){

        for(Object num: set){
            if(((T)num) == element)
                return true;
        }
        return false;
    }

    public boolean containsAll(T[] elements){

        boolean allThere = false;

        for(T num: elements){
            if(contains(num))
                allThere = true;
            else
                allThere = false;
        }

        return allThere;
    }

    public boolean equals(Object object){
        return false;
    }

    public int hashCode(){
        return 0;
    }

    public boolean isEmpty(){
        if(realSize == 0)
            return true;

        return false;
    }

    public Iterator<T> iterator(){
        return null;
    }

    private T remove(int index){

        if(index < realSize){
            Object[] temp = new Object[set.length];
            Object removed = null;
            int j = 0;

            for(int i = 0; i < realSize; i++){
                if(i == index){
                    removed = set[i];
                    realSize--;
                    j++;
                }

                temp[i] = set[j];
                j++;
            }

            set = temp;
            return (T)removed;
        }

        return null;
    }

    public boolean remove(T element){

        if(contains(element)){
            Object[] temp = new Object[set.length];

            for(int i = 0; i < realSize; i++){
                if(set[i] == element){
                    remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean removeAll(T[] elements){
        boolean elementsRemoved = false;

        for(int i = 0; i < elements.length; i++){
            T elementToRemove = elements[i];

            if(contains(elementToRemove)) {
                remove(elementToRemove);
                elementsRemoved = true;
            }
        }

        return elementsRemoved;
    }

    private int indexOf(T element){
        if(contains(element)) {
            for (int i = 0; i < realSize; i++) {
                if((T)set[i] == element)
                    return i;
            }
        }
        else
            System.out.println("Element could not be found.");

        return -1; //returns -1, because it can never be an index number
    }

    @SuppressWarnings("unchecked")
    public boolean retainAll(T[] elements){

        Object[] temp = new Object[set.length];
        int j = 0;
        int tempRealSize = 0;
        boolean setChanged = false;

        for(int i = 0; i < elements.length; i++){

            if(contains(elements[i])){
                Object current = set[indexOf((T) elements[i])];
                temp[j] = current;
                tempRealSize++;
                remove((T) current);
                j++;

                setChanged = true;
            }
        }

        if(setChanged == true) {
            set = temp;
            realSize = tempRealSize;
        }

        return setChanged;
    }

    private boolean isAtLoadFactor(){
        return (realSize == (set.length * 0.75));
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        Object[] temp = Arrays.copyOf(set, realSize);
        return (T[]) temp;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] elements){
        for(T num: elements){
            add(num);
        }

        return toArray();
    }

    public int size(){
        return realSize;
    }

    private void resize(){ //resize by 16
        Object[] newSet = new Object[size() + 16];

        for(int i = 0; i < set.length; i++) {
            newSet[i] = set[i];
        }

        set = newSet;
    }
}