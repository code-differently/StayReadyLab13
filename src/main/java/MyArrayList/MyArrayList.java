package MyArrayList;

import Exceptions.IndexOutOfBoundsException;
import java.util.Arrays;

public class MyArrayList<E> {

    private E [] array;
    private E[] temp;
    private Integer size;
    private Integer nextEmptyLocation;



    public MyArrayList() {
        size = 10;
        array = (E[]) new Object[size];
        nextEmptyLocation = 0;
    }

    public MyArrayList(Integer size) {
        this.size = size;
        array = (E[]) new Object[this.size];
        nextEmptyLocation = 0;
    }

    public void add(E x) {

        if(nextEmptyLocation % 10 == 0 ) {
            size += size;
            temp = (E[]) new Object[size];
            for (int i = 0; i < array.length; i++) {

                temp[i] = array[i];
            }
            temp[nextEmptyLocation] = x;
            nextEmptyLocation++;
            array = temp;

        } else {

            array[nextEmptyLocation] = x;
            nextEmptyLocation++;
        }

    }

    public void add(int index, E x) {

        try{
            if (nextEmptyLocation < index) {

                throw new IndexOutOfBoundsException();
            }

            E holder = null;
            E holder2;
            for(int i = 0; i <= nextEmptyLocation; i++) {
                if ( (i > index)){

                    holder2 = array[i];
                    array[i] = holder;
                    holder = holder2;

                } else if (i == index){

                    holder = array[i];
                    array[i] = x;
                }
            }
            nextEmptyLocation++;
        } catch (IndexOutOfBoundsException e) {

            System.out.println("Invaild Index");
        }

    }

    public E get(int index){


        if (nextEmptyLocation < index) {

            return (E) new IndexOutOfBoundsException();

        } else {

            return array[index];
        }

    }

    public E remove(int index){

        if (nextEmptyLocation < index) {

            return (E) new IndexOutOfBoundsException();
        } else {
            E holder = array[index];
            for(int i = 0; i < nextEmptyLocation; i++) {
                if ( (i > index) || (i == index)) {

                    array[i] = array[i+1];
                }
            }
            nextEmptyLocation--;
            return  holder;
        }

    }

    public E set(int index, E replacement) {

        if (nextEmptyLocation < index) {

            return (E) new IndexOutOfBoundsException();
        } else {

            E holder = array[index];
            array[index] = replacement;

            return  holder;
        }

    }

    public void clear() {

        nextEmptyLocation = 0;
    }

    public boolean contains(E element) {

        for(int i = 0; i < nextEmptyLocation; i++) {

            if(array[i].equals(element)) {

                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {

        if(nextEmptyLocation == 0){

            return true;
        }

        return false;
    }

    public Integer size(){

        return nextEmptyLocation;
    }

    public String toString() {

        String out = "[";
        for(int i = 0; i < nextEmptyLocation; i++) {
            if (i == 0) {

                out += array[i];
            } else {

                out += " " + array[i];
            }
        }
        out += "]";

        return out;
    }

}
