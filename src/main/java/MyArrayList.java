import java.util.function.Predicate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class MyArrayList<T> {
    private Object[] array;
    private int realSize;

    public MyArrayList(){
        array = new Object[10];
        realSize = 0;
    }

    public MyArrayList(int initialSize){
        array = new Object[initialSize];
        realSize = 0;
    }

    public void add(T element){
        if(isFull())
            resize();
        
        array[realSize] = element;
        realSize++;
    }

    private boolean isFull(){
        return (realSize == array.length);
    }

    public void add(int index, T element){
            
        if(index > realSize)
            System.out.println("Index out of bounds, element NOT added");
        else{
            if(isFull())
                resize();

            Object[] temp = new Object[(array.length - index)];
            int newIndex = index;
            for(int i = 0; i < temp.length; i++){
                temp[i] = array[newIndex];
                newIndex++;
            }

            array[index] = element;
            newIndex--;
            for(int i = temp.length - 2; i >= 0; i--){
                array[newIndex] = temp[i];
                newIndex--;
            }

            realSize++;
        }
    }

    public void addAll(T[] arr){
        if(isFull())
            resize();

        for(T num: arr){
            array[realSize] = num;
            realSize++;

            if(isFull())
                resize();
        }
    }

    public void addAll(int index, T[] arr){

        if(index > realSize)
            System.out.println("Index out of bounds, elements NOT added");
        else{
            if(isFull())
                resize();

            for(int i = 0; i < arr.length; i++){

                array[index] = arr[i];
                index++;

                if(index > realSize)
                    realSize++;

                if(isFull())
                    resize();
            }
        }
    }

    public void clear(){

        Object[] emptyArray = new Object[10];
        array = emptyArray;

        realSize = 0;
    }

    @SuppressWarnings("unchecked")
    public T[] clone(){
        Object[] clonedArray = new Object[array.length];

        for(int i = 0; i < realSize; i++){
            clonedArray[i] = array[i];
        }

        return (T[])clonedArray;
    }

    public boolean contains(T element){

        for(Object num: array){
            if(((T)num) == element)
                return true;
        }
        return false;
    }

    public int ensureCapacity(int capacity){
        while(array.length < capacity){
            resize();
        }

        return array.length;
    }

    public T get(int index){
        if(index < realSize)
            return (T) array[index];
        else
            System.out.println("Element could not be found.");

        return null;
    }

    public int indexOf(T element){
        if(contains(element)) {
            for (int i = 0; i < realSize; i++) {
                if((T)array[i] == element)
                    return i;
            }
        }
        else
            System.out.println("Element could not be found.");

        return -1; //returns -1, because it can never be an index number
    }

    public boolean isEmpty(){
        if(realSize == 0)
            return true;

        return false;
    }

    public Iterator<T> iterator(){
        return null;
    }

    public int lastIndexOf(T element){
        int index = 0;

        if(contains(element)){
            for(int i = 0; i < realSize; i++){
                if((T)array[i] == element)
                    index = i;
            }
            return index;
        }
        return -1; //returns -1, because it can never be an index number
    }

    public ListIterator<T> listIterator(){
        return null;
    }

    public ListIterator<T> listIterator(int position){
        return null;
    }

    public T remove(int index){

        if(index < realSize){
            Object[] temp = new Object[array.length];
            Object removed = null;
            int j = 0;

            for(int i = 0; i < realSize; i++){
                if(i == index){
                    removed = array[i];
                    realSize--;
                    j++;
                }

                temp[i] = array[j];
                j++;
            }

            array = temp;
            return (T)removed;
        }

        return null;
    }

    public boolean remove(T element){

        if(contains(element)){
            Object[] temp = new Object[array.length];
            int j = 0;

            for(int i = 0; i < realSize; i++){
                if(array[i] == element){
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

            while(contains(elementToRemove)) {
                remove(elementToRemove);
                elementsRemoved = true;
            }
        }

        return elementsRemoved;
    }

    @SuppressWarnings("unchecked")
    public void removeIf(Predicate<T> condition){

        for(int i = 0; i < realSize;i++){
            Object element = array[i];
            if(condition.test((T) element)) {
                remove(i);
                i--;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void removeRange(int startIndex, int endIndex){

        if(startIndex < realSize && endIndex < realSize){
            for(int i = startIndex; i < endIndex; i++){
                Object current = array[startIndex];
                remove((T) current);
            }
        }
    }

    public void replaceAll(UnaryOperator<T> operation){

        for(int i = 0; i < realSize; i++){
            array[i] = (operation.apply((T) array[i]));
        }
    }

    @SuppressWarnings("unchecked")
    public void retainAll(T[] elements){

        Object[] temp = new Object[array.length];

        for(int i = 0; i < realSize; i++){

            while(contains(elements[i])){
                Object current = array[indexOf((T) elements[i])];
                temp[i] = current;
                remove((T) current);
            }
        }

        array = temp;
    }

    public T set(int index, T element){
        return null;
    }

    public int size(){
        return realSize;
    }

    public T[] sublist(int startIndex, int endIndex){
        return null;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        Object[] temp = Arrays.copyOf(array, realSize);
        return (T[]) temp;
    }

    public T[] toArray(T[] elements){
        return null;
    }

    public void trimToSize(){

    }

    private void resize(){ //resize by 10
        Object[] newArray = new Object[size() + 10];

        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }
}