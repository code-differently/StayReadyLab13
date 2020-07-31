import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MyMap <K,V>
{

    private MyArrayList<K> keyStorage = new MyArrayList<>();
    private MyArrayList<V> valueStorage = new MyArrayList<>();
    public MyMap()
    {

    }

    public void clear()
    {
        keyStorage.clear();
        valueStorage.clear();
    }

    public K put(K key,V value)
    {
        if (!keyStorage.contains(key))
        {
            keyStorage.add(key);
            valueStorage.add(value);
        }
        else
        {
            Object [] getKeyArray = keyStorage.toArray();
            for (int i = 0; i < getKeyArray.length;i++)
            {
                if (getKeyArray[i] == key)
                {
                    valueStorage.set(i, value);
                }
            }
        }
        
        
        return key;
    }

    public V get(K obj)
    {
        Object [] getKeyArray = keyStorage.toArray();
        for (int i = 0; i < getKeyArray.length;i++)
        {
            if (getKeyArray[i] == obj)
            {
                return valueStorage.get(i);
            }
        }
        return null;
    }

    public int size()
    {
        return keyStorage.size();
    }

    public boolean containsKey(K key)
    {
        if (keyStorage.contains(key))
        {
            return true;
        }
        return false;
    }

    public boolean containsValue(V value)
    {
        if (valueStorage.contains(value))
        {
            return true;
        }
        return false;
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    public Set<MyMapEntry<K,V>> entrySet()
    {
        Set<MyMapEntry<K,V>> set = new LinkedHashSet<>();
        for (int i = 0; i < keyStorage.size();i++)
        {
            set.add(new MyMapEntry<K,V>(keyStorage.get(i), valueStorage.get(i)));
        }
        return set; 
    }

    public Set<K> keySet()
    {
        Set<K> set = new LinkedHashSet<>();
        for (int i = 0; i < keyStorage.size();i++)
        {
            set.add(keyStorage.get(i));
        }
        return set; 
    }

    public boolean isEmpty()
    {
        if (keyStorage.isEmpty())
        {
            return true;
        }
        return false;
    }


    public boolean equals(Object obj)
    {
        if (obj instanceof Map)
        {
            if (((Map)obj).size() == this.size())
            {
              return keyStorage.containsAll(((Map)obj).keySet());
            }
        }
        return false;
    }
    

    public void putAll(Map<? extends K,? extends V> m)
    {
        for (Map.Entry<? extends K,? extends V> getEntry : m.entrySet())
        {
            put(getEntry.getKey(), getEntry.getValue());
        }
    }

    public V remove(Object obj)
    {
        Object getValue = get((K)obj);
        keyStorage.remove((K)obj);
        valueStorage.remove((V)obj);

        return (V)getValue;

    }

    public Collection<V> values()
    {
        return valueStorage;
    }

    








    
}

class MyMapEntry<K,V>
    {
        K key;
        V value;

        public MyMapEntry(K key, V value) 
        {
            this.key = key;
            this.value = value;
        }

        public K getKey() 
        {
            return key;
        }

        public V getValue() 
        {
            return value;
        }

        public String toString() 
        {
            return getKey() + "=" + getValue();
        }
    }