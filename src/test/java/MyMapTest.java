import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;




public class MyMapTest 
{
    MyMap<String,Integer>myMap;
    @Before
    public void initialize()
    {
        myMap = new MyMap<>();
    }

    @Test
    public void putTest()
    {

        myMap.put("hey", 0);
        myMap.put("it works", 5);
        myMap.put("hey",1);

        Integer expectedFirst = 5;
        Integer actualFirst = myMap.get("it works");

        Integer expectedSecond = 1;
        Integer actualSecond = myMap.get("hey");
        
        assertEquals(expectedFirst,actualFirst);
        assertEquals(expectedSecond,actualSecond);

    }

    @Test
    public void clearTest()
    {

        myMap.put("hey", 0);
        myMap.put("it works", 5);
        myMap.put("hey",1);

        myMap.clear();
        
        assertTrue(myMap.size() == 0);
    }

    @Test
    public void sizeTest()
    {

        myMap.put("hey", 0);
        myMap.put("it works", 5);
        myMap.put("hey",1);
        myMap.put("please", 2);
        myMap.put("it works", 7);
        
        assertTrue(myMap.size() == 3);
    }

    @Test
    public void getTest()
    {
        myMap.put("hey", 3);
        myMap.put("it works", 5);

        Integer expected = 3;
        Integer actual = myMap.get("hey");

        assertEquals(expected, actual);
    }

    @Test
    public void containsKeyTest()
    {
        myMap.put("hey", 3);
        assertTrue(myMap.containsKey("hey"));
    }

    @Test
    public void containsValueTest()
    {
        myMap.put("hey", 3);
        assertTrue(myMap.containsValue(3));
    }

    @Test
    public void hashCodeTest()
    {
        assertTrue(myMap.hashCode() > 0);
    }

    @Test
    public void isEmptyTest()
    {
        assertTrue(myMap.isEmpty());
    }

    @Test
    public void entrySetTest()
    {
        
        myMap.put("4", 4);
        myMap.put("Seven", 7);

        String expected = "[4=4, Seven=7]";
        
        Set<MyMapEntry<String,Integer>> test = myMap.entrySet();

        assertEquals(expected, test.toString());
        
    }

    @Test
    public void keySetTest()
    {
        
        myMap.put("4", 4);
        myMap.put("Seven", 7);

        String expected = "[4, Seven]";
        
        Set<String> test = myMap.keySet();

        assertEquals(expected, test.toString());
        
    }

    @Test
    public void putAllTest()
    {
        
        

       LinkedHashMap <String,Integer> adder = new LinkedHashMap<>();
        
       adder.put("Does",0);
       adder.put("this", 0);
       adder.put("work", 1);

       myMap.putAll(adder);

        assertTrue(adder.get("Does").equals(myMap.get("Does")));
        assertTrue(adder.get("this").equals(myMap.get("this")));
        assertTrue(adder.get("work").equals(myMap.get("work")));
        
    }

    @Test
    public void removeTest()
    {
        
        

       LinkedHashMap <String,Integer> adder = new LinkedHashMap<>();
        
       adder.put("Does",0);
       adder.put("this", 0);
       adder.put("work", 1);

       myMap.putAll(adder);

       Integer expected = 1;
        Integer actual = myMap.remove("work");

        assertEquals(expected, actual);
        
    }

    @Test
    public void valuesTest()
    {
        
        

       
        
       myMap.put("Does",0);
       myMap.put("this", 1);
       myMap.put("work", 5);

       Collection<Integer> expected = myMap.values();


        assertTrue(expected.contains(0));
        assertTrue(expected.contains(1));
        assertTrue(expected.contains(5));
        
    }

    @Test
    public void equalsTest()
    {
        myMap.put("Does",0);
       myMap.put("this", 1);
       myMap.put("work", 5);

       LinkedHashMap <String,Integer> test = new LinkedHashMap<>();
       test.put("Does",0);
       test.put("this", 1);
       test.put("work", 5);

       assertTrue(myMap.equals(test));

    }

    
}