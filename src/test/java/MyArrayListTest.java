import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class MyArrayListTest {

    @Test
    public void constructorTest1(){
        MyArrayList<String> al = new MyArrayList<>();

        int actual = al.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest2(){
        MyArrayList<String> al = new MyArrayList<>(15);

        int actual = al.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest(){
        MyArrayList<Integer> al = new MyArrayList<>(5);

        al.add(2);
        al.add(3);

        int actual = al.size();
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest1(){
        MyArrayList<Integer> al = new MyArrayList<>(5);

        al.add(2);
        al.add(3);
        al.add(4);

        Object[] actual = al.toArray();
        Object[] expected = {2, 3, 4};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addWithIndexTest1(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);

        al.add(6, 5);
        Object[] actual = al.toArray();
        Object[] expected = {2, 3, 4, 5, 6, 7, 5, 8, 9};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllTest1(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);

        al.addAll(new Integer[] {5, 6, 7});
        Object[] actual = al.toArray();
        Object[] expected = {2, 3, 5, 6, 7};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllTest2(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(2);
        al.add(3);

        al.addAll(new Integer[] {5, 6, 7, 8, 9, 10, 11});
        Object[] actual = al.toArray();
        Object[] expected = {2, 3, 2, 3, 5, 6, 7, 8, 9, 10, 11};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllWithIndexTest1(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(2);
        al.add(3);

        al.addAll(2, new Integer[] {5, 6});
        Object[] actual = al.toArray();
        Object[] expected = {2, 3, 5, 6};

        int actualS = al.size();
        int expectedS = 4;

        Assert.assertArrayEquals(expected, actual);
        Assert.assertEquals(expectedS, actualS);
    }

    @Test
    public void addAllWithIndexTest2(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(2);
        al.add(3);

        al.addAll(3, new Integer[] {5, 6, 7});
        Object[] actual = al.toArray();
        Object[] expected = {2, 3, 2, 5, 6, 7};

        int actualS = al.size();
        int expectedS = 6;

        Assert.assertArrayEquals(expected, actual);
        Assert.assertEquals(expectedS, actualS);
    }

    @Test
    public void clearTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);

        al.clear();
        int actual = al.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cloneTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);

        Object[] actual = al.clone();
        Object[] expected = {2, 3, null, null, null, null, null, null, null, null};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void containsTestTrue(){
        MyArrayList<String> al = new MyArrayList<>();
        al.add("one");
        al.add("two");

        boolean actual = al.contains("one");

        Assert.assertTrue(actual);
    }

    @Test
    public void containsTestFalse(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);

        boolean actual = al.contains(5);

        Assert.assertFalse(actual);
    }

    @Test
    public void ensureCapacityTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);

        int actual = al.ensureCapacity(11);
        int expected = 20;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);

        int actual = al.get(1);
        int expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOfTest1(){
        MyArrayList<String> al = new MyArrayList<>();
        al.add("two");
        al.add("three");
        al.add("four");

        int actual = al.indexOf("three");
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOfTest2(){
        MyArrayList<String> al = new MyArrayList<>();
        al.add("two");
        al.add("three");
        al.add("four");

        int actual = al.indexOf("five");
        int expected = -1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTestFalse(){
        MyArrayList<String> al = new MyArrayList<>();
        al.add("two");
        al.add("three");
        al.add("four");

        boolean actual = al.isEmpty();

        Assert.assertFalse(actual);
    }

    @Test
    public void isEmptyTestTrue(){
        MyArrayList<String> al = new MyArrayList<>();

        boolean actual = al.isEmpty();

        Assert.assertTrue(actual);
    }

    @Test
    public void lastIndexOfTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(2);
        al.add(3);

        int actual = al.lastIndexOf(2);
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest1(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        int actual = al.remove(2);
        int expected = 4;

        Object[] actualA = al.toArray();
        Object[] expectedA = {2, 3, 5};

        Assert.assertEquals(expected, actual);
        Assert.assertArrayEquals(expectedA, actualA);
    }

    @Test
    public void removeTest2(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        int actual = al.remove(0);
        int expected = 2;

        Object[] actualA = al.toArray();
        Object[] expectedA = {3, 4, 5};

        Assert.assertEquals(expected, actual);
        Assert.assertArrayEquals(expectedA, actualA);

    }

    @Test
    public void removeTestTrue(){
        MyArrayList<String> al = new MyArrayList<>();
        al.add("one");
        al.add("two");
        al.add("three");

        boolean actual = al.remove("two");

        Assert.assertTrue(actual);
    }

    @Test
    public void removeTestFalse(){
        MyArrayList<String> al = new MyArrayList<>();
        al.add("one");
        al.add("two");
        al.add("three");

        boolean actual = al.remove("four");

        Assert.assertFalse(actual);
    }

    @Test
    public void removeAllTestTrue1(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);

        boolean actual = al.removeAll(new Integer[] {3, 4});

        Object[] actualA = al.toArray();
        Object[] expectedA = {2};

        Assert.assertTrue(actual);
        Assert.assertArrayEquals(expectedA, actualA);
    }

    @Test
    public void removeAllTestTrue2(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);

        boolean actual = al.removeAll(new Integer[] {5, 4});

        Object[] actualA = al.toArray();
        Object[] expectedA = {2, 3};

        Assert.assertTrue(actual);
        Assert.assertArrayEquals(expectedA, actualA);
    }

    @Test
    public void removeAllTestTrueDuplicates(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(4);
        al.add(3);

        boolean actual = al.removeAll(new Integer[] {3, 4});

        Object[] actualA = al.toArray();
        Object[] expectedA = {2};

        Assert.assertTrue(actual);
        Assert.assertArrayEquals(expectedA, actualA);
    }

    @Test
    public void removeAllTestFalse(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);

        boolean actual = al.removeAll(new Integer[] {5, 6});

        Assert.assertFalse(actual);
    }

    @Test
    public void removeIfTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        Predicate<Integer> lessThan = i -> (i <= 3);
        al.removeIf(lessThan);

        Object[] actual = al.toArray();
        Object[] expected = {4, 5, 6};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeRangeTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        al.removeRange(1, 2);
        Object[] actual = al.toArray();
        Object[] expected = {2, 4, 5};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeRangeTest2(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        al.removeRange(1, 3);
        Object[] actual = al.toArray();
        Object[] expected = {2, 5};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void replaceAllTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        UnaryOperator<Integer> op = i -> (i - 2);
        al.replaceAll(op);
        Object[] actual = al.toArray();
        Object[] expected = {1, 2, 3, 4};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void retainAllTest1(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(3);

        al.retainAll(new Integer[] {3, 5, 6});
        Object[] actual = al.toArray();
        Object[] expected = {3, 3, 5, 6};

        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void retainAllTest2(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        al.retainAll(new Integer[] {3, 5});
        Object[] actual = al.toArray();
        Object[] expected = {3, 5};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);

        al.set(1, 5);
        Object[] actual = al.toArray();
        Object[] expected = {2, 5};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void trimToSizeTest(){
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        al.trimToSize();
        Object[] actual = al.toArray();
        Object[] expected = {2, 3, 4, 5, 6};

        Assert.assertArrayEquals(expected, actual);
    }


}