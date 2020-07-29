import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest{
    MyArrayList<String> strArrList;
    MyArrayList<Integer> intArrList;

    @Before
    public void setup() {
        strArrList = new MyArrayList(String.class);
        intArrList = new MyArrayList(Integer.class, 5);
    }

    @Test
    public void myArrayListOneArgSizeTest() {
        int expectedSize = 0;

        int actualSize = strArrList.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void myArrayListTwoArgSizeTest() {
        int expectedSize = 5;

        int actualSize = intArrList.size();

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

        int actualReturnValue = intArrList.get(2);

        assertEquals(expectedReturnValue, actualReturnValue);
    }
}
