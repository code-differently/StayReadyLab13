import java.util.Collection;

public class MySet<T> {
    private T[] myArray;
    private int currentSize;

    public MySet(){
        this.myArray = (T[]) (new Object[0]);
        this.currentSize = 0;
    }
    public MySet(int size){
        this.myArray = (T[]) (new Object[size]);
        this.currentSize = size;
    }
    public int getCurrentSize(){
        return this.currentSize;
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
    public boolean add(T type){
        boolean toAdd = false;
        if(!this.contains(type)){
            toAdd = true;
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
        return toAdd;
    }
    public boolean containsAll(Collection<T> c){
        boolean doesContainAll = true;
        if(c.size() != this.currentSize){
            doesContainAll = false;
        }
        else {
            for (int i = 0; i < c.size(); i++) {
                if (!c.contains(this.myArray[i])) {
                    doesContainAll = false;
                }
            }
        }
        return doesContainAll;
    }
    public boolean addAll(Collection<T> c){
        boolean isAddAll = false;
        for(T type : c){
            isAddAll = this.add(type);
        }
        return isAddAll;
    }

}
