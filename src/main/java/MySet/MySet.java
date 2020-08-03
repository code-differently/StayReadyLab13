package MySet;

import MyArrayList.MyArrayList;

import java.util.Collection;
import java.util.Objects;

public class MySet<E> {

    private MyArrayList hashSet;

    public MySet() {

       hashSet = new MyArrayList();
    }

    public boolean add(E x) {

        if(!hashSet.contains(x)){

            hashSet.add(x);
            return true;
        }

        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        for(Object e: c) {

            hashSet.add(e);
        }

        return true;
    }

    public void clear() {

        hashSet.clear();
    }

    public boolean contains(Object x) {

        return hashSet.contains(x);
    }

    public boolean containsAll(Collection<?> c ){

        for(Object e: c) {

            if(!(hashSet.contains(e))){

                return false;
            }
        }

        return true;
    }


    public boolean equals(Object x) {

        if(x instanceof MySet && hashSet.size() == ((MyArrayList) x).size()) {

            return true;
        }

        return false;
    }

    public boolean remove(Object x) {

        for(int i = 0; i < hashSet.size(); i++){

            if( Objects.equals(hashSet.get(i), x) ){

                hashSet.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {

        return hashSet.isEmpty();
    }


    public Integer size() {

        return hashSet.size();
    }
    public String toString() {

        return hashSet.toString();
    }

    public Object[] toArray() {

        Object[] temp = new Object[hashSet.size()];
        for(int i = 0; i < hashSet.size(); i++) {

            temp[i] = hashSet.get(i);
        }

        return temp;
    }

    public <T> T[] toArray(T[] a) {

        Object[] temp = new Object[hashSet.size()];
        for(int i = 0; i < hashSet.size(); i++) {

            temp[i] = hashSet.get(i);
        }

        return (T []) temp;
    }




}
