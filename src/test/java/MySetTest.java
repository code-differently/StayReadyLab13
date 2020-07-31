import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MySetTest {
    MySet<String> stringSetNoLength;
    MySet<Integer> intSetWithLength;

    @Before
    public void setup() {
        stringSetNoLength = new MySet<>();
        intSetWithLength = new MySet<>(3);
    }

    @Test
    public void mySetZeroArgConstructorSizeTest() {
        int expectedSize = 1;

        int actualSize = stringSetNoLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void mySetOneArgConstructorSizeTest() {
        int expectedSize = 3;

        int actualSize = intSetWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void sizeTest() {
        int expectedSize = 3;

        int actualSize = intSetWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addNoDuplicatesTest() {
        boolean addSuccessful = intSetWithLength.add(4);

        assertTrue(addSuccessful);
    }

    @Test
    public void addWithDuplicatesTest() {
        intSetWithLength.add(4);
        boolean addFailure = intSetWithLength.add(4);

        assertFalse(addFailure);
    }

    @Test
    public void clearTest() {
        int expectedSize = 3;

        intSetWithLength.clear();
        int actualSize = intSetWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void listIsEmptyTest() {

        boolean actualValue = intSetWithLength.isEmpty();

        assertTrue(actualValue);
    }

}
