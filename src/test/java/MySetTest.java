import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class MySetTest {

    MySet mySet;

    @Before
    public void setUp()throws Exception{
        this.mySet = new MySet();
    }

    @Test
    public void mySetTest(){
        //Given
        this.mySet = new MySet(30);
        int expected = 30;
        //When
        int actual = mySet.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest(){
        //Given
        int expected = 0;
        //When
        int actual = mySet.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

    /*@Test
    public void getHashCodeTest(){
        //Given
        mySet.add(123);
        mySet.add(456);
        mySet.add(678);
        int expected = 123456678;
        //When
        int actual = mySet.hashCode();
        //Then
        Assert.assertEquals(expected, actual);
    }*/

    @Test
    public void containsTest(){
        //Given
        mySet.add(32);
        mySet.add(33);
        mySet.add(34);
        boolean expected = true;
        //When
        boolean actual = mySet.contains(34);
        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void isEmptyTest(){
        //Given
        boolean expected = true;
        //When
        boolean actual = mySet.isEmpty();
        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void equalsTest(){
        //Given
        MySet arr = new MySet();
        arr.add(1);
        mySet.add(2);
        boolean expected = false;
        //When
        boolean actual = mySet.equals(arr);
        //Then
        Assert.assertEquals(expected, actual);
    }

}