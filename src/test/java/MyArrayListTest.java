import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;

public class MyArrayListTest {

    @Test
    public void constructorTest(){
        // Given
        int length=0;

        // When
        MyArrayList<String> test=new MyArrayList<String>();
        int actual=test.getSize();

        // Then
        Assert.assertEquals(length,actual);
    }

    @Test
    public void constructorTest2(){
        // Given
        int length=0;

        // When
        MyArrayList<Double> test=new MyArrayList<Double>();
        int actual=test.getSize();

        // Then
        Assert.assertEquals(length,actual);
    }

    @Test
    public void constructorTest3(){
        // Given
        int length=11;

        // When
        MyArrayList<Double> test=new MyArrayList<Double>(length);
        int actual=test.getSize();

        // Then
        Assert.assertEquals(length,actual);
    }

    @Test
    public void emptyTest(){
        // Given
        boolean expected=true;

        // When
        MyArrayList<Type> test=new MyArrayList<Type>();
        boolean actual=test.isEmpty();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void emptyTest1(){
        // Given
        boolean expected=false;

        // When
        MyArrayList<Type> test=new MyArrayList<Type>();
        test.add(String.class);
        boolean actual=test.isEmpty();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addTest(){
        // Given
        boolean expected=false;
        // When
        MyArrayList<Double> test=new MyArrayList<Double>();
        test.add(123.33);
        test.add(12.12);
        boolean actual=test.isEmpty();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addTest2(){
        // Given
        int expected=4;


        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.add(1);
        test.add(93);
        int actual=test.getSize();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getTest(){
        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.get(1);
    }

    @Test
    public void getTest2(){
        // Given
        int exepected=3;
        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.add(1);
        test.add(93);
        int actual=test.get(1);

        //
        Assert.assertEquals(exepected,actual);
    }

    @Test
    public void getTest3(){
        // Given
        String exepected="n0";
        // When
        MyArrayList<String> test=new MyArrayList<String>();
        test.add("no");
        test.add("YES");
        test.add("yes");
        test.add("n0");
        String actual=test.get(test.getSize()-1);

        //
        Assert.assertEquals(exepected,actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getTest4(){
        // When
        MyArrayList<String> test=new MyArrayList<String>();
        test.add("no");
        test.add("YES");
        test.add("yes");
        test.add("n0");
        String actual=test.get(33);
    }

    @Test
    public void containsTest(){
        // Given
        boolean expected=true;

        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
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
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.add(1);
        test.add(93);
        boolean actual=test.contains(11);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void containsTest3(){
        // Given
        boolean expected=false;

        // When
        MyArrayList<Boolean> test=new MyArrayList<Boolean>();
        test.add(true);
        test.add(true);
        test.add(true);
        boolean actual=test.contains(false);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void clearTest(){
        // Given
        boolean expected=true;

        // When
        MyArrayList<Boolean> test=new MyArrayList<Boolean>();
        test.add(true);
        test.add(true);
        test.add(true);
        test.clear();
        boolean actual=test.isEmpty();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void clearTest2(){
        // Given
        boolean expected=false;

        // When
        MyArrayList<Boolean> test=new MyArrayList<Boolean>();
        test.add(true);
        test.add(true);
        test.add(true);
        test.clear();
        test.add(true);
        boolean actual=test.isEmpty();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAtIndexTest(){
        // Given
        int expected=6;

        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.add(6,0);
        int actual=test.get(0);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndexTest2(){
        // Given
        int expected=6;

        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.add(6,8);
        int actual=test.get(1);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAtIndexTest3(){
        // Given
        String expected="YUP";

        // When
        MyArrayList<String> test=new MyArrayList<String>(5);
        test.add("YUP",3);
        String actual=test.get(3);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAtIndexTest4(){
        // Given
        String expected="NO";

        // When
        MyArrayList<String> test=new MyArrayList<String>(5);
        test.add("YUP",3);
        test.add("NO");
        String actual=test.get(0);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAtIndexTest5(){
        // Given
        String expected="REMOVED 3";
        String expected2="Test3";

        // When
        MyArrayList<String> test=new MyArrayList<String>(5);
        test.add("YUP",3);
        test.add("NO");
        test.add("test");
        test.add("aaaa");
        test.add("REMOVED 3");
        test.add("Test3");
        System.out.println(test.getSize());
        String actual=test.get(3);
        int leng=test.getSize()-2;
        String actual2=test.get(leng);

        // Then
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void addAtIndexTest6(){
        // Given
        String expected="WORD";

        // When
        MyArrayList<String> test=new MyArrayList<String>(5);
        test.add("NO");
        test.add("test");
        test.add("aaaa");
        test.add("YUP",3);
        test.add("REMOVED 3");
        test.add("FOUND");
        test.add("NOPE",0);
        test.add("WORD");
        String actual=test.get(7);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setTest(){
        // Given
        int expected=6;

        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.set(2,5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setTest2(){
        // Given
        int expected=6;

        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.set(2,5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtIndexTest(){
        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.remove(-1);
    }

    @Test
    public void removeAtIndexTest2(){
        // Given
        int expected=3;
        int expectedSize=1;

        // When
        MyArrayList<Integer> test=new MyArrayList<Integer>();
        test.add(5);
        test.add(3);
        test.remove(0);
        int actual=test.get(0);
        int actualSize=test.getSize();

        // Then
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expectedSize,actualSize);
    }

}
