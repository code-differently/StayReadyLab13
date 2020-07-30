import org.junit.Assert;
import org.junit.Test;

public class MySetTest<T> {
    @Test
    public void mySetDefaultTest(){
        //Given
        int expected = 0;
        //When
        MySet<T> mySet = new MySet<T>();
        int actual = mySet.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void mySetConstructorTest(){
        //Given
        int expected = 5;
        //When
        MySet<T> mySet = new MySet<T>(5);
        int actual = mySet.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getCurrentSizeTest(){
        //Given
        int expected = 20;
        //When
        MySet<T> mySet = new MySet<T>(20);
        int actual = mySet.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
}
