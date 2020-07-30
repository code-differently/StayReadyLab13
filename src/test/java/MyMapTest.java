import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMapTest {

    @Test
    public void clearTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Yay!", 898);
        testMap.put("Whoa!", 212);

        // When
        testMap.clear();

        // Then
        Assert.assertEquals(0, testMap.size());
    }

    @Test
    public void containsKeyTestTrue() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Yay!", 898);
        testMap.put("Whoa!", 212);

        // When
        boolean actual = testMap.containsKey("Whoa!");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsKeyTestFalse() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Yay!", 898);
        testMap.put("Whoa!", 212);

        // When
        boolean actual = testMap.containsKey("Hey there!");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void containsValueTestTrue() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Yay!", 898);
        testMap.put("Whoa!", 212);

        // When
        boolean actual = testMap.containsValue(212);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsValueFalse() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Yay!", 898);
        testMap.put("Whoa!", 212);

        // When
        boolean actual = testMap.containsValue(1000);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void entrySetTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("LeBron", 6);
        testMap.put("Curry", 30);
        testMap.put("KD", 35);

        String expected = "[LeBron=6, Curry=30, KD=35]";

        // When
        Set<MyMapEntry<String, Integer>> testSet = testMap.entrySet();
        String actual = testSet.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        int expected = 45;

        // When
        testMap.put("Me", 27);
        testMap.put("Testing", 45);
        int actual = testMap.get("Testing");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTestTrue() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();

        // When
        boolean actual = testMap.isEmpty();

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void isEmptyTestFalse() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Test", 1);

        // When
        boolean actual = testMap.isEmpty();

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void keySetTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Test", 1);
        testMap.put("Shaq", 32);
        testMap.put("Larry", 33);
        testMap.put("Magic", 32);

        String expected = "[Test, Shaq, Larry, Magic]";

        // When
        Set<String> testSet = testMap.keySet();
        String actual = testSet.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void putTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        int expected = 27;
        int expectedSize = 1;

        // When
        Integer actualPrevious = testMap.put("Me", 27);
        int actual = testMap.get("Me");
        int actualSize = testMap.size();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertNull(actualPrevious);
    }

    @Test
    public void putTest2() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        int expected = 27;
        int expectedSize = 1;
        int expectedPrevious = 45;

        // When
        testMap.put("Me", 45);
        int actualPrevious = testMap.put("Me", 27);
        int actual = testMap.get("Me");
        int actualSize = testMap.size();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedPrevious, actualPrevious);
    }

    @Test
    public void putAllTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        Map<String, Integer> testMap2 = new HashMap<>();
        testMap2.put("Shaq", 32);
        testMap2.put("Larry", 33);
        testMap2.put("Magic", 32);

        int expectedSize = 3;

        // When
        testMap.putAll(testMap2);
        int actualSize = testMap.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void putAllTest2() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Shaq", 34);
        Map<String, Integer> testMap2 = new HashMap<>();
        testMap2.put("Shaq", 32);
        testMap2.put("Larry", 33);
        testMap2.put("Magic", 32);

        int expectedSize = 3;

        // When
        testMap.putAll(testMap2);
        int actualSize = testMap.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Michael Jordan", 23);
        testMap.put("Kobe", 24);
        int expectedPrevious = 24;

        // When
        int actualPrevious = testMap.remove("Kobe");

        // Then
        Assert.assertEquals(1, testMap.size());
        Assert.assertEquals(expectedPrevious, actualPrevious);
    }

    @Test
    public void removeTest2() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        testMap.put("Michael Jordan", 23);
        testMap.put("Kobe", 24);

        // When
        Integer actualPrevious = testMap.remove("MJ");

        // Then
        Assert.assertEquals(2, testMap.size());
        Assert.assertNull(actualPrevious);
    }

    @Test
    public void sizeTest() {
        // Given
        MyMap<String, Integer> testMap = new MyMap<>();
        int expectedSize = 2;

        // When
        testMap.put("Me", 27);
        testMap.put("Testing", 45);
        int actualSize = testMap.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void valuesTest() {
        // Given
        MyMap<String,Integer> testMap = new MyMap<>();
        testMap.put("LeBron", 6);
        testMap.put("Curry", 30);
        testMap.put("KD", 35);

        // When
        Collection<Integer> testCollection = testMap.values();
        boolean actual1 = testCollection.contains(6);
        boolean actual2 = testCollection.contains(30);
        boolean actual3 = testCollection.contains(35);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertTrue(actual3);
    }
}
