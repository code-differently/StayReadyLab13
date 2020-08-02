import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MySetTest {

    @Test
    public void defaultConstructorTest() {
        MySet<String> obj = new MySet<>();

        int expectedSize = 0;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void defaultConstructorTest2() {
        MySet<String> obj = new MySet<>(2);

        int expected = 2;

        assertEquals(expected, obj.size());
    }

    @Test
    public void addTest() {
        MySet<String> obj = new MySet<>(0);
        String expected = "test";

        obj.add(expected);

        assertTrue(obj.contains(expected));
    }

    @Test
    public void addAllTest() {
        MySet<String> obj = new MySet<>();
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(elems);
        int expectedSize = 3;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void clearTest() {
        MySet<String> obj = new MySet<>(5);

        obj.clear();
        int expectedSize = 0;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void containsTest() {
        MySet<String> obj = new MySet<>();

        String stringInserted = "5";
        obj.add(stringInserted);

        assertTrue(obj.contains(stringInserted));
    }

    @Test
    public void containsTest2() {
        MySet<String> obj = new MySet<>();

        String stringNotInserted = "5";
        obj.add("blah");

        assertFalse(obj.contains(stringNotInserted));
    }

    @Test
    public void containsAllTest() {
        MySet<String> obj = new MySet<>();
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(elems);
        int expectedSize = 3;

        assertTrue(obj.containsAll(elems));
    }

    @Test
    public void containsAllTest2() {
        MySet<String> obj = new MySet<>();
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.add("hi");
        int expectedSize = 3;

        assertFalse(obj.containsAll(elems));
    }

    @Test
    public void isEmptyTest() {
        MySet<String> obj = new MySet<>();
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(elems);

        assertFalse(obj.isEmpty());
    }

    @Test
    public void isEmptyTest2() {
        MySet<String> obj = new MySet<>(5);

        assertTrue(obj.isEmpty());
    }

    @Test
    public void removeTest() {
        MySet<String> obj = new MySet<>();
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(elems);
        String expected = "hi";

        assertTrue(obj.remove(expected));
    }
}
