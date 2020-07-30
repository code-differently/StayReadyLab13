import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {

    MyMap<Integer, Integer> map;

    @Before
    public void initialize(){
        map = new MyMap<>();
    }

    @Test
    public void clearTest() {
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.clear();
        Assert.assertEquals(true, map.isEmpty());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(true, map.isEmpty());
    }

    @Test
    public void sizeTest() {
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        Assert.assertEquals(4, map.size());
    }

    @Test
    public void getTest() {
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);

        Assert.assertEquals((Integer)2, map.get(3));
    }

    @Test
    public void putTest() {
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);

        Assert.assertEquals("1=1 2=1 3=1 4=1", map.getMap());
    }

    @Test
    public void putTest2() {
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(1, 2);
        Assert.assertEquals("1=2 2=1 3=1 4=1", map.getMap());
    }

    @Test
    public void removeTest() {
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);
        map.remove(3);

        Assert.assertEquals("1=4 2=3 4=1", map.getMap());
    }

    @Test
    public void containsKeyTest() {
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);
        assertEquals(true, map.containsKey(3));
    }

    @Test
    public void containsValueTest() {
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);

        assertEquals(true, map.containsValue(3));
    }

    @Test
    public void equalsTest() {
        MyMap<Integer, Integer> map2 = new MyMap<>();
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);
        map2.put(1, 4);
        map2.put(2, 3);
        map2.put(3, 2);
        map2.put(4, 1);
        assertEquals(true, map.equals(map2));

    }

    @Test
    public void hashCodeTest() {
        MyMap<Integer, Integer> map2 = new MyMap<>();
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);
        map2.put(1, 4);
        map2.put(2, 3);
        map2.put(3, 2);
        map2.put(4, 1);
        Assert.assertEquals(map.hashCode(), map2.hashCode());
    }
}