import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyMapTest {
    MyMap<String, Integer> foundingDatesOfCompanies;
    @Before
    public void setup() {
        foundingDatesOfCompanies = new MyMap<>();
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
        assertTrue(foundingDatesOfCompanies.isEmpty());
    }

    @Test
    public void putTest() {
        int expectedSize = 1;
        foundingDatesOfCompanies.put("Square Enix", 1975);

        int actualSize = foundingDatesOfCompanies.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void containsKeyTest() {
        foundingDatesOfCompanies.put("Optum", 2011);
        assertTrue(foundingDatesOfCompanies.containsKey("Optum"));
    }

    @Test
    public void containsValueTest() {
        foundingDatesOfCompanies.put("Tesla", 2003);
        assertTrue(foundingDatesOfCompanies.containsValue(2003));
    }

    @Test
    public void getTest() {
        int expectedDate = 1976;

        foundingDatesOfCompanies.put("Apple", 1976);
        int actualDate = foundingDatesOfCompanies.get("Apple");

        Assert.assertEquals(expectedDate, actualDate);
    }

    @Test
    public void clearTest() {
        int expectedSize = 0;

        foundingDatesOfCompanies.put("Microsoft", 1975);
        foundingDatesOfCompanies.clear();
        int actualSize = foundingDatesOfCompanies.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeTest() {
        int expectedDate = 1923;

        foundingDatesOfCompanies.put("Disney", 1923);
        int actualDate = foundingDatesOfCompanies.remove("Disney");

        assertEquals(expectedDate, actualDate);
    }

    @Test
    public void keySetTest() {
        String expectedCompanyName = "Universal Pictures";

        foundingDatesOfCompanies.put("Universal Pictures", 1912);
        MySet <String> companies = foundingDatesOfCompanies.keySet();
        String actualCompanyName = companies.getElementAtIndex(0);

        assertEquals(expectedCompanyName, actualCompanyName);
    }
}
