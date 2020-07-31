import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.lang.ArrayUtils;

public class MyArrayList<T> implements Collection<T>
{
   private Object [] storage = new Object[0];

    public MyArrayList()
    {

    }

    public MyArrayList(int size)
    {
        storage = new Object[size];
    }

    public T get(int i)
    {
        return (T)(storage[i]);
    }
    
    @Override
    public boolean add(T element)
    {
        Object [] temp = storage;
        if (storage.length == 0)
        {
            storage = new Object[1]; 
        }
        else
        {
            
            storage = new Object[storage.length+1]; 
        }
        
        storage[storage.length-1] = element;
        for (int i = 0; i < temp.length;i++)
        {
           storage[i] = temp[i];
        }
        
       return true;
        
    }

    public void add(int index,T element)
    {
        Object [] newArray = new Object[storage.length+1];
        for (int i = 0; i < index;i++)
        {
            newArray[i] = storage[i];
        }
        newArray[index] = element;
        for (int i = index; i < storage.length;i++)
        {
            newArray[i+1] = storage[i];
        }

        storage = newArray;
    }

    @Override
    public boolean addAll(Collection<? extends T>c)
    {
        Object [] returnArray = new Object[storage.length+c.size()];
        Object [] newArray = c.toArray();
        for (int i = 0; i < storage.length;i++)
        {
            returnArray[i] = storage[i];
        }
        for (int i = 0; i < newArray.length;i++)
        {
           returnArray[i+storage.length] = newArray[i];
        }

        storage = returnArray;
        return false;
    }

    public boolean addAll(int index,Collection<T>c)
    {
        Object [] returnArray = new Object[storage.length+c.size()];
        Object [] newArray = c.toArray();
        //Add elements from original before index
        for (int i = 0; i < index;i++)
        {
            returnArray[i] = storage[i];
        }
        //Add elements from elements from collection
        for (int i = 0; i < newArray.length;i++)
        {
           returnArray[i+index] = newArray[i];
        }
        //Add remaining elements from original
        for (int i = index; i < storage.length;i++)
        {
            returnArray[newArray.length+i] = storage[i];
        }

        storage = returnArray;
        return false;
    }


    public void clear()
    {
        storage = new Object[0];
    }

    public Object clone()
    {
        return storage.clone();
    }

    @Override
    public boolean contains(Object object)
    {
        for (int i = 0; i < storage.length;i++)
        {
            if (storage[i].equals(object))
            {
                return true;
            }
        }

        return false;
    }

    public void ensureCapacity(int min)
    {
        if (storage.length < min)
        {
            System.out.println("Storage inadequate, increasing storage by "+min);
            Object [] temp = storage;
            storage = new Object[storage.length+min];
            for (int i = 0; i < temp.length;i++)
            {
                storage[i] = temp[i];
            }
        }
        else
        {
            System.out.println("Storage is adequate");
        }

    }

    public int indexOf(T object)
    {
        for (int i = 0; i < storage.length;i++)
        {
            if (storage[i].equals(object))
            {
                return i;
            }
            
        }
        return -1;
    }

    public boolean isEmpty()
    {
        if (storage.length == 0)
        {
            return true;
        }
        return false;
    }

    public Iterator<T> iterator()
    {
       return (Iterator<T>)Arrays.stream(storage).iterator();
       
    }

    public int lastIndexOf(T object)
    {
        int lastIndex = -1;
        for (int i = 0; i < storage.length;i++)
        {
            if (storage[i] == object)
            {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public ListIterator<T> listIterator()
    {
       return (ListIterator<T>)Arrays.asList(storage).listIterator();
    }

    public ListIterator<T> listIterator(int index)
    {
       return (ListIterator<T>)Arrays.asList(storage).listIterator(index);
    }

    public T remove(int index)
    {
        T removed = (T)storage[index];
        storage = ArrayUtils.remove(storage, index);
        return removed;
    }

    @Override
    public boolean remove(Object element)
    {
       for (int i = 0; i < storage.length;i++)
       {
           if (storage[i] == element)
           {
                storage = ArrayUtils.remove(storage, i);
                return true;
           }
       }
        return false;
    }

    @Override
    public boolean removeAll(Collection <?> c)
    {
        boolean didRemove = false;
       for (int i = 0; i < storage.length;i++)
       {
           if (c.contains(storage[i]))
           {
            storage = ArrayUtils.remove(storage, i);
            i = -1;
            didRemove = true;
           }
       }
        return didRemove;
    }

    protected void removeRange(int from,int to)
    {
        
        if (from < to && to < storage.length && from < storage.length)
        {
            Object [] newArray = new Object[0];
            for (int i = 0; i < storage.length;i++)
            {
                if (!(i >= from && i <= to))
                {
                   newArray = ArrayUtils.add(newArray, storage[i]);
                }
            }
            storage = newArray;
        }
        else
        {
            System.out.println("Starting position can't be higher than end position");
        }
       
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        boolean didRetain = false;
        for (int i = 0; i < storage.length;i++)
        {
            if (!(c.contains(storage[i])))
            {
                storage = ArrayUtils.remove(storage, i);
                i = -1;
                didRetain = true;
            }
        }

        return didRetain;
    }


    public T set(int index, T element)
    {
        if (storage[index] != null)
        {
            storage[index] = element;
        }
        else
        {
            System.out.println("This element is empty, add to the first");
        }
        


        return element;
    }

    public int size()
    {
        return storage.length;
    }

    public List<T> subList(int fromIndex, int toIndex)
    {
        return (List<T>)Arrays.asList(storage).subList(fromIndex, toIndex);
    }

    public Object [] toArray()
    {
        return storage;
    }

    @Override
    public <T>T[] toArray(T[] input)
    {
        
        if (input.length < storage.length)
        {
           
            input = (T[])new Object[storage.length];
            
        }
       
        for (int i = 0; i < storage.length;i++)
        {
               input[i] = (T)storage[i]; 
            
        }
        for (int i = storage.length; i < input.length;i++)
        {
               input[i] = null; 
            
        }

        return input;



        
    }

    public void trimToSize()
    {
       int oldCapacity = storage.length;
       if (size() < oldCapacity)
       {
           storage = Arrays.copyOf(storage, size());
       }
    }

    @Override
    public boolean containsAll(Collection<?> c) 
    {
        for (Object get : c)
        {
            if (!contains(get))
            {
                return false;
            }
        }
        return true;
    }
        
    

   

    
    
}