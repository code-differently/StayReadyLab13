import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {
    @Test
    public void myArrayListDefaultTest(){
        //Given
        int expected = 0;
        //When
        MyArrayList myArrayList = new MyArrayList();
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void myArrayListConstrutorTest(){
        //Given
        int expected = 5;
        //When
        MyArrayList myArrayList = new MyArrayList(5);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getCurrentSizeTest(){
        //Given
        int expected = 20;
        //When
        MyArrayList myArrayList = new MyArrayList(20);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addWithIndexButEmptyTest(){
        //Given
        int expected = 0;
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1, 2);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addWithIndexTest(){
        //Given
        int expected = 4;
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4, 1);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAtEndTest(){
        //Given
        int expected = 1;
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(4);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isEmptyTest(){
        //Given
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);

        boolean actual = myArrayList.isEmpty();

        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void isEmptyTest2(){
        //Given
        //When
        MyArrayList myArrayList = new MyArrayList();
        boolean actual = myArrayList.isEmpty();

        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void removeIndexTest(){
        //Given
        int expected = 2;
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(1);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void removeIndexTest2(){
        //Given
        int expected = 1;
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(0);
        myArrayList.remove(1);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void removeIndexTest3(){
        //Given
        int expected = 2;
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(2);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void removeTypeTest(){
        //Given
        int expected = 3;
        //When
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.remove("B");
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
}
