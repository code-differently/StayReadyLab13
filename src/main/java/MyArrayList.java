
import java.lang.reflect.Array;
import java.lang.reflect.Type;

public class MyArrayList<T>{
    private T[] array;
    int position;

    public MyArrayList(){
        this.array=(T[]) new Object[0];
        this.position=0;
    }

    public MyArrayList(int size){
        this.array=(T[]) new Object[size];
        this.position=0;
    }

    public int getSize(){
        return this.array.length;
    }

    public boolean isEmpty(){
        for (T item:
             this.array) {
            if(item!=null)
                return false;
        }
        return true;
    }

    public T get(int index){
        return this.array[index];
    }

    public void add(T item){
        if(this.position==this.array.length){
            T[] newArray=(T[]) new Object[this.array.length+1];
            this.position=0;

            for (int i = 0; i <this.array.length ; i++,position++) {
                newArray[i]=this.array[i];
            }
            newArray[position]=item;
            this.position++;
            this.array=newArray;
        }
        else {
            this.array[position] = item;
            this.position++;
        }
    }

    public void add(T item,int index){
        if(index>=0 && index<this.array.length){
            T[] newArray=(T[]) new Object[this.array.length+1];
            int temp=this.position;
            this.position=0;

            for (int i = 0; i <newArray.length ; i++) {
                if(i==index)
                    newArray[i]=item;
                else {
                    newArray[i] = this.array[this.position];
                    this.position++;
                }
            }
            this.position=temp;
            this.array=newArray;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public void remove(int index){
        if(index>=0 && index<this.array.length){
            T[] newArray=(T[]) new Object[this.array.length-1];
            int temp=this.position;
            this.position=0;

            for (int i = 0; i <this.array.length ; i++,this.position++) {
                if(this.position==index)
                    i--;
                else
                    newArray[i] = this.array[this.position];
            }
            this.position=temp-1;
            this.array=newArray;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public boolean contains(T item){
        for (int i = 0; i <this.array.length ; i++) {
                if(this.array[i]==item)
                    return true;
        }
        return false;
    }

    public void clear(){
        position=0;
        this.array=(T[]) new Object[0];
    }

    public void set(int index,T item){
        this.array[index]=item;
    }

}
