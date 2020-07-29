import java.util.Arrays;

public class MySet<V> {

    private V [] set = (V[])new Object[10];
    private int size = 0;

    public void add(V v){
        if(!contains(v)) {
            if(size == set.length){
                size+=10;
                set = Arrays.copyOf(set, size);
                size -= 10;
            }
            set[size] = v;
            size++;
        }
    }

    public void remove(V v){
        if(contains(v)) {
            for(int i = indexOf(v); i < set.length-1; i++) {
                set[i] = set[i + 1];
                i++;
            }
            size--;
            set = Arrays.copyOf(set, size);
        }
    }
    private int indexOf(V v){
        for(int i = 0; i < set.length; i++){
            if(set[i] == v){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(V v){
        for(int i = 0; i < set.length; i++){
            if(set[i] == v){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        size = 0;
        set = Arrays.copyOf(set, size);
    }

    public boolean isEmpty(){

        return set[0] == "" || set[0] == null;
    }

    public int size(){

        return size;
    }

    public V[] toArray(){
        set = Arrays.copyOf(set, size);
        return set;
    }

    public String getSet(){
        String output = " ";
        set = Arrays.copyOf(set, size);
        for(int i = 0; i < set.length; i++) {
            output += set[i] + " ";
        }

        return output.trim();
    }
}
