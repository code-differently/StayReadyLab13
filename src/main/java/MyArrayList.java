import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<T> {

    private T[] myArray;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public MyArrayList(){
        this.myArray = (T[]) (new Object[0]);
        this.currentSize = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int size){
        this.myArray = (T[]) (new Object[size]);
        this.currentSize = size;
    }

    public int getCurrentSize(){
        return this.currentSize;
    }

    @SuppressWarnings("unchecked")
    public void add(T type, int index){
        if(!this.isEmpty() && (index < this.currentSize && index >= 0)) {
            T[] revamped = (T[]) (new Object[this.currentSize + 1]);
            for (int i = 0; i < this.currentSize + 1; i++) {
                if (i != index && i != this.currentSize) {
                    revamped[i] = this.myArray[i];
                } else if(i == index) {
                    revamped[i] = type;
                }else if(i == this.currentSize){
                    revamped[i] = this.myArray[i - 1];
                }
            }
            this.myArray = revamped;
            this.currentSize = myArray.length;
        }
    }

    @SuppressWarnings("unchecked")
    public void add(T type){
        T[] revamped = (T[]) (new Object[this.currentSize + 1]);
        if(this.isEmpty()){
            revamped[0] = type;
            this.myArray = revamped;
            this.currentSize = myArray.length;
        }
        else{
            for(int i = 0; i < this.currentSize + 1; i++){
                if(i != this.currentSize){
                    revamped[i] = this.myArray[i];
                }
                else{
                    revamped[i] = type;
                }
            }
            this.myArray = revamped;
            this.currentSize = myArray.length;
        }
    }

    public boolean isEmpty(){
        int numberOfNulls = 0;
        for(T type: this.myArray){
            if(type == null){
                numberOfNulls++;
            }
        }
        return numberOfNulls == this.myArray.length ? true : false;
    }

    @SuppressWarnings("unchecked")
    public void remove(int index){
        if(!this.isEmpty() && (index < this.currentSize && index >= 0)) {
            T[] revamped = (T[]) (new Object[this.currentSize - 1]);
            for(int i = 0; i < this.currentSize; i++){
                if(i != index && i != this.currentSize - 1){
                    revamped[i] = this.myArray[i];
                }else if(i == this.currentSize - 1){
                    revamped[i - 1] = this.myArray[i];
                }
            }
            this.myArray = revamped;
            this.currentSize = this.myArray.length;
        }
    }

    @SuppressWarnings("unchecked")
    public void remove(T type){
        if(!this.isEmpty()) {
            T[] revamped = (T[]) (new Object[this.currentSize - 1]);
            boolean isFound = false;
            for(int i = 0; i < this.currentSize; i++){
                if(this.myArray != type && i != this.currentSize - 1){
                    revamped[i] = this.myArray[i];
                } else if(this.myArray[i] == type){
                    isFound = true;
                } else if(!isFound && i != this.currentSize - 1){
                    revamped[i] = this.myArray[i];
                } else if(i == this.currentSize - 1){
                    revamped[i - 1] = this.myArray[i];
                }
            }
            this.myArray = revamped;
            this.currentSize = this.myArray.length;
        }
    }
    public T get(int index){
        return this.myArray[index];
    }
    public void set(int index, T type){
        this.myArray[index] = type;
    }
    @SuppressWarnings("unchecked")
    public void clear(){
        this.myArray = (T[]) (new Object[0]);
        this.currentSize = this.myArray.length;
    }
    public boolean contains(T type){
        boolean doesContain = false;
        for(int i = 0; i < this.currentSize; i++){
            if(this.myArray[i] == type){
                doesContain = true;
                break;
            }
        }
        return doesContain;
    }
}
