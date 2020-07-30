import java.util.*;

public class MyMap<K, V> {

    private MyArrayList<K> mapKeys = new MyArrayList<>();
    private MyArrayList<V> mapValues = new MyArrayList<>();

    public void clear() {
        mapKeys = new MyArrayList<>();
        mapValues = new MyArrayList<>();
    }

    public boolean containsKey(Object key) {
        return mapKeys.contains(key);
    }

    public boolean containsValue(Object value) {
        return mapValues.contains(value);
    }

    public Set<MyMapEntry<K, V>> entrySet() {
        Set<MyMapEntry<K, V>> set = new LinkedHashSet<>();
        for(int i = 0; i < mapKeys.size(); i++) {
            set.add(new MyMapEntry<>(mapKeys.get(i), mapValues.get(i)));
        }
        return set;
    }

    public V get(Object key) {
        int objectIndex = mapKeys.indexOf(key);
        if(objectIndex != -1)
            return mapValues.get(objectIndex);
        return null;
    }

    public boolean isEmpty() {
        return mapKeys.isEmpty();
    }

    public Set<K> keySet() {
        Set<K> set = new LinkedHashSet<>();
        for(int i = 0; i < mapKeys.size(); i++) {
            set.add(mapKeys.get(i));
        }
        return set;
    }

    public V put(K key, V value) {
        V previous = null;
        if(!mapKeys.contains(key)) {
            mapKeys.add(key);
            mapValues.add(value);
        } else {
            previous = get(key);
            mapValues.set(mapKeys.indexOf(key), value);
        }
        return previous;
    }

    public void putAll(Map<? extends K,? extends V> m) {
        for(Map.Entry<? extends K,? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object key) {
        V previous = null;

        if(mapKeys.contains(key)) {
            previous = get(key);
            mapValues.remove(mapKeys.indexOf(key));
            mapKeys.remove(key);
        }

        return previous;
    }

    public int size() {
        return mapKeys.size();
    }

    public Collection<V> values() {
        return mapValues;
    }

}

class MyMapEntry<K, V> {

    K key;
    V value;

    MyMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
