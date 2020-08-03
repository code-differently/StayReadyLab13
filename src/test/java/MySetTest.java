import MyArrayList.MyArrayList;
import MySet.MySet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MySetTest {


    MySet<Integer> test;
    String expected;
    String actual;

    @Before
    public void setUp () {

        test = new MySet<Integer>();
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
    public void removeTest1(){

        test.add(2);
        test.add(4);


        Assert.assertTrue(test.remove(2));
    }

    @Test
    public void removeTest2(){

        test.add(2);
        test.add(4);

        Assert.assertFalse(test.remove(1));
    }

    @Test
    public void clearTest(){

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
    public void containsAllTest1(){

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);

        test.add(2);
        test.add(3);

        Assert.assertTrue(test.containsAll(list));
    }

    @Test
    public void containsAllTest2(){

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);

        test.add(2);

        Assert.assertFalse(test.containsAll(list));
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
