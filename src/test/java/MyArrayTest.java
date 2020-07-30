import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayTest 
{
    ArrayList<Integer> aList;
    @Before
    public void initializeAList()
    {
        aList = new ArrayList<Integer>();
    }
    MyArrayList<Integer>myList;
    @Before
    public void initialize()
    {
        myList = new MyArrayList<>();
    }

    @Test
    public void addTest()
    {
       
        aList.add(5);
        aList.add(10);
        myList.add(5);
       myList.add(10);

       Assert.assertEquals(aList.get(0), myList.get(0));
       Assert.assertEquals(aList.get(1), myList.get(1));
     
    }

    @Test
    public void addTest2()
    {
       
        aList.add(5);
        aList.add(15);
        aList.add(10);
        myList.add(5);
       myList.add(10);
       myList.add(1,15);

       Assert.assertEquals(aList.get(1), myList.get(1));
     
    }

    @Test
    public void getTest()
    {
        Integer expected = 5;

        myList.add(5);
        Integer actual = myList.get(0);
       
        assertEquals(expected, actual);
     
    }

    @Test
    public void addAllTest()
    {
        myList.add(4);
        myList.add(11);
        aList.add(5);
        aList.add(6);

        myList.addAll(aList);

        Integer expected = aList.get(0);
        Integer actual = myList.get(2);
        assertEquals(expected, actual);
    }

    @Test
    public void addAllTest2()
    {
        myList.add(1);
        myList.add(2);
        myList.add(5);
        myList.add(6);
        aList.add(3);
        aList.add(4);

        myList.addAll(2, aList);
        
        assertTrue(myList.get(2) == 3);
        assertTrue(myList.get(3) == 4);

        
    }

    @Test
    public void clearTest()
    {
        myList.add(3);
        myList.add(4);

        myList.clear();

        assertTrue(myList.size() == 0);
    }

    @Test
    public void cloneTest()
    {
        assertTrue(myList.clone() != myList);
    }

    @Test
    public void containsTrueTest()
    {
        myList.add(3);
        myList.add(4);
        myList.add(5);

        assertTrue(myList.contains(4));
    }

    @Test
    public void containsFalseTest()
    {
        myList.add(3);
        myList.add(4);
        myList.add(5);

        assertFalse(myList.contains(7));
    }

    @Test
    public void ensureCapacityTest()
    {
        myList.add(3);
        myList.add(4);
        myList.add(5);

        myList.ensureCapacity(4);
    }

    @Test
    public void indexOfTest()
    {
        myList.add(3);
        myList.add(4);
        myList.add(5);

        Integer expected = 2;
        Integer actual = myList.indexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTest()
    {
 
        assertTrue(myList.isEmpty());
    }

    @Test
    public void iterateTest()
    {
        myList.add(4);
        myList.add(5);
        myList.add(9);

        Iterator<Integer> iterator = myList.iterate();

        assertTrue(iterator.next() == 4);
        assertTrue(iterator.next() == 5);
        assertTrue(iterator.next() == 9);
    }

    @Test
    public void lastIndexOfTest()
    {
        myList.add(3);
        myList.add(4);
        myList.add(7);
        myList.add(4);
        myList.add(5);

        Integer expected = 3;
        Integer actual = myList.lastIndexOf(4);
        assertEquals(expected, actual);
    }

    @Test
    public void listIteratorTest()
    {
        myList.add(4);
        myList.add(5);
        myList.add(9);

        ListIterator<Integer> iterator = myList.listIterator();

        assertTrue(iterator.next() == 4);
        assertTrue(iterator.next() == 5);
        assertTrue(iterator.next() == 9);
    }

    @Test
    public void listIterator2Test()
    {
        myList.add(4);
        myList.add(5);
        myList.add(9);
        myList.add(11);
        myList.add(21);

        ListIterator<Integer> iterator = myList.listIterator(2);

        assertTrue(iterator.next() == 9);
        assertTrue(iterator.next() == 11);
        assertTrue(iterator.next() == 21);

        
    }

    @Test
    public void removeTest()
    {
        myList.add(4);
        myList.add(5);
        myList.add(9);
        myList.add(11);
        myList.add(21);

        Integer isTrue = myList.remove(2);
        assertTrue( isTrue == 9);
        
    }

    @Test
    public void removeTest2()
    {
        MyArrayList <String> myList = new MyArrayList<>();
        myList.add("4");
        myList.add("5");
        myList.add("9");
        myList.add("11");
        myList.add("21");

        assertTrue(myList.remove("11"));
    }

    @Test
    public void removeAllTest()
    {
    
        myList.add(4);
        myList.add(5);
        myList.add(11);
        myList.add(9);
        myList.add(11);
        myList.add(21);

        aList.add(11);
        aList.add(4);

        assertTrue(myList.removeAll(aList));
       
    }

    @Test
    public void removeFromRangeTest()
    {
    
        myList.add(4);
        myList.add(5);
        myList.add(11);
        myList.add(9);
        myList.add(12);
        myList.add(21);

        
        
        myList.removeRange(1, 3);
        assertTrue(myList.get(0) == 4);
        assertTrue(myList.get(1) == 12);
        assertTrue(myList.get(2) == 21);


    }

    @Test
    public void retainTest()
    {
        
        myList.add(4);
        myList.add(5);
        myList.add(11);
        myList.add(9);
        myList.add(12);
        myList.add(21);
        myList.add(11);
        
        aList.add(11);

        
        myList.retainAll(aList);
        assertTrue(myList.get(0) == 11);
        assertTrue(myList.get(1) == 11);
        


    }

    @Test
    public void setTest()
    {
        myList.add(4);
        myList.add(5);
        myList.add(11);

        myList.set(1, 1);

        assertTrue(myList.get(1) == 1);
    }

    @Test
    public void sizeTest()
    {
        myList.add(4);
        myList.add(5);
        myList.add(11);

        assertTrue(myList.size() == 3);
    }

    @Test
    public void subListTest()
    {

        myList.add(1);
        myList.add(2);
        myList.add(5);
        myList.add(8);

        List<Integer> list = myList.subList(2, 4);
        
        assertTrue(list.get(0) == 5);
        assertTrue(list.get(1) == 8);
        
        
    }

    @Test
    public void toArrayTest()
    {

        myList.add(1);
        myList.add(2);
        myList.add(5);
        myList.add(8);

        Object [] expected = myList.toArray();
        
        //Wanted to  putting assert in a for loop for once to see if it worked
        for (int i = 0; i < myList.size();i++)
        {
            assertTrue(expected[i] == myList.get(i));
        }
        
        
    }

    //Finish later
    @Test
    public void toArray2Test()
    {

        myList.add(1);
        myList.add(2);
        
       

        Integer [] expected = {12,13,14};
       expected = myList.toArray(expected);
       assertTrue(expected[0] == 1);
       assertTrue(expected[1] == 2);
       assertTrue(expected[2] == null);
    }

    @Test
    public void trimTest()
    {
        myList.add(1);
        myList.add(2);
        myList.add(null);
        myList.add(null);

        myList.trimToSize();
        
        assertTrue(myList.size()== 4);
    }

}