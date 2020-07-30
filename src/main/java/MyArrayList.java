import java.util.Arrays;

public class MyArrayList<E>
{
    private static final int ORIGINAL_CAPACITY = 10;

    private int size;
    private E[] elementData;

    public MyArrayList()
    {
        this(ORIGINAL_CAPACITY);
    }

    public MyArrayList(int capacity)
    {
        if(capacity <= 0)
        {
            throw new IllegalArgumentException("capacity must be positive: " + capacity);
        }

        size = 0;
        elementData = (E[]) (new Object[capacity]);
    }

    public void add(int index, E value)
    {
        checkIndex(index, 0, size);
        checkResize();

        for(int i = size; i > index; i--)
        {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = value;
        size++;
    }

    public E get(int index)
    {
        checkIndex(index, 0, size - 1);
        return elementData[index];
    }

    public boolean contains(E value)
    {
        for(int i = 0; i < size; i++)
        {
            if(elementData[i].equals(value))
            {
                return true;
            }
        }

        return false;
    }

    public void remove(int index)
    {
        checkIndex(index, 0, size - 1);
        for(int i = index; i <= size - 1; i++)
        {
            elementData[i] = elementData[i + 1];
        }

        size--;
    }

    public void set(int index, E value)
    {
        checkIndex(index, 0, size - 1);
        elementData[index] = value;
    }

    public int size()
    {
        return size;
    }

    private void checkResize()
    {
        if(size == elementData.length)
        {
            elementData = Arrays.copyOf(elementData, 2 * size);
        }
    }

    private void checkIndex(int index, int min, int max)
    {
        if(index < min || index > max)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
