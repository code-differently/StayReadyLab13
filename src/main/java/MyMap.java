import java.util.Arrays;

public class MyMap<K, V> {

    private K [] key  = (K[])new Object[10];
    private V [] value  = (V[])new Object[10];
    private int size = 0;

    public void clear(){
        size = 0;
        key = Arrays.copyOf(key, size);
        value = Arrays.copyOf(value, size);
    }

    public boolean isEmpty(){

        return size == 0 || key[0] == "" || key[0] == null;
    }

    public int size(){

        return size;
    }

    public V get(K k) throws ArrayIndexOutOfBoundsException {
            return value[indexOf(k)];
    }

    public void  put(K k, V v) throws ArrayIndexOutOfBoundsException {
        if(containsKey(k)){
            value[indexOf(k)] = v;
        }else {
            key[size] = k;
            value[size] = v;
            size++;
        }
    }

    public void remove(K k){
        if(containsKey(k)) {
            for(int i = indexOf(k); i < key.length-1; i++) {
                key[i] = key[i + 1];
                value[i] = value[i + 1];
                i++;
            }
            size--;
            key = Arrays.copyOf(key, size);
            value = Arrays.copyOf(value, size);
        }
    }

    public boolean containsKey(K k) {
        return indexOf(k) != -1;
    }

    public boolean containsValue(V v) {
        return indexOf(v) != -1;
    }

    private int indexOf(Object k){
        for(int i = 0; i < key.length; i++){
            if(key[i] == k){
                return i;
            }
        }
        return -1;
    }

    public String getMap(){
        String output = "";
        key = Arrays.copyOf(key, size);
        value = Arrays.copyOf(value, size);
        for(int i = 0; i < key.length; i++){
            output+= key[i]+"="+value[i]+" ";
        }
        return output.trim();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyMap<?, ?> myMap = (MyMap<?, ?>) o;
        return Arrays.equals(key, myMap.key) &&
                Arrays.equals(value, myMap.value);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(key);
        result = 31 * result + Arrays.hashCode(value);
        return result;
    }


}
