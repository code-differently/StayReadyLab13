import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet<T> implements Collection<T>
{
    private MyArrayList <T> myArrayList = new MyArrayList<>();

    public MySet()
    {

    }

    public boolean add(T element)
    {
        if (!myArrayList.contains(element))
        {
            myArrayList.add(element);
            return true;
        }
            System.out.println("Element: "+element+" already contained in Set");
            return false;

        
    }

    public boolean addAll(Collection <? extends T> c)
    {
        boolean didChange = false;
        Object [] getC = c.toArray();
        for (int i = 0; i < getC.length;i++)
        {
            if (!myArrayList.contains((T)getC[i]))
            {
                myArrayList.add((T)getC[i]);
                didChange = true;
            }
        }


        return didChange;
    }

    public int size()
    {
        return myArrayList.size();
    }

    public void clear()
    {
        myArrayList.clear();
    }

    public boolean contains(Object object)
    {
        if (myArrayList.contains(object))
        {
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection <?> c)
    {
        boolean didContain = false;
        Object [] getC = c.toArray();
        for (int i = 0; i < getC.length;i++)
        {
            if (myArrayList.contains((T)getC[i]))
            {
                didContain = true;
            }
            else
            {
                didContain = false;
                return didContain;
            }
        }
        return didContain;
    }

    public boolean equals(Object ob)
    {
        if (ob instanceof Set)
        {
            if (((Set)ob).size() == myArrayList.size())
            {
                if (this.containsAll(((Set)ob)))
                {
                    return true;
                }
            }
            
        }
        return false;
    }

    
    public int hashCode()
    {
        return super.hashCode();
    }

    public boolean isEmpty()
    {
        if (myArrayList.isEmpty())
        {
            return true;
        }
        return false;
    }

    public Iterator<T> iterator()
    {
        return myArrayList.iterator();
    }

    public boolean remove(Object ob)
    {
        
        if (myArrayList.contains((T)ob))
        {
            myArrayList.remove((T)ob);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<?> c)
    {
        return myArrayList.removeAll(c);
    }

    public boolean retainAll(Collection<?> c)
    {
        return myArrayList.retainAll(c);
    }

    public Object [] toArray()
    {
        return myArrayList.toArray();
    }

    public <T> T[] toArray(T [] arr)
    {
        return myArrayList.toArray(arr);
    }
    

  
}