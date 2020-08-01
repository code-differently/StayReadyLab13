import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyMapTest {
    MyMap<String, Integer> mapWithSize;
    @Before
    public void setup() {
        mapWithSize = new MyMap<>(2);
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

}
