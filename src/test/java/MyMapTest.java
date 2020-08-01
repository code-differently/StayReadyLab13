import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyMapTest {
    MyMap<String, Integer> mapWithSize;
    @Before
    public void setup() {
        mapWithSize = new MyMap<>();
    }

    @Test
    public void constructorNoArgsTest() {
        MyMap<String, Integer> mapWithNoSize = new MyMap<>();;
        int expectedSize = 0;

        int actualSize = mapWithNoSize.size();

        assertEquals(expectedSize, actualSize);
    }

//    @Test
//    public void constructorPassingMapTest() {
//        MyMap<String, Integer> mapWithNoSize = new MyMap<>();;
//        int expectedSize = 0;
//
//        int actualSize = mapWithNoSize.size();
//
//        assertEquals(expectedSize, actualSize);
//    }

    @Test
    public void isEmptyTest() {
        assertTrue(mapWithSize.isEmpty());
    }

    @Test
    public void putTest() {
        mapWithSize.put("Square Enix", 12);
        
    }

    @Test
    public void containsKeyTest() {

    }
}
