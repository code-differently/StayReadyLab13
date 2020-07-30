import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySetTest {

    MySet <Integer> set;

    @Before
    public void initialize(){
        set = new MySet<>();
    }

    @Test
    public void addTest() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(1);

        Assert.assertEquals("1 2 3", set.getSet());
    }

    @Test
    public void removeTest() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);

        Assert.assertEquals("1 3", set.getSet());
    }

    @Test
    public void containsTest() {
        set.add(2);
        set.add(1);

        Assert.assertEquals(false, set.contains(4));
    }

    @Test
    public void clearTest() {
        set.add(2);
        set.add(1);
        set.clear();
        Assert.assertEquals("", set.getSet());
    }

    @Test
    public void isEmptyTest() {
        set.add(2);
        set.add(1);
        Assert.assertEquals(false, set.isEmpty());
    }

    @Test
    public void sizeTest() {
        set.add(1);
        set.add(2);
        set.add(3);
        Assert.assertEquals(3, set.size());
    }

    @Test
    public void toArrayTest() {
        Object [] exp =  {1, 2, 3};
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(1);

        Assert.assertArrayEquals(exp, set.toArray());
    }

    @Test
    public void addAllTest() {
        MySet<Integer> test = new MySet<>();
        Object [] exp =  {1, 2, 3, 4};
        set.add(1);
        set.add(2);
        set.add(3);
        test.add(4);

        set.addAll(test);

        Assert.assertArrayEquals(exp, set.toArray());
    }

    @Test
    public void removeAllTest() {
        MySet<Integer> test = new MySet<>();
        Object [] exp =  {1, 3};
        set.add(1);
        set.add(2);
        set.add(3);
        test.add(2);

        set.removeAll(test);

        Assert.assertArrayEquals(exp, set.toArray());
    }
    @Test
    public void retainAllTest() {
        MySet<Integer> test = new MySet<>();
        Object [] exp =  {2};
        set.add(1);
        set.add(2);
        set.add(3);
        test.add(2);

        set.retainAll(test);

        Assert.assertArrayEquals(exp, set.toArray());
    }

    @Test
    public void containsAllTest() {
        MySet<Integer> test = new MySet<>();
        Object [] exp =  {1, 2, 3};
        set.add(1);
        set.add(2);
        set.add(3);
        test.add(1);
        test.add(2);
        test.add(3);

        Assert.assertEquals(true, set.containsAll(test));
    }
}