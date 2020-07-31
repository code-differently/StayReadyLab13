import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest{
    MyArrayList<String> stringArrListNoLength;
    MyArrayList<Integer> intArrListWithLength;

    @Before
    public void setup() {
        stringArrListNoLength = new MyArrayList<>();
        intArrListWithLength = new MyArrayList<>(3);
    }

    @Test
    public void myArrayListZeroArgConstructorSizeTest() {
        int expectedSize = 1;

        int actualSize = stringArrListNoLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void myArrayListOneArgConstructorSizeTest() {
        int expectedSize = 3;

        int actualSize = intArrListWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void sizeTest() {
        int expectedSize = 3;

        int actualSize = intArrListWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addWithoutSpecifyingIndexTest() {
        int expectedValue = 24;

        intArrListWithLength.add(24);
        int actualValue = (int) intArrListWithLength.get(0);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addToSpecificIndexTest() {
        int expectedValue = 12;

        intArrListWithLength.add(2, 12);
        int actualValue = (int) intArrListWithLength.get(2);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addTillResizeTest() {
        int expectedNewSize = 6;

        intArrListWithLength.add(0, 5);
        intArrListWithLength.add(1, 3);
        intArrListWithLength.add(2, 4);
        intArrListWithLength.add(3, 7);
        int actualNewSize = intArrListWithLength.size();

        assertEquals(expectedNewSize, actualNewSize);
    }

    @Test
    public void setTest() {
        int expectedReturnValue = 46;

        intArrListWithLength.add(2, 34);
        intArrListWithLength.set(2, 46);
        int actualReturnValue = (int) intArrListWithLength.get(2);

        assertEquals(expectedReturnValue, actualReturnValue);
    }

    @Test
    public void getTest() {
        int expectedReturnValue = 6;

        intArrListWithLength.add(6);
        int actualReturnValue = (int) intArrListWithLength.get(0);

        assertEquals(expectedReturnValue, actualReturnValue);
    }

    @Test
    public void clearTest() {
        int expectedSize = 3;

        intArrListWithLength.clear();
        int actualSize = intArrListWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void listIsEmptyTest() {

        boolean actualValue = intArrListWithLength.isEmpty();

        assertTrue(actualValue);
    }

    @Test
    public void listIsNotEmptyTest() {

        intArrListWithLength.add(2);
        boolean actualValue = intArrListWithLength.isEmpty();

        assertFalse(actualValue);
    }

    @Test
    public void listContainsElementTest() {
        intArrListWithLength.add(5);
        boolean containsFive = intArrListWithLength.contains(5);

        assertTrue(containsFive);
    }

    @Test
    public void listDoesNotContainElementTest() {
        intArrListWithLength.add(4);
        boolean containsValue = intArrListWithLength.contains(5);

        assertFalse(containsValue);
    }

    @Test
    public void removeElementAtIndexTest() {
        int expectedElement = 1;

        intArrListWithLength.add(1);
        int actualElement = intArrListWithLength.remove(0);

        assertEquals(expectedElement, actualElement);
    }

    @Test
    public void removeSpecificElementWithoutKnowingIndexTest() {
        int expectedElement = 2;

        intArrListWithLength.add(1);
        intArrListWithLength.add(2);
        int actualElement = intArrListWithLength.removeElement(2);

        assertEquals(expectedElement, actualElement);
    }
}
