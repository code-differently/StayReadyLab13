import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

    MyArrayList<Integer> arr;

    @Before
    public void initialize(){
        arr = new MyArrayList<>();
    }

    @Test
    public void addTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);

        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10", arr.getList());
    }

    @Test
    public void addTest2() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(4,5);

        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10", arr.getList());
    }

    @Test
    public void getTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        Assert.assertEquals((Object) 4, arr.get(3));
    }

    @Test
    public void removeTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.remove((Integer) 3);
        Assert.assertEquals("1 2 4 5", arr.getList());
    }

    @Test
    public void removeTest2() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.remove(2);
        Assert.assertEquals("1 2 4 5", arr.getList());
    }

    @Test
    public void setTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.set(0, 0);
        Assert.assertEquals("0 2 3 4 5", arr.getList());
    }

    @Test
    public void clearTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.clear();
        Assert.assertEquals("", arr.getList());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertEquals(true, arr.isEmpty());
    }

    @Test
    public void toArrayTest() {
        Object [] exp =  {1, 2, 3, 4, 5};
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        Assert.assertArrayEquals(exp, arr.toArray());
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(0, arr.size());
    }

    @Test
    public void indexOfTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        Assert.assertEquals(0, arr.indexOf(1));
    }

    @Test
    public void lastIndexOfTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(1);

        Assert.assertEquals(4, arr.lastIndexOf(1));
    }

    @Test
    public void getListTest() {

        Assert.assertEquals("", arr.getList());
    }

    @Test
    public void containsTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        Assert.assertEquals(true, arr.contains(5));
    }

    @Test
    public void addAllTest() {
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> exp = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr2.add(4);
        arr2.add(5);
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(4);
        exp.add(5);
        arr.addAll(arr2);
        Assert.assertEquals(exp.getList(), arr.getList());
    }

    @Test
    public void addAllTest2() {
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> exp = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr2.add(4);
        arr2.add(5);
        exp.add(1);
        exp.add(4);
        exp.add(5);
        exp.add(2);
        exp.add(3);
        arr.addAll(1, arr2);
        Assert.assertEquals(exp.getList(), arr.getList());
    }

    @Test
    public void removeAllTest() {
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> exp = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr2.add(2);
        exp.add(1);
        exp.add(3);

        arr.removeAll(arr2);
        Assert.assertEquals(exp.getList(), arr.getList());
    }

    @Test
    public void retainAllTest() {
        MyArrayList<Integer> arr2 = new MyArrayList<>();
        MyArrayList<Integer> exp = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr2.add(2);
        exp.add(2);

        arr.retainAll(arr2);
        Assert.assertEquals(exp.getList(), arr.getList());
    }

    @Test
    public void subListTest() {
        MyArrayList<Integer> exp = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        exp.add(1);
        exp.add(2);
        exp.add(3);

        Assert.assertEquals(exp.getList(), arr.subList(0, 3).getList());
    }

    @Test
    public void removeRangeTest() {
        MyArrayList<Integer> exp = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        exp.add(4);
        exp.add(5);
        arr.removeRange(0, 3);

        Assert.assertEquals(exp.getList(), arr.getList());
    }

    @Test
    public void cloneTest(){
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        Assert.assertNotEquals(arr, arr.clone());
    }


}