import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest{
    MyArrayList<String> strArrListNoLength;
    MyArrayList<Integer> strArrListWithLength;

    @Before
    public void setup() {
        strArrListNoLength = new MyArrayList<>();
        strArrListWithLength = new MyArrayList<>(5);
    }

    @Test
    public void myArrayListOneArgSizeTest() {
        int expectedSize = 0;

        int actualSize = strArrListNoLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void myArrayListTwoArgSizeTest() {
        int expectedSize = 5;

        int actualSize = strArrListWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

//    @Test
//    public void setTest() {
//        int expectedReturnValue = 0;
//
//        intArrList.set(2, 46);
//        int actualSize = intArrList.;
//
//        assertEquals(expectedSize, actualSize);
//    }

    @Test
    public void getTest() {
        int expectedReturnValue = 0;

        int actualReturnValue = strArrListWithLength.get(2);

        assertEquals(expectedReturnValue, actualReturnValue);
    }
}
