import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.Collection;

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
    @Test
    public void isEmptyTest(){
        //Given
        //When
        MySet<T> mySet = new MySet<T>();
        boolean actual = mySet.isEmpty();

        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void containsTest(){
        //Given
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        boolean actual = mySet.contains("A");
        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void containsTest2(){
        //Given
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        boolean actual = mySet.contains("C");
        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void containsTest3(){
        //Given
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        boolean actual = mySet.contains("D");
        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void addTest(){
        //Given
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        boolean actual = mySet.add("B");
        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void addTest2(){
        //Given
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        boolean actual = mySet.add("D");
        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void containsAllTest(){
        //Given
        Collection c = new ArrayList();
        c.add("A");
        c.add("B");
        c.add("C");
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        boolean actual = mySet.containsAll(c);
        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void containsAllTest2(){
        //Given
        Collection c = new ArrayList();
        c.add("A");
        c.add("B");
        c.add("C");
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        boolean actual = mySet.containsAll(c);
        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void containsAllTest3(){
        //Given
        Collection<String> c = new ArrayList<String>();
        c.add("A");
        c.add("B");
        c.add("C");
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("D");
        mySet.add("C");
        mySet.add("A");
        boolean actual = mySet.containsAll(c);
        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void addsAllTest(){
        //Given
        Collection<String> c = new ArrayList<String>();
        c.add("A");
        c.add("B");
        c.add("C");
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        boolean actual = mySet.addAll(c);
        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void addsAllTest2(){
        //Given
        Collection<String> c = new ArrayList<String>();
        c.add("A");
        c.add("B");
        c.add("C");
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        boolean actual = mySet.addAll(c);
        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void addsAllTest3(){
        //Given
        Collection<String> c = new ArrayList<String>();
        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        boolean actual = mySet.addAll(c);
        //Then
        Assert.assertTrue(actual);
    }
    @Test
    public void clearTest(){
        //Given
        int expected = 0;
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        mySet.clear();
        int actual = mySet.getCurrentSize();
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void clearTest2(){
        //Given
        int expected = 0;
        //When
        MySet<String> mySet = new MySet<String>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        mySet.add("D");
        mySet.add("E");
        mySet.clear();
        int actual = mySet.getCurrentSize();
        //Then
        Assert.assertEquals(expected, actual);
    }
}
