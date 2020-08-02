import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;

public class MyMapTest {

    @Test
    public void defaultConstructorTest() {
        MyMap<String, Integer> obj = new MyMap<>();

        int expectedSize = 0;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void putTest() {
        MyMap<String, Integer> obj = new MyMap<>();
        String expectedK = "test";
        Integer expectedV = 1;

        obj.put(expectedK, expectedV);

        assertTrue(obj.containsKey(expectedK));
    }

    @Test
    public void putAllTest() {
        MyMap<String, Integer> obj = new MyMap<>();
        MyMap<String, Integer> stuff = new MyMap<>();

        stuff.put("hi", 1);
        stuff.put ("yo", 2);
        stuff.put("hola", 3);
        obj.putAll(stuff);
        int expectedSize = 3;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void clearTest() {
        MyMap<String, Integer> obj = new MyMap<>();

        obj.put("hi", 1);
        obj.put ("yo", 2);
        obj.put("hola", 3);
        obj.clear();
        int expectedSize = 0;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void containsTest() {
        MyMap<String, Integer> obj = new MyMap<>();

        String stringInserted = "hi";
        obj.put(stringInserted, 1);

        assertTrue(obj.containsKey(stringInserted));
    }

    @Test
    public void containsTest2() {
        MyMap<String, Integer> obj = new MyMap<>();

        String stringNotInserted = "5";
        obj.put("blah", 1);

        assertFalse(obj.containsKey(stringNotInserted));
    }

    @Test
    public void isEmptyTest() {
        MyMap<String, Integer> obj = new MyMap<>();

        obj.put("hi", 1);
        obj.put ("yo", 2);
        obj.put("hola", 3);

        assertFalse(obj.isEmpty());
    }

    @Test
    public void isEmptyTest2() {
        MyMap<String, Integer> obj = new MyMap<>();

        assertTrue(obj.isEmpty());
    }

    @Test
    public void removeTest() {
        MyMap<String, Integer> obj = new MyMap<>();

        obj.put("hi", 1);
        obj.put ("yo", 2);
        obj.put("hola", 3);
        obj.remove("yo");
        int expectedSize = 2;

        assertEquals(expectedSize, obj.size());
    }
}
