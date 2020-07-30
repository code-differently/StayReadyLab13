import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest{
    MyArrayList<String> intArrListNoLength;
    MyArrayList<Integer> intArrListWithLength;

    @Before
    public void setup() {
        intArrListNoLength = new MyArrayList<>();
        intArrListWithLength = new MyArrayList<>(5);
    }

    @Test
    public void myArrayListOneArgSizeTest() {
        int expectedSize = 0;

        int actualSize = intArrListNoLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void myArrayListTwoArgSizeTest() {
        int expectedSize = 5;

        int actualSize = intArrListWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

//    @Test
//    public void setTest() {
//        int expectedReturnValue = 46;
//
//        intArrListWithLength.set(2, 46);
//        int actualReturnValue = intArrListWithLength.get(2);
//
//        assertEquals(expectedReturnValue, actualReturnValue);
//    }

    @Test
    public void getTest() {
        int expectedReturnValue = 0;

        int actualReturnValue = intArrListWithLength.get(2);

        assertEquals(expectedReturnValue, actualReturnValue);
    }
}
