import org.junit.Assert;
import org.junit.Test;

public class HashSetTest
{
    @Test
    public void testAdd()
    {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);

        Assert.assertEquals(2, mySet.size());
    }

    @Test
    public void testContains()
    {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);

        Assert.assertEquals(true, mySet.contains(1));
    }

    @Test
    public void testRemove()
    {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);

        Assert.assertEquals(true, mySet.remove(2));
    }

    @Test
    public void testEmpty()
    {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);

        Assert.assertEquals(false, mySet.isEmpty());
    }
}
