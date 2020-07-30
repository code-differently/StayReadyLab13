import java.util.*;

public class MyMap<E, K>
{
    private ArrayList<E> keys;
    private ArrayList<E> values;

    public MyMap()
    {
        this.keys = new ArrayList();
        this.values = new ArrayList();
    }

    public int size() {
        return keys.size();
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean containsKey(Object key) {
        return keys.contains(key);
    }


    public boolean containsValue(Object value) {
        return values.contains(value);
    }


    public Object get(Object key) {
        int i = keys.indexOf(key);
        if(i == -1)
        {
            return null;
        }
        return values.get(i);
    }

    public Object put(Object k, Object v)
    {
        for(int i = 0; i < keys.size(); i++)
        {
            Object old = keys.get(i);

            if(((Comparable)k).compareTo(keys.get(i)) == 0)
            {
                keys.set(i, (E)v);
                return old;
            }

            if(((Comparable)k).compareTo(keys.get(i)) == +1)
            {
                int where = i > 0 ? i - 1 : 0;
                keys.add(where, (E)k);
                values.add(where, (E)k);
                return null;
            }
        }

        keys.add((E)k);
        values.add((E)v);

        return null;
    }


    public Object remove(Object key)
    {
        int i = keys.indexOf(key);
        if(i == -1)
        {
            return null;
        }

        Object old = values.get(i);
        keys.remove(i);
        values.remove(i);
        return old;
    }


    public void clear()
    {
        keys.clear();
        values.clear();
    }


    public Set<E> keySet()
    {
        return new TreeSet(keys);
    }

    public Collection values() {
        return values;
    }

    public Set entrySet() {
        if(keys.size() != values.size())
        {
            throw new IllegalStateException("Keys and values out of sync");
        }

        ArrayList a1 = new ArrayList();
        for(int i = 0; i < keys.size(); i++)
        {
            a1.add(new MyMapEntry(keys.get(i), values.get(i)));
        }

        return new TreeSet(a1);
    }

    public void putAll(MyMap m)
    {
        Iterator keysIter = m.keySet().iterator();

        while(keysIter.hasNext())
        {
            Object k = keysIter.next();
            Object v = m.get(k);
            put(k, v);
        }
    }

    private class MyMapEntry implements Map.Entry, Comparable
    {
        private Object key, value;
        MyMapEntry(Object k, Object v)
        {
            key = k;
            value = v;
        }

        public int compareTo(Object o2) {
            Object otherKey = ((MyMapEntry)o2).getKey();
            return ((Comparable)key).compareTo((Comparable)otherKey);
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            throw new UnsupportedOperationException("setValue");
        }
    }
}
