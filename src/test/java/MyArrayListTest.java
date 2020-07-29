import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayListTest {

    @Test
    public void defaultConstructorTest() {
        MyArrayList<String> obj = new MyArrayList<>();

        int expectedSize = 0;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void defaultConstructorTest2() {
        MyArrayList<String> obj = new MyArrayList<>(2);

        int expected = 2;

        assertEquals(expected, obj.size());
    }

    @Test
    public void addTest() {
        MyArrayList<String> obj = new MyArrayList<>(2);
        String expected = "test";

        obj.add(expected);

        assertEquals(expected, obj.get(2));
    }

    @Test
    public void addTest2() {
        MyArrayList<String> obj = new MyArrayList<>(6);
        String expected = "test";

        obj.add(1, expected);

        assertEquals(expected, obj.get(1));
    }

    @Test
    public void addAllTest() {
        MyArrayList<String> obj = new MyArrayList<>();
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(elems);
        int expectedSize = 3;

        assertEquals(expectedSize, obj.size());
    }

    @Test
    public void addAllTest2() {
        MyArrayList<String> obj = new MyArrayList<>(5);
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(2, elems);
        String expected = "hi";

        assertEquals(expected, obj.get(2));
    }

    @Test
    public void removeTest() {
        MyArrayList<String> obj = new MyArrayList<>(5);
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(2, elems);
        String expected = "hi";

        assertEquals(expected, obj.remove(2));
    }
    @Test
    public void removeTest2() {
        MyArrayList<String> obj = new MyArrayList<>(5);
        String[] stuff = {"hi", "bye", "sigh"};
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(stuff));

        obj.addAll(2, elems);
        obj.remove(2);
        String expected = "bye";

        assertEquals(expected, obj.get(2));
    }
}
