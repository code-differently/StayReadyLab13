import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class MyMap<K, V> {

    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);

        System.out.println(map.values());
    }

    private Object[] keys;
    private Object[] values;
    private int realSizeKeys;
    private int realSizeValues;

    public MyMap(){
        keys = new Object[16];
        values = new Object[16];
        realSizeKeys = 0;
        realSizeValues = 0;
    }

    public MyMap(int initialSize){
        keys = new Object[initialSize];
        values = new Object[initialSize];
        realSizeKeys = 0;
        realSizeValues = 0;
    }

    public void clear(){

        Object[] emptyKeys = new Object[16];
        Object[] emptyValues = new Object[16];
        keys =  emptyKeys;
        values = emptyValues;

        realSizeKeys = 0;
        realSizeValues = 0;
    }

    public boolean containsKey(K key){
        for(Object k: keys){
            if(k == key)
                return true;
        }

        return false;
    }

    public boolean containsValue(V value){
        for(Object v: values){
            if(v == value)
                return true;
        }

        return false;
    }

    public void put(K key, V value){
        if(containsKey(key) == false){
            keys[realSizeKeys] = key;
            values[realSizeValues] = value;

            realSizeKeys++;
            realSizeValues++;
        }
        else{
            int valIndex = getValIndex(key);  //returns index of that value
            values[valIndex] = value;
        }
    }

    public V get(K key){
        int valInd = getValIndex(key);

        return (V)values[valInd];
    }

    private int getValIndex(K key){
        int index = 0;

        for(int i = 0; i < realSizeKeys; i++){
            Object currentKey = keys[i];

            if(currentKey == key)
                index = i;
        }

        return index;
    }  //private helper method

     //this implementation will return a string of the entries
    public String entrySet(){

        String entrySet = "[";
        int index;
        K currentKey;
        V currentValue;

        if(realSizeKeys != 1 && realSizeValues != 1) {
            for (index = 0; index < realSizeKeys - 1; index++) {
                currentKey = (K) keys[index];
                currentValue = get(currentKey);

                if (currentValue != null)
                    entrySet += (currentKey + "=" + currentValue + ", ");

            }

            currentKey = (K) keys[index];
            currentValue = get(currentKey);

            if (currentValue != null)
                entrySet += (currentKey + "=" + currentValue + "]");
        }
        else
            entrySet += (keys[0] + "=" + values[0] + "]");
        return entrySet;
    }

    public boolean equals(Object object){
        return false;
    }

    public int hashCode(){
        return 0;
    }

    public boolean isEmpty(){
        if(realSizeValues == 0)
            return true;

        return false;
    }

    public String keySet(){
        String keySet = "[";
        int index;
        K currentKey;

        for(index = 0; index < realSizeKeys - 1; index++){
            currentKey = (K) keys[index];

            keySet += (currentKey + ", ");
        }

        currentKey = (K) keys[index];
        keySet += (currentKey + "]");

        return keySet;
    }

    public V getOrDefault(K key, V defaultValue){
        if(get(key) != null)
            return get(key);

        return defaultValue;
    }

    public void putAll(MyMap<K, V> copyMap){
        K[] copyMapKeys = copyMap.getKeys();
        V[] copyValueKeys = copyMap.getValues();

        for(int i = 0; i < getKeysSize(); i++){
            put(copyMapKeys[i], copyValueKeys[i]);
        }
    }

    public V putIfAbsent(K key, V value){
        if(get(key) == null) {
            put(key, value);
            return null;
        }

        return get(key);
    }

    private K[] getKeys(){
        return (K[]) keys;
    }

    private V[] getValues(){
        return (V[]) values;
    }

    private int getKeysSize(){
        return realSizeKeys;
    }

    public V remove(K key){
        int valIndex = getValIndex(key);
        V oldValue = (V) values[valIndex];

        values[valIndex] = null;

        return oldValue;
    }

    public boolean remove(K key, V value){
        if(get(key) != null){
            Object[] tempKeys = new Object[keys.length];
            Object[] tempValues = new Object[values.length];
            int j = 0;

            for(int i = 0; i < realSizeKeys; i++){
                if(keys[i] == key && values[i] == value) {
                    realSizeValues--;
                    realSizeKeys--;
                    j++;
                }

                tempKeys[i] = keys[j];
                tempValues[i] = values[j];
                j++;
            }

            keys = tempKeys;
            values = tempValues;

            return true;
        }

        return false;
    }

    public V replace(K key, V value){
        if(containsKey(key)){
            V prevValue = get(key);

            if(get(key) != null) {
                put(key, value);
                return prevValue;
            }

            return null;
        }

        return null;
    }

    public boolean replace(K key, V oldValue, V newValue){

        if(containsKey(key) && get(key) ==  oldValue) {
            replace(key, newValue);
            return true;
        }

        return false;
    }

    public int size(){
        return realSizeValues; //my implementation will not allow null keys, so number of values is the number of mappings
    }

    public String values(){
        String valuesString = "[";
        int index;
        K currentKey;
        V currentValue;

        if(realSizeValues != 1){
            for (index = 0; index < realSizeKeys - 1; index++) {
                currentKey = (K) keys[index];
                currentValue = get(currentKey);

                if (currentValue != null)
                    valuesString += (currentValue + ", ");

            }

            currentKey = (K) keys[index];
            currentValue = get(currentKey);

            if (currentValue != null)
                valuesString += (currentValue + "]");
        }
        else
            valuesString += (values[0] + "]");

        return valuesString;
    }
}