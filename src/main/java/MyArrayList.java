import java.util.Arrays;

public class MyArrayList <T> {

    private T [] list;
    private int size;

    public MyArrayList(){

        list =(T[])new Object[10];
        size = 0;
    }

    public MyArrayList(int i){

        list =(T[])new Object[i];
        size = 0;
    }

    public void add(T t){

       ensureCapacity(size);
        list[size] = t;
        size++;
    }

    public void add(int index, T t){

        ensureCapacity(size);

        if(list[index] == null) {
            list[size] = t;
            size++;
        }
        else{
            for(int i = list.length-1; i > index; i--){
                list[i] = list[i-1];
            }
            list[index] = t;
            size++;
        }
    }


    public T get(int i){

       return list[i];
    }

    public void remove(T t){
        int i = indexOf(t);

        while(i < list.length-1) {
            list[i] = list[i + 1];
            i++;
        }
        size--;
        trimToSize();
    }

    public void remove(int i){
        while(i < list.length-1) {
            list[i] = list[i + 1];
            i++;
        }
        size--;
        trimToSize();
    }

    public void set(int i, T t){

        list[i] = t;
    }

    public void clear(){
        size = 0;
        trimToSize();
    }

    public boolean isEmpty(){

       return list[0] == "" || list[0] == null;
    }

    public Object[] toArray(){
        trimToSize();
        return list;
    }

    public int size(){

        return size;
    }

    public int indexOf(T t){
        for(int i = 0; i < list.length; i++){
            if(list[i] == t){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T t){
        int lIndex = -1;
        for(int i = 0; i < list.length; i++){
            if(list[i] == t){
                lIndex = i;
            }
        }
        return lIndex;
    }

    public Object clone(){
        MyArrayList<T> clone = new MyArrayList<>();
        clone.addAll(this);
        return clone;
    }

    public boolean contains(T t){
        for(int i = 0; i < list.length; i++){
            if(list[i] == t){
                return true;
            }
        }
        return false;
    }

    public String getList(){
        String output = " ";
        trimToSize();
        for(int i = 0; i < list.length; i++) {
            output += list[i] + " ";
        }

        return output.trim();
    }

    public void trimToSize(){
       list = Arrays.copyOf(list, size);
    }

    public void addAll(MyArrayList<T> list){
        T [] t = (T[]) list.toArray();
        for(int i = 0; i < t.length; i++) {
            add(t[i]);
        }
    }
    public void addAll(int index, MyArrayList<T> list){
        T [] t = (T[]) list.toArray();
        for(int i = 0; i < t.length; i++) {
            add(index + i, t[i]);
        }
    }

    public void removeAll(MyArrayList<T> list){
        T [] t= (T[]) list.toArray();
        for(int i = 0; i < t.length; i++) {
            remove(t[i]);
        }
    }

    public void retainAll(MyArrayList<T> list){
        T [] t = (T[]) toArray();
        for(int i = 0; i < size(); i++) {
            if(!list.contains(t[i])) {
                remove(t[i]);
                i = 0;
            }
        }
    }

    public MyArrayList<T> subList(int f, int s){
        MyArrayList<T> newList = new MyArrayList<>();
        while(f < s) {
            newList.add(list[f]);
            f++;
        }
        return newList;
    }

    public void removeRange(int f, int s){
        while(f < s) {
            remove(list[f]);
            s--;
        }
    }

    public void ensureCapacity(int min){
        if(size == list.length){
            size+=10;
            trimToSize();
            size -= 10;
        }
    }


}
