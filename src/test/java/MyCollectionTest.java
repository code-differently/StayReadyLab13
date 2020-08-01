import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyCollectionTest {
    MyCollection <String> collection;

    @Before
    public void setup() {
        collection = new MyCollection<String>();
    }

    @Test
    public void getExpansiveArrayTest() {
        int expectedSize = 1;

        Object[] arr = collection.getExpansiveArray();
        int actualSize = arr.length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setExpansiveArrayTest() {
        int expectedSize = 0;

        int actualSize = collection.size();

        assertEquals(expectedSize, actualSize);
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
