import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class MyMapTest {

    MyMap myMap;

    @Before
    public void setUp()throws Exception{
        this.myMap = new MyMap();
    }

    @Test
    public void myMapTest(){
        //Given
        this.myMap = new MyMap();
        int expected = 0;
        //When
        int actual = myMap.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsKeyTest(){
        //Given
        boolean expected = true;
        myMap.put(1, 0);
        //When
        boolean actual = myMap.containsKey(1);
        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsValueTest(){
        //Given
        boolean expected = true;
        myMap.put(0, 1);
        //When
        boolean actual = myMap.containsValue(1);
        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void getTest(){
        //Given
        myMap.put(0, 0);
        myMap.put(1, 1);
        myMap.put(2, 2);
        int expected = 1;
        //When
        int actual = (int) myMap.get(1);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void equalsTest(){
        //Given
        MyMap arr = new MyMap();
        arr.put(1, 1);
        myMap.put(2, 2);
        boolean expected = false;
        //When
        boolean actual = myMap.equals(arr);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTest(){
        //Given
        boolean expected = true;
        //When
        boolean actual = myMap.isEmpty();
        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void getSizeTest(){
        ///Given
        int expected = 0;
        //When
        int actual = myMap.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

}
