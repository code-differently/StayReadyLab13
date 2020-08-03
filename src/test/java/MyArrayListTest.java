import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class MyArrayListTest {
    MyArrayList myArrayList;

    @Before
    public void setUp()throws Exception{
        this.myArrayList = new MyArrayList();
    }

    @Test
    public void myArrayListTest(){
        //Given
        this.myArrayList = new MyArrayList(25);
        int expected = 25;

        //When
        int actual = myArrayList.size();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        //Given
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        int expected = 1;

        //When
        int actual = (int) myArrayList.get(1);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest(){
        //Given
        int expected = 0;

        //When
        int actual = myArrayList.size();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTest() {
        //Given
        boolean expected = true;

        //When
        boolean actual = myArrayList.isEmpty();

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsTest() {
        //Given
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        boolean expected = true;

        //When
        boolean actual = myArrayList.contains(5);

        //Then
        Assert.assertTrue(actual);
    }
}
