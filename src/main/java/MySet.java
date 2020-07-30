
public class MySet<E>
{
    public int size;
    public HashNode<E>[] table;

    /*
     * Constructs a new HashSet using the given size
     */
    public MySet(int size) {
        table = (HashNode<E>[]) new HashNode[size];
    }
    public MySet()
    {
        //default
        table = (HashNode<E>[]) new HashNode[10];
    }
    /*
     * Adds the given element to this HashSet
     * Returns true if the addition was successful
     */
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        int i = hash(e);
        table[i] = new HashNode<E>(e, table[i]);
        size++;
        return true;
    }

    /*
     * Returns true if the given element is contained in this HashSet
     * and false otherwise
     */
    public boolean contains(E e) {
        int i = hash(e);
        HashNode<E> current = table[i];
        while (current != null) {
            if (current.data.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /*
     * Removes the given element from this HashSet
     * Returns true if the removal was successful
     */
    public boolean remove(E e) {
        if (!contains(e)) {
            return false;
        }
        int i = hash(e);
        if (table[i].data.equals(e)) {
            table[i] = table[i].next;
        } else {
            HashNode<E> current = table[i];
            while (!current.next.data.equals(e)) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        return true;
    }

    /*
     * Returns the size of this HashSet
     */
    public int size() {
        return size;
    }

    /*
     * Returns true if this HashSet is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Returns the hash of the given element
     */
    private int hash(E e) {
        return Math.abs(e.hashCode()) % table.length;
    }

    /*
     * Represents a single node in the chain in the hash table
     */
    private static class HashNode<E> {
        public E data;
        public HashNode<E> next;

        /*
         * Constructs a new node with the given value and next link
         */
        public HashNode(E data, HashNode<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}