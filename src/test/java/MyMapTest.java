import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class MyMapTest {

    @Test
    public void constructorTest1(){
        MyMap<String, Integer> map = new MyMap<>();

        int actual = map.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest2(){
        MyMap<String, Integer> map = new MyMap<>(15);

        int actual = map.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearTest(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("R", 25);
        map.put("B", 31);

        map.clear();
        int actual = map.size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsKeyTestTrue(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        boolean actual = map.containsKey("Beyonce");

        Assert.assertTrue(actual);
    }

    @Test
    public void containsKeyTestFalse(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        boolean actual = map.containsKey("H.E.R.");

        Assert.assertFalse(actual);
    }

    @Test
    public void containsValueTestTrue(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        boolean actual = map.containsValue(25);

        Assert.assertTrue(actual);
    }

    @Test
    public void containsValueTestFalse(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        boolean actual = map.containsValue(26);

        Assert.assertFalse(actual);
    }

    @Test
    public void putTest1(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);

        int actual = map.size();
        int expected = 3;

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void putTest2(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);
        map.put("Beyonce", 32);

        int actual = map.size();
        int expected = 3;

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getTest1(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);

        Integer actual = map.get("H.E.R.");
        Integer expected = 35;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest2(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);
        map.put("Beyonce", 32);

        Integer actual = map.get("Beyonce");
        Integer expected = 32;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void entrySetTest(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);

        String actual = map.entrySet();
        String expected = "[Rihanna=25, Beyonce=31, H.E.R.=35]";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void equalsTestTrue(){
        MyMap<String, Integer> map1 = new MyMap<>();
        map1.put("Rihanna", 25);
        map1.put("Beyonce", 31);

        MyMap<String, Integer> map2 = new MyMap<>();
        map2.put("Rihanna", 25);
        map2.put("Beyonce", 31);

        boolean actual = map1.equals(map2);

        Assert.assertTrue(actual);
    }

    @Test
    public void equalsTestFalse(){
        MyMap<String, Integer> map1 = new MyMap<>();
        map1.put("Rihanna", 25);
        map1.put("Beyonce", 31);
        map1.put("H.E.R.", 35);

        MyMap<String, Integer> map2 = new MyMap<>();
        map2.put("Ciara", 27);
        map2.put("Missy Elliot", 30);

        boolean actual = map1.equals(map2);

        Assert.assertFalse(actual);
    }

    @Test
    public void hashCodeTest(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);

        int actual = map.hashCode();
        int expected = 0;

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void isEmptyTestFalse(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);


        boolean actual = map.isEmpty();

        Assert.assertFalse(actual);
    }

    @Test
    public void isEmptyTestTrue(){
        MyMap<String, Integer> map = new MyMap<>();

        boolean actual = map.isEmpty();

        Assert.assertTrue(actual);
    }

    @Test
    public void keySetTest(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);

        String actual = map.keySet();
        String expected = "[Rihanna, Beyonce, H.E.R.]";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getOrDefaultTest(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        map.remove("Beyonce");
        int actual = map.getOrDefault("Beyonce", 45);
        int expected = 45;

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void putAllTest(){
        MyMap<String, Integer> map1 = new MyMap<>();
        map1.put("Rihanna", 25);
        map1.put("Beyonce", 31);
        map1.put("H.E.R.", 35);

        MyMap<String, Integer> map2 = new MyMap<>();
        map2.put("Ciara", 27);

        map1.putAll(map2);
        String actual = map1.entrySet();
        String expected = "[Rihanna=25, Beyonce=31, H.E.R.=35, Ciara=27]";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void putIfAbsentTest1(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        map.remove("Beyonce");
        Integer actual = map.putIfAbsent("Beyonce", 27);

        Assert.assertNull(actual);
    }

    @Test
    public void putIfAbsentTest2(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        Integer actual = map.putIfAbsent("Beyonce", 27);
        Integer expected = 31;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        Integer actual = map.remove("Rihanna");
        Integer expected = 25;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTestTrue(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);

        boolean actual = map.remove("Rihanna", 25);

        String actualM = map.entrySet();
        String expectedM = "[Beyonce=31]";

        Assert.assertTrue(actual);
        Assert.assertEquals(expectedM, actualM);
    }

    @Test
    public void removeTestFalse(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", null);
        map.put("Ciara", 27);

        boolean actual = map.remove("Beyonce", null);

        String actualM = map.entrySet();
        String expectedM = "[Rihanna=25, Ciara=27]";

        Assert.assertFalse(actual);
        Assert.assertEquals(expectedM, actualM);
    }

    @Test
    public void replaceTest1(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 28);
        map.put("Ciara", 27);

        Integer actual = map.replace("Ciara", 30);
        Integer expected = 27;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceTest2(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 28);
        map.put("Ciara", null);

        Integer actual = map.replace("Ciara", 30);

        Assert.assertNull(actual);
    }

    @Test
    public void replaceTestTrue(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 28);
        map.put("Ciara", 30);

        boolean actual = map.replace("Ciara", 30, 27);

        Assert.assertTrue(actual);
    }

    @Test
    public void replaceTestFalse(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 28);
        map.put("Ciara", 30);

        boolean actual = map.replace("Ciara", 28, 27);

        Assert.assertFalse(actual);
    }

    @Test
    public void valuesTest1(){
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Rihanna", 25);
        map.put("Beyonce", 31);
        map.put("H.E.R.", 35);

        String actual = map.values();
        String expected = "[25, 31, 35]";

        Assert.assertEquals(expected, actual);
    }
}