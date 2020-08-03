import MyArrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

    MyArrayList<Integer> test;
    String expected;
    String actual;

    @Before
    public void setUp () {

        test = new MyArrayList<Integer>();
        expected = "";
        actual = "";
    }

    @Test
    public void addTest1(){

        expected = "[4]";
        test.add(4);

        actual = test.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest2(){

        expected = "[2 4 7 8]";
        test.add(2);
        test.add(4);
        test.add(8);
        test.add(2,7);

        actual = test.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest(){

        expected = "2";
        test.add(2);
        test.add(4);

        actual += test.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){

        expected = "4";
        test.add(2);
        test.add(4);

        actual += test.remove(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest(){

        expected = "2";
        test.add(2);


        actual += test.set(0, 88);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearTest(){

        expected = "2";
        test.add(2);

        test.clear();

        Assert.assertTrue(test.isEmpty());
    }

    @Test
    public void containsTest1(){

        test.add(2);

        Assert.assertTrue(test.contains(2));
    }

    @Test
    public void containsTest2(){

        test.add(2);

        Assert.assertFalse(test.contains(6));
    }

    @Test
    public void isEmptyTest1(){



        Assert.assertTrue(test.isEmpty());
    }

    @Test
    public void isEmptyTest2(){

        test.add(2);

        Assert.assertFalse(test.isEmpty());
    }

    @Test
    public void sizeTest(){

        expected = "1";
        test.add(2);

        actual += test.size();


       Assert.assertEquals(expected, actual);
    }




}
