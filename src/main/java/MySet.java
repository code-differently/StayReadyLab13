public class MySet<T> {
    private T[] myArray;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public MySet(){
        this.myArray = (T[]) (new Object[0]);
        this.currentSize = 0;
    }
    @SuppressWarnings("unchecked")
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
}
