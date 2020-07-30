import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

public class MapTest
{
    @Test
    public void testSize()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);

        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testIsEmpty()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);

        Assert.assertEquals(false, map.isEmpty());
    }

    @Test
    public void testContainsKey()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);

        Assert.assertEquals(true, map.containsKey(1));
    }

    @Test
    public void testContainsValue()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);

        Assert.assertEquals(true, map.containsValue(2));
    }

    @Test
    public void testGet()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);

        Assert.assertEquals(2, map.get(1));
    }

    @Test
    public void testPut()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);

        Assert.assertNotNull(map);
    }

    @Test
    public void testRemove()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.remove(1);

        Assert.assertEquals(true, map.isEmpty());
    }

    @Test
    public void testClear()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.put(2, 43);
        map.put(3, 393);

        map.clear();
        Assert.assertEquals(true, map.isEmpty());
    }

    @Test
    public void testKeySet()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.put(2, 43);
        map.put(3, 393);

        Set<Integer> sets = map.keySet();

        Assert.assertEquals(3, sets.size());
    }

    @Test
    public void testValues()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.put(2, 43);
        map.put(3, 393);

        Collection c = map.values();
        Assert.assertEquals(3, c.size());
    }

    @Test
    public void testEntrySet()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.put(2, 43);
        map.put(3, 393);

        Set<Integer> s = map.entrySet();

        Assert.assertNotNull(s);
    }

    @Test
    public void testPutAll()
    {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.put(2, 43);
        map.put(3, 393);

        MyMap<Integer, Integer> map2 = new MyMap<>();
        map.put(4, 2);
        map.put(5, 43);
        map.put(6, 393);

        map.putAll(map2);

        Assert.assertEquals(6, map.size());
    }

}
