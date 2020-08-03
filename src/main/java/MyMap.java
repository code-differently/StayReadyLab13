import java.util.Arrays;

public class MyMap<K, V> {

    private K[] key;
    private V[] value;

    public MyMap() {
        key = (K[]) (new Object[0]);
        value = (V[]) (new Object[0]);
    }

    public void put(K k, V v) {
        if (!containsKey(k)) {
            key = Arrays.copyOf(key, key.length + 1);
            value = Arrays.copyOf(value, value.length + 1);
            key[key.length - 1] = k;
            value[value.length - 1] = v;
        }
        else {
            for (int i = 0; i < key.length; i++) {
                if (key[i].equals(k))
                    value[i] = v;
            }
        }
    }

    public void remove(K k) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(k)) {
                for (int j = i; j < key.length - 1; j++) {
                    key[i] = key[i + 1];
                    value[i] = value[i + 1];
                }
                key = Arrays.copyOf(key, key.length - 1);
                value = Arrays.copyOf(value, value.length - 1);
            }
        }
    }

    public boolean containsKey(K k) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(k)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V v) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(v)) {
                return true;
            }
        }
        return false;
    }

    public V get(K k) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(k)) {
                return value[i];
            }
        }
        return null;
    }

    public boolean equals(K[] k, V[] v) {
        for (int i = 0; i < key.length; i++) {
            if (k[i] == null || v[i] == null || key[i] != k[i] || value[i] != v[i])
                return false;
        }
        return true;
    }

    public int hashCode() {
        return key.hashCode();
    }

    public boolean isEmpty() {
        for (int i = 0; i < key.length; i++) {
            if (key[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        key = (K[]) (new Object[0]);
        value = (V[]) (new Object[0]);
    }

    public int size() {
        return key.length;
    }

}
