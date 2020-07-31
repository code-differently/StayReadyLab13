import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MySetTest 
{
    MySet<Integer>mySet;
    @Before
    public void intialize()
    {
        mySet = new MySet<>();
    }

    Set<Integer>set;
    @Before
    public void testSet()
    {
        set = new HashSet<>();
    }

    @Test
    public void addTest()
    {
        

        assertTrue(mySet.add(3));
        assertTrue(mySet.add(34));
       assertFalse(mySet.add(3));
    }

    @Test
    public void addAllTest()
    {

        set.add(3);
        set.add(34);
        set.add(3);

         mySet.addAll(set);

        assertTrue(mySet.size() == set.size());
    }

    @Test
    public void sizeTest()
    {
        mySet.add(3);
        mySet.add(34);
        mySet.add(3);

        


         int expectedSize = 2;

        assertTrue(mySet.size() == expectedSize);
    }

    @Test
    public void clearTest()
    {
        mySet.add(3);
        mySet.add(34);
        mySet.add(4);

        mySet.clear();

        


         int expectedSize = 0;

        assertTrue(mySet.size() == expectedSize);
    }

    @Test
    public void containsTest()
    {
        mySet.add(3);
        mySet.add(4);

        assertTrue(mySet.contains(3));
    }

    @Test
    public void containsAllTest()
    {
        set.add(2);
        set.add(4);
        
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);

        

        assertTrue(mySet.containsAll(set));
    }

    @Test
    public void equalsTest()
    {
        set.add(2);
        set.add(4);
        
        mySet.add(2);
        mySet.add(4);

   

        assertTrue(mySet.equals(set));
    }

    @Test
    public void hashCodeTest()
    {
        assertTrue(mySet.hashCode() != 0);
    }

    @Test
    public void isEmptyTrueTest()
    {
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void isEmptyFalseTest()
    {
        mySet.add(4);
        assertFalse(mySet.isEmpty());
    }

    @Test
    public void iterateTest()
    {
        mySet.add(4);
        mySet.add(5);
        mySet.add(6);


        Iterator<Integer> iterator = mySet.iterator();

        assertTrue(iterator.next() == 4);
        assertTrue(iterator.next() == 5);
        assertTrue(iterator.next() == 6);
    }

    @Test
    public void removeTest()
    {
        mySet.add(4);
        mySet.add(5);
        mySet.add(6);

        assertTrue(mySet.remove(5));
    }

    @Test
    public void removeAllTest()
    {
        set.add(4);
        set.add(6);

        mySet.add(4);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(6);

        assertTrue(mySet.removeAll(set));
        assertTrue(mySet.size() == 2);
    }

    @Test
    public void retainAllTest()
    {
        set.add(4);
        set.add(6);

        mySet.add(4);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(6);

        assertTrue(mySet.retainAll(set));
        assertTrue(mySet.size() == 2);
    }

    @Test
    public void toArrayTest()
    {
       

        mySet.add(4);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(6); 
        
        Object [] expected =  mySet.toArray();

        assertTrue((int)expected[0] == 4);
        assertTrue((int)expected[1] == 3);
        assertTrue((int)expected[2] == 5);
        assertTrue((int)expected[3] == 6);
    }

    @Test
    public void toArray2Test()
    {
       

        mySet.add(4);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(6); 
        
        Object [] expected = new Object[0];  
       expected = mySet.toArray(expected);

        assertTrue((int)expected[0] == 4);
        assertTrue((int)expected[1] == 3);
        assertTrue((int)expected[2] == 5);
        assertTrue((int)expected[3] == 6);
    }
}