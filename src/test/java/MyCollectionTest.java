import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyCollectionTest {
    MyCollection <String> collection;

    @Before
    public void setup() {
        collection = new MyCollection<String>(3);
    }

    @Test
    public void sizeTest() {
        int expectedSize = 3;

        int actualSize = collection.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void listIsEmptyTest() {

        boolean actualValue = collection.isEmpty();

        assertTrue(actualValue);
    }

    @Test
    public void clearTest() {
        int expectedSize = 3;

        collection.clear();
        int actualSize = collection.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getExpansiveArrayTest() {
        int expectedSize = 3;

        Object[] arr = collection.getExpansiveArray();
        int actualSize = arr.length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setExpansiveArrayTest() {
        Object[] objectArr = new Object[1];

        collection.setExpansiveArray(new Object[2]);

        assertNotEquals(objectArr, collection.getExpansiveArray());
    }

    @Test
    public void getElementAtIndexTest() {
        String expected = "Peanut";

        //element will be null if I do not set it
        collection.setElementAtIndex(1, "Peanut");
        String actual = collection.getElementAtIndex(1);

        assertEquals(expected, actual);
    }

    @Test
    public void setElementAtIndexTest() {
        String expected = "Bob";

        collection.setElementAtIndex(0, "Bob");
        String actual = collection.getElementAtIndex(0);

        assertEquals(expected, actual);
    }

    @Test
    public void getCapacityTest() {
        int expectedSize = 0;

        int actualSize = collection.getCapacity();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setCapacityTest() {
        int expectedSize = 2;

        collection.setCapacity(2);
        int actualSize = collection.getCapacity();

        assertEquals(expectedSize, actualSize);
    }
}
