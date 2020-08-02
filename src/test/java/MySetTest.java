import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MySetTest {

    @Test
    public void constructorTest(){
        // Given
        int length=0;

        // When
        MySet<String> test=new MySet<String>();
        int actual=test.getSize();

        // Then
        Assert.assertEquals(length,actual);
    }

    @Test
    public void constructorTest2(){
        // Given
        int length=5;

        // When
        MySet<String> test=new MySet<String>(5);
        int actual=test.getSize();

        // Then
        Assert.assertEquals(length,actual);
    }

    @Test
    public void addTest(){
        // Given
        boolean expected=true;

        // When
        MySet<String> test=new MySet<String>();
        boolean actual=test.add("Test");

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addTest2(){
        // Given
        boolean expected=false;
        int size=1;

        // When
        MySet<String> test=new MySet<String>();
        test.add("Test");
        int actualSize=test.getSize();
        boolean actual=test.add("Test");

        // Then
        Assert.assertEquals(size,actualSize);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void emptyTest(){
        // Given
        boolean expected=true;

        // When
        MySet<Type> test=new MySet<Type>();
        boolean actual=test.isEmpty();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void emptyTest2(){
        // Given
        boolean expected=false;

        // When
        MySet<Type> test=new MySet<Type>();
        test.add(String.class);
        boolean actual=test.isEmpty();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void hashCodeTest(){
        // Given
        MySet<Type> expected;

        // When
        MySet<Type> test=new MySet<Type>();
        test.add(String.class);
        test.add(Integer.class);
        expected=test;
        int actual=test.hashCode();

        // Then
        Assert.assertEquals(expected.hashCode(),actual);
    }

    @Test
    public void addAllTest(){
        // Given
        ArrayList<String> addTo=new ArrayList<String>();
        addTo.add("TEST");
        addTo.add("TeST");
        addTo.add("TEST!");
        boolean expected=true;
        int size=3;

        // When
        MySet<String> test=new MySet<String>();
        boolean actual=test.addAll(addTo);
        int actualSize=test.getSize();

        // Then
        Assert.assertEquals(size,actualSize);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAllTest2(){
        // Given
        ArrayList<String> addTo=new ArrayList<String>();
        addTo.add("TEST");
        boolean expected=false;
        int size=1;

        // When
        MySet<String> test=new MySet<String>();
        test.add("TEST");
        boolean actual=test.addAll(addTo);
        int actualSize=test.getSize();

        // Then
        Assert.assertEquals(size,actualSize);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAllTest3(){
        // Given
        ArrayList<String> addTo=new ArrayList<String>();
        addTo.add("T1");
        addTo.add("T2");
        addTo.add("T3");
        boolean expected=true;
        int size=4;

        // When
        MySet<String> test=new MySet<String>(2);
        boolean actual=test.addAll(addTo);
        test.add("a");
        int actualSize=test.getSize();

        // Then
        Assert.assertEquals(size,actualSize);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void equalsTest(){
        // Given
        MySet<Integer> addTo=new MySet<Integer>(2);
        addTo.add(3);
        addTo.add(3);
        addTo.add(4);
        boolean expected=true;

        // When
        MySet<Integer> test=new MySet<Integer>(2);
        test.add(3);
        test.add(3);
        test.add(4);
        boolean actual=test.equals(addTo);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void containsTest(){
        // Given
        boolean expected=true;

        // When
        MySet<Integer> test=new MySet<Integer>();
        test.add(5);
        test.add(3);
        test.add(1);
        test.add(93);
        boolean actual=test.contains(1);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void containsTest2(){
        // Given
        boolean expected=false;

        // When
        MySet<Integer> test=new MySet<Integer>();
        boolean actual=test.contains(1);

        // Then
        Assert.assertEquals(expected,actual);
    }

}
