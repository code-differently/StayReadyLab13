import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest<T> {
    @Test
    public void myArrayListDefaultTest(){
        //Given
        int expected = 0;
        //When
        MyArrayList<T> myArrayList = new MyArrayList<T>();
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void myArrayListConstructorTest(){
        //Given
        int expected = 5;
        //When
        MyArrayList<T> myArrayList = new MyArrayList<T>(5);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getCurrentSizeTest(){
        //Given
        int expected = 20;
        //When
        MyArrayList<T> myArrayList = new MyArrayList<T>(20);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addWithIndexButEmptyTest(){
        //Given
        int expected = 0;
        //When
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1, 2);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addWithIndexTest(){
        //Given
        int expected = 5;
        //When
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(9, 0);
        myArrayList.add(3);
        myArrayList.add(4, 1);
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAtEndTest(){
        //Given
        int expected = 3;
        //When
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.add(7);
        int actual = myArrayList.getCurrentSize();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isEmptyTest(){
        //Given
        //When
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1);

        boolean actual = myArrayList.isEmpty();

        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void isEmptyTest2(){
        //Given
        //When
        MyArrayList<T> myArrayList = new MyArrayList<T>();
        boolean actual = myArrayList.isEmpty();

        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void removeIndexTest(){
        //Given
        int expected = 2;
        //When
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
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
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
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
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
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
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.remove("B");
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void removeTypeTest2(){
        //Given
        int expected = 3;
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.remove("A");
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void removeTypeTest3(){
        //Given
        int expected = 4;
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.add("B");
        myArrayList.remove("B");
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getTest(){
        //Given
        T expected = (T)"A";
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        T actual = (T) myArrayList.get(0);
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getTest2(){
        //Given
        T expected = (T)"B";
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        T actual = (T) myArrayList.get(2);
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setTest(){
        //Given
        T expected = (T)"B";
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.set(0,"B");
        T actual = (T) myArrayList.get(0);
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setTest2(){
        //Given
        T expected = (T)"B";
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.set(3,"B");
        T actual = (T) myArrayList.get(3);
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void clearTest(){
        //Given
        int expected = 0;
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.clear();
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void clearTest2(){
        //Given
        int expected = 0;
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.clear();
        int actual = myArrayList.getCurrentSize();
        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void containsTest(){
        //Given
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        boolean actual = myArrayList.contains("A");
        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void containsTest2(){
        //Given
        //When
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        boolean actual = myArrayList.contains("D");
        //Then
        Assert.assertFalse(actual);
    }
}
