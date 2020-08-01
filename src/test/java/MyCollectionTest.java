import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyCollectionTest {
    MyCollection <String> arrList;

    @Before
    public void setup() {
        arrList = new MyArrayList<String>(3);
    }

    @Test
    public void sizeTest() {
        int expectedSize = 3;

        int actualSize = arrList.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void listIsEmptyTest() {

        boolean actualValue = arrList.isEmpty();

        assertTrue(actualValue);
    }

    @Test
    public void clearTest() {
        int expectedSize = 3;

        arrList.clear();
        int actualSize = arrList.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getExpansiveArrayTest() {
        int expectedSize = 3;

        Object[] arr = arrList.getExpansiveArray();
        int actualSize = arr.length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setExpansiveArrayTest() {
        Object[] objectArr = new Object[1];

        arrList.setExpansiveArray(new Object[2]);

        assertNotEquals(objectArr, arrList.getExpansiveArray());
    }

    @Test
    public void getElementAtIndexTest() {
        String expected = "Peanut";

        //element will be null if I do not set it
        arrList.setElementAtIndex(1, "Peanut");
        String actual = arrList.getElementAtIndex(1);

        assertEquals(expected, actual);
    }

    @Test
    public void setElementAtIndexTest() {
        String expected = "Bob";

        arrList.setElementAtIndex(0, "Bob");
        String actual = arrList.getElementAtIndex(0);

        assertEquals(expected, actual);
    }

    @Test
    public void getCapacityTest() {
        int expectedSize = 0;

        int actualSize = arrList.getCapacity();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setCapacityTest() {
        int expectedSize = 2;

        arrList.setCapacity(2);
        int actualSize = arrList.getCapacity();

        assertEquals(expectedSize, actualSize);
    }
}
