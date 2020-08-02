import java.util.Arrays;
import java.util.Collection;

public class MyMap<E, E2> {
    private E[] key;
    private E2[] value;

    public MyMap() {
        key = (E[]) (new Object[0]);
        value = (E2[]) (new Object[0]);
    }

    public void clear() {
        key = (E[]) (new Object[0]);
        value = (E2[]) (new Object[0]);
    }

    public boolean containsKey(E e) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(E2 e) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<E> c) {
        E[] typeArr = (E[]) c.toArray();
        for (int i = 0; i < typeArr.length; i++) {
            if (!containsKey(typeArr[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }

    public E2 get(E e) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(e)) {
                return value[i];
            }
        }
        return null;
    }

    public boolean isEmpty() {
        for (int i = 0; i < key.length; i++) {
            if (key[i] != null) {
                return false;
            }
        }
        return true;
    }

    public E2 put(E e, E2 e2) {
        if (!containsKey(e)) {
            key = Arrays.copyOf(key, key.length + 1);
            value = Arrays.copyOf(value, value.length + 1);
            key[key.length - 1] = e;
            value[value.length - 1] = e2;
        } else {
            for (int i = 0; i < key.length; i++) {
                if (key[i].equals(e)) {
                    value[i] = e2;
                }
            }
        }
        return e2;
    }

    public boolean putAll(MyMap<E, E2> map) {
        for (int i = 0; i < map.size(); i++) {
            put(map.key[i], map.value[i]);
        }
        return map.size() != 0;
    }

    public boolean remove(E e) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(e)) {
                for (int j = i; j < key.length - 1; j++) {
                    key[i] = key[i + 1];
                    value[i] = value[i + 1];
                }
                key = Arrays.copyOf(key, key.length - 1);
                value = Arrays.copyOf(value, value.length - 1);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return key.length;
    }

}
