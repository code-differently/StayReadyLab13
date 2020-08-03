import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;

public class MySetTest {

    @Test
    public void constructorTest1(){
        MySet<String> ms = new MySet<>();

        int actual = ms.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest2(){
        MySet<String> ms = new MySet<>(15);

        int actual = ms.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest1(){
        MySet<Integer> ms = new MySet<>(5);

        ms.add(2);
        ms.add(3);

        int actual = ms.size();
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest1(){
        MySet<Integer> ms = new MySet<>(5);

        ms.add(2);
        ms.add(3);
        ms.add(2);

        int actual = ms.size();
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest2(){
        MySet<Integer> ms = new MySet<>(5);

        ms.add(2);
        ms.add(3);
        ms.add(4);

        Object[] actual = ms.toArray();
        Object[] expected = {2, 3, 4};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllTest1(){
        MySet<Integer> ms = new MySet<>();
        ms.add(2);
        ms.add(3);

        ms.addAll(new Integer[] {5, 6, 7});
        Object[] actual = ms.toArray();
        Object[] expected = {2, 3, 5, 6, 7};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllTest2(){
        MySet<Integer> ms = new MySet<>();
        ms.add(2);
        ms.add(3);
        ms.add(2);
        ms.add(3);

        ms.addAll(new Integer[] {5, 6, 2, 8, 9, 10, 11});
        Object[] actual = ms.toArray();
        Object[] expected = {2, 3, 5, 6, 8, 9, 10, 11};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void clearTest(){
        MySet<Integer> ms = new MySet<>();
        ms.add(2);
        ms.add(3);

        ms.clear();
        int actual = ms.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTestTrue(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");

        boolean actual = ms.contains("one");

        Assert.assertTrue(actual);
    }

    @Test
    public void containsTestFalse(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");

        boolean actual = ms.contains("three");

        Assert.assertFalse(actual);
    }

    @Test
    public void containsAllTestTrue(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");
        ms.add("four");

        String[] check = {"three", "two"};
        boolean actual = ms.containsAll(check);

        Assert.assertTrue(actual);
    }

    @Test
    public void containsAllTestFalse(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");
        ms.add("four");

        String[] check = {"three", "two", "five"};
        boolean actual = ms.containsAll(check);

        Assert.assertFalse(actual);
    }

    @Test
    public void equalsTestTrue(){
        MySet<String> ms1 = new MySet<>();
        ms1.add("one");
        ms1.add("two");

        MySet<String> ms2 = new MySet<>();
        ms1.add("one");
        ms1.add("two");

        boolean actual = ms1.equals(ms2);

        Assert.assertTrue(actual);
    }

    @Test
    public void equalsTestFalse(){
        MySet<String> ms1 = new MySet<>();
        ms1.add("one");
        ms1.add("two");

        MySet<String> ms2 = new MySet<>();
        ms1.add("one");
        ms1.add("three");

        boolean actual = ms1.equals(ms2);

        Assert.assertFalse(actual);
    }

    @Test
    public void hashCodeTest(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");

        int actual = ms.hashCode();
        int expected = 0;

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void isEmptyTestFalse(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("three");
        ms.add("four");


        boolean actual = ms.isEmpty();

        Assert.assertFalse(actual);
    }

    @Test
    public void isEmptyTestTrue(){
        MySet<String> ms = new MySet<>();

        boolean actual = ms.isEmpty();

        Assert.assertTrue(actual);
    }

    @Test
    public void iteratorTest(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");

    }

    @Test
    public void removeTestTrue(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");

        boolean actual = ms.remove("two");

        Assert.assertTrue(actual);
    }

    @Test
    public void removeTestFalse(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");

        boolean actual = ms.remove("four");

        Assert.assertFalse(actual);
    }

    @Test
    public void removeAllTestTrue(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");

        boolean actual = ms.removeAll(new String[] {"three", "four"});

        Object[] actualA = ms.toArray();
        Object[] expectedA = {"one", "two"};

        Assert.assertTrue(actual);
        Assert.assertArrayEquals(expectedA, actualA);
    }

    @Test
    public void removeAllTestFalse(){
        MySet<String> ms = new MySet<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");

        boolean actual = ms.removeAll(new String[] {"five", "four"});

        Object[] actualA = ms.toArray();
        Object[] expectedA = {"one", "two", "three"};

        Assert.assertFalse(actual);
        Assert.assertArrayEquals(expectedA, actualA);
    }

    @Test
    public void retainAllTest1(){
        MySet<Integer> ms = new MySet<>();
        ms.add(2);
        ms.add(3);
        ms.add(4);
        ms.add(5);
        ms.add(6);

        boolean actual = ms.retainAll(new Integer[] {3, 5, 6});
        Object[] actualS = ms.toArray();
        Object[] expectedS = {3, 5, 6};

        Assert.assertTrue(actual);
        Assert.assertArrayEquals(expectedS, actualS);
    }

    @Test
    public void retainAllTest2(){
        MySet<Integer> ms = new MySet<>();
        ms.add(2);
        ms.add(3);
        ms.add(4);
        ms.add(5);
        ms.add(6);

        boolean actual = ms.retainAll(new Integer[] {7, 8, 9});
        Object[] actualS = ms.toArray();
        Object[] expectedS = {2, 3, 4, 5, 6};

        Assert.assertFalse(actual);
        Assert.assertArrayEquals(expectedS, actualS);
    }

    @Test
    public void toArrayTestNoParameter(){
        MySet<Integer> ms = new MySet<>();
        ms.add(2);
        ms.add(3);
        ms.add(4);
        ms.add(5);

        Object[] actual = ms.toArray();
        Object[] expected = {2, 3, 4, 5};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void toArrayTestParameter(){
        MySet<Integer> ms = new MySet<>();
        ms.add(2);
        ms.add(3);
        ms.add(4);

        Object[] actual = ms.toArray(new Integer[] {5});
        Object[] expected = {2, 3, 4, 5};

        Assert.assertArrayEquals(expected, actual);
    }
}