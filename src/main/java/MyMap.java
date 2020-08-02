import java.util.Arrays;

public class MyMap <K, V> {
    //the keys and the values will be synced up via indexes
    //chose MySet because keys need to be unique
    private MySet<K> keys;
    private MySet<V> values;

    public MyMap() {
        keys = new MySet<>();
        values = new MySet<>();
    }

    public MyMap(MyMap<K, V> map) {
        keys = new MySet<>();
        values = new MySet<>();
        putAll(map);
    }

    public void putAll(MyMap<K, V> map) {
        MySet<K> incomingKeys = map.keySet();
        MySet<V> incomingValues = map.values();
        keys.addAll(incomingKeys);
        values.addAll(incomingValues);
    }

    public int size() {
        return keys.getCapacity(); //how many keys are stored, not the size, which would be 1
    }

    public boolean isEmpty() {
        return keys.getCapacity() == 0;
    }

    @SuppressWarnings("unchecked")
    public boolean containsKey(Object element) {
        return keys.contains((K) element);
    }

    @SuppressWarnings("unchecked")
    public boolean containsValue(Object element) {
        return values.contains((V) element);
    }

    public void clear() {
        keys.clear();
        values.clear();
    }

    public void put(K key, V value) {
        keys.add(key);
        values.add(value);
    }

    @SuppressWarnings("unchecked")
    public V get(Object key) {
        int indexOfKey = findElementIndex((K) key);
        return values.getElementAtIndex(indexOfKey);
    }

    private int findElementIndex(K element) {
        return Arrays.asList(keys.getExpansiveArray()).indexOf(element);
    }

    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        K castedKey = (K) key;
        int indexOfPair = findElementIndex(castedKey);
        V value = values.getElementAtIndex(indexOfPair);
        keys.removeElement(castedKey);
        values.removeElement(value);
        return value;
    }

    public MySet<K> keySet() {
        return keys;
    }

    public MySet<V> values() {
        return values;
    }
}

