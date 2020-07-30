import org.junit.Assert;
import org.junit.Test;

public class ArrayListTest
{
    @Test
    public void testAdd()
    {
        MyArrayList<Integer> myArr = new MyArrayList<>();
        myArr.add(0, 12);
        myArr.add(1, 13);
        int size = 2;

        Assert.assertEquals(size, myArr.size());
    }

    @Test
    public void testGet()
    {
        MyArrayList<Integer> myArr = new MyArrayList<>();
        myArr.add(0, 12);
        myArr.add(1, 13);
        int getValue = 13;
        int realValue = myArr.get(1);

        Assert.assertEquals(getValue, realValue);
    }

    @Test
    public void testContains()
    {
        MyArrayList<Integer> myArr = new MyArrayList<>();
        myArr.add(0, 12);
        myArr.add(1, 13);

        Assert.assertEquals(true, myArr.contains(13));
    }

    @Test
    public void testRemove()
    {
        MyArrayList<Integer> myArr = new MyArrayList<>();
        myArr.add(0, 12);
        myArr.add(1, 13);

        myArr.remove(1);

        Assert.assertEquals(1, myArr.size());
    }

    @Test
    public void testSet()
    {
        MyArrayList<Integer> myArr = new MyArrayList<>();
        myArr.add(0, 12);
        myArr.add(1, 13);

        myArr.set(1, 15);

        Assert.assertEquals(2, myArr.size());
    }
}
