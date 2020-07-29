import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayListTest {

    @Test
    public void noArgConstructorTest() {
        // Given
        int expectedSize = 0;

        // When
        MyArrayList<Integer> testList = new MyArrayList<>();
        int actualSize = testList.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void argConstructorTest() {
        // Given
        int expectedSize = 0;

        // When
        MyArrayList<Integer> testList = new MyArrayList<>(3);
        int actualSize = testList.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addTest1Arg() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>(3);
        String expected = "[1]";
        int expectedSize = 1;

        // When
        testList.add(1);
        String actual = Arrays.toString(testList.toArray());
        int actualSize = testList.size();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addTest2Arg() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>(3);
        testList.add(1);
        testList.add(4);
        String expected = "[1, 3, 4]";
        int expectedSize = 3;

        // When
        testList.add(1, 3);
        String actual = Arrays.toString(testList.toArray());
        int actualSize = testList.size();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addAllTest() {
        MyArrayList<Integer> testList = new MyArrayList<>(3);
        testList.add(1);
        testList.add(4);

        ArrayList<Integer> testList2 = new ArrayList<>();
        testList2.add(3);
        testList2.add(10);

        String expected = "[1, 4, 3, 10]";
        int expectedSize = 4;

        // When
        testList.addAll(testList2);
        String actual = Arrays.toString(testList.toArray());
        int actualSize = testList.size();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void clearTest() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        String expected = "[]";

        // When
        testList.clear();
        String actual = Arrays.toString(testList.toArray());

        // Then
        Assert.assertEquals(0, testList.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTestTrue() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);

        // When
        boolean actual = testList.contains(2);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsTestFalse() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);

        // When
        boolean actual = testList.contains(5);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void containsAllTestTrue() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        ArrayList<Integer> testList2 = new ArrayList<>();
        testList2.add(1);
        testList2.add(2);
        testList2.add(3);
        testList.addAll(testList2);

        // When
        boolean actual = testList.containsAll(testList2);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsAllTestFalse() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        ArrayList<Integer> testList2 = new ArrayList<>();
        testList2.add(1);
        testList2.add(2);
        testList2.add(3);
        testList.add(1);
        testList.add(2);

        // When
        boolean actual = testList.containsAll(testList2);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void getTest() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>(3);
        testList.add(1);
        testList.add(4);
        int expected = 4;

        // When
        int actual = testList.get(1);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOfTestContained() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        int expected = 1;

        // When
        int actual = testList.indexOf(2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOfTestNotContained() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        int expected = -1;

        // When
        int actual = testList.indexOf(5);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTestTrue() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(67);
        testList.remove(0);

        // When
        boolean actual = testList.isEmpty();

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void isEmptyTestFalse() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(78);

        // When
        boolean actual = testList.isEmpty();

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void iteratorTest() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(2);
        testList.add(5);

        // When
        Iterator<Integer> iterator = testList.iterator();
        int actual1 = iterator.next();
        boolean actualNext = iterator.hasNext();
        int actual2 = iterator.next();

        // Then
        Assert.assertEquals(2, actual1);
        Assert.assertTrue(actualNext);
        Assert.assertEquals(5, actual2);
    }

    @Test
    public void lastIndexOfTest() {
        // Given
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(1);
        int expected = 3;

        // When
        int actual = testList.lastIndexOf(1);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTestIndex() {
        // Given
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");
        String expectedElement = "here";
        String expectedArray = "[This, right]";

        // When
        String actualElement = testList.remove(2);
        String actualArray = Arrays.toString(testList.toArray());

        // Then
        Assert.assertEquals(expectedElement, actualElement);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void removeTestObject() {
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");
        String expectedArray = "[This, here]";

        // When
        boolean actual = testList.remove("right");
        String actualArray = Arrays.toString(testList.toArray());

        // Then
        Assert.assertTrue(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void removeAllTest() {
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("right");
        testList2.add("here");
        testList2.add("This");

        String expectedArray = "[]";

        // When
        boolean actual = testList.removeAll(testList2);
        String actualArray = Arrays.toString(testList.toArray());

        // Then
        Assert.assertTrue(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void removeAllTest2() {
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("swag");
        testList2.add("my");
        testList2.add("is");

        String expectedArray = "[This, right, here]";

        // When
        boolean actual = testList.removeAll(testList2);
        String actualArray = Arrays.toString(testList.toArray());

        // Then
        Assert.assertFalse(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void retainAllTest() {
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("right");
        testList2.add("here");
        testList2.add("This");

        String expectedArray = "[This, right, here]";

        // When
        boolean actual = testList.retainAll(testList2);
        String actualArray = Arrays.toString(testList.toArray());

        // Then
        Assert.assertFalse(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void retainAllTest2() {
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("right");

        String expectedArray = "[right]";

        // When
        boolean actual = testList.retainAll(testList2);
        String actualArray = Arrays.toString(testList.toArray());

        // Then
        Assert.assertTrue(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void setTest() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(78);
        int expectedReturn = 78;
        int expectedNew = 91;

        // When
        int actualReturn = testList.set(0, 91);
        int actualNew = testList.get(0);

        // Then
        Assert.assertEquals(expectedReturn, actualReturn);
        Assert.assertEquals(expectedNew, actualNew);
    }

    @Test
    public void sizeTest() {
        // Given
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");
        int expected = 3;

        // When
        int actual = testList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toArrayTest() {
        // Given
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("This");
        testList.add("right");
        testList.add("here");
        String expected = "[This, right, here]";

        // When
        String actual = Arrays.toString(testList.toArray());

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toArrayTest2() {
        // Given
        String[] arrayPassed = {"This", "right", "here"};
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("is");
        testList.add("my");
        testList.add("swag");
        String expected = "[This, right, here, is, my, swag]";

        // When
        String actual = Arrays.toString(testList.toArray(arrayPassed));

        // Then
        Assert.assertEquals(expected, actual);
    }
}
