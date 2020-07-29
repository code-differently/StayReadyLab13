import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class MySetTest {

    @Test
    public void addTest() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        String expected = "[1]";

        // When
        boolean actuallyAdded = testSet.add(1);
        String actual = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertTrue(actuallyAdded);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest2() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        String expected = "[1]";

        // When
        testSet.add(1);
        boolean actuallyAdded = testSet.add(1);
        String actual = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertFalse(actuallyAdded);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAllTestAllElements() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        testSet.add(1);

        HashSet<Integer> testSet2 = new HashSet<>();
        testSet2.add(5);
        testSet2.add(3);

        String expected = "[1, 3, 5]";

        // When
        boolean actuallyAddedAll = testSet.addAll(testSet2);
        String actual = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertTrue(actuallyAddedAll);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAllTestSomeElements() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        testSet.add(1);

        HashSet<Integer> testSet2 = new HashSet<>();
        testSet2.add(5);
        testSet2.add(3);
        testSet2.add(1);

        String expected = "[1, 3, 5]";

        // When
        boolean actuallyAddedAll = testSet.addAll(testSet2);
        String actual = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertFalse(actuallyAddedAll);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearTest() {
        // Given
        MySet<String> testSet = new MySet<>();
        testSet.add("That's Me!");
        String expectedArray = "[]";

        // When
        testSet.clear();
        int actual = testSet.size();
        String actualArray = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertEquals(expectedArray, actualArray);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void containsTestTrue() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);

        // When
        boolean actual = testSet.contains(2);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsTestFalse() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);

        // When
        boolean actual = testSet.contains(5);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void containsAllTestTrue() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        HashSet<Integer> testSet2 = new HashSet<>();
        testSet2.add(1);
        testSet2.add(2);
        testSet2.add(3);
        testSet.addAll(testSet2);

        // When
        boolean actual = testSet.containsAll(testSet2);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsAllTestFalse() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        HashSet<Integer> testSet2 = new HashSet<>();
        testSet2.add(1);
        testSet2.add(2);
        testSet2.add(3);
        testSet.add(1);
        testSet.add(2);

        // When
        boolean actual = testSet.containsAll(testSet2);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void isEmptyTestTrue() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        testSet.add(5);
        testSet.remove(5);

        // When
        boolean actual = testSet.isEmpty();

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void isEmptyTestFalse() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        testSet.add(78);

        // When
        boolean actual = testSet.isEmpty();

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void iteratorTest() {
        // Given
        MySet<Integer> testSet = new MySet<>();
        testSet.add(2);
        testSet.add(5);

        // When
        Iterator<Integer> iterator = testSet.iterator();
        int actual1 = iterator.next();
        boolean actualNext = iterator.hasNext();
        int actual2 = iterator.next();

        // Then
        Assert.assertEquals(2, actual1);
        Assert.assertTrue(actualNext);
        Assert.assertEquals(5, actual2);
    }

    @Test
    public void removeTest() {
        MySet<String> testSet = new MySet<>();
        testSet.add("This");
        testSet.add("right");
        testSet.add("here");
        String expectedArray = "[This, here]";

        // When
        boolean actual = testSet.remove("right");
        String actualArray = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertTrue(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void removeAllTest() {
        MySet<String> testSet = new MySet<>();
        testSet.add("This");
        testSet.add("right");
        testSet.add("here");

        HashSet<String> testSet2 = new HashSet<>();
        testSet2.add("right");
        testSet2.add("here");
        testSet2.add("This");

        String expectedArray = "[]";

        // When
        boolean actual = testSet.removeAll(testSet2);
        String actualArray = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertTrue(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void removeAllTest2() {
        MySet<String> testSet = new MySet<>();
        testSet.add("This");
        testSet.add("right");
        testSet.add("here");

        HashSet<String> testSet2 = new HashSet<>();
        testSet2.add("swag");
        testSet2.add("my");
        testSet2.add("is");

        String expectedArray = "[This, right, here]";

        // When
        boolean actual = testSet.removeAll(testSet2);
        String actualArray = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertFalse(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void retainAllTest() {
        MySet<String> testSet = new MySet<>();
        testSet.add("This");
        testSet.add("right");
        testSet.add("here");

        HashSet<String> testSet2 = new HashSet<>();
        testSet2.add("right");
        testSet2.add("here");
        testSet2.add("This");

        String expectedArray = "[This, right, here]";

        // When
        boolean actual = testSet.retainAll(testSet2);
        String actualArray = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertFalse(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void retainAllTest2() {
        MySet<String> testSet = new MySet<>();
        testSet.add("This");
        testSet.add("right");
        testSet.add("here");

        HashSet<String> testSet2 = new HashSet<>();
        testSet2.add("right");

        String expectedArray = "[right]";

        // When
        boolean actual = testSet.retainAll(testSet2);
        String actualArray = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertTrue(actual);
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    public void sizeTest() {
        // Given
        MySet<String> testSet = new MySet<>();
        testSet.add("This");
        testSet.add("right");
        testSet.add("here");
        int expected = 3;

        // When
        int actual = testSet.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toArrayTest() {
        // Given
        MySet<String> testSet = new MySet<>();
        testSet.add("This");
        testSet.add("right");
        testSet.add("here");
        String expected = "[This, right, here]";

        // When
        String actual = Arrays.toString(testSet.toArray());

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toArrayTest2() {
        // Given
        String[] arrayPassed = {"This", "right", "here"};
        MySet<String> testSet = new MySet<>();
        testSet.add("is");
        testSet.add("my");
        testSet.add("swag");
        String expected = "[This, right, here, is, my, swag]";

        // When
        String actual = Arrays.toString(testSet.toArray(arrayPassed));

        // Then
        Assert.assertEquals(expected, actual);
    }
}
