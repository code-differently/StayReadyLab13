import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest{
    MyArrayList<String> intArrListNoLength;
    MyArrayList<Integer> intArrListWithLength;

    @Before
    public void setup() {
        intArrListNoLength = new MyArrayList<>();
        intArrListWithLength = new MyArrayList<>(3);
    }

    @Test
    public void myArrayListOneArgSizeTest() {
        int expectedSize = 0;

        int actualSize = intArrListNoLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void myArrayListTwoArgSizeTest() {
        int expectedSize = 3;

        int actualSize = intArrListWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addWithoutSpecifyingIndexTest() {
        int expectedValue = 24;

        intArrListWithLength.add(24);
        int actualValue = intArrListWithLength.get(0);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addToSpecificIndexTest() {
        int expectedValue = 12;

        intArrListWithLength.add(2, 12);
        int actualValue = intArrListWithLength.get(2);

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
        int actualReturnValue = intArrListWithLength.get(2);

        assertEquals(expectedReturnValue, actualReturnValue);
    }

    @Test
    public void getTest() {
        int expectedReturnValue = 6;

        intArrListWithLength.add(6);
        int actualReturnValue = intArrListWithLength.get(0);

        assertEquals(expectedReturnValue, actualReturnValue);
    }
}
