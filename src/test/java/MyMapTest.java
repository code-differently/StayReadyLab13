import MyArrayList.MyArrayList;
import MyMap.MyMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyMapTest {

    MyMap<Character, Integer> test;
    String expected;
    String actual;

    @Before
    public void setUp () {

        test = new MyMap<Character, Integer>();
        expected = "";
        actual = "";
    }

    @Test
    public void putTest(){

        expected = "[d]\n[4]";
        test.put('d', 4);

        actual = test.toString();

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void getTest(){

        expected = "2";
        test.put('d', 2);

        actual += test.get('d');

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){

        expected = "2";
        test.put('d', 2);
        actual += test.remove('d');

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void clearTest(){

        expected = "2";
        test.put('g', 2);

        test.clear();

        Assert.assertTrue(test.isEmpty());
    }

    @Test
    public void containsKeyTest(){

        test.put('g', 2);

        Assert.assertTrue(test.containsKey('g'));
    }



    @Test
    public void isEmptyTest1(){

        Assert.assertTrue(test.isEmpty());
    }

    @Test
    public void isEmptyTest2(){

        test.put('g', 2);

        Assert.assertFalse(test.isEmpty());
    }

    @Test
    public void sizeTest(){

        expected = "1";
        test.put('g', 2);

        actual += test.size();

        Assert.assertEquals(expected, actual);
    }

}
