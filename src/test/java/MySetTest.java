import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;

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

}
