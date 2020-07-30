public class MySet<T> {
    private T[] set;
    int position;

    public MySet(){
        this.set=(T[]) new Object[0];
        this.position=0;
    }

    public MySet(int size){
        this.set=(T[]) new Object[size];
        this.position=0;
    }

    public int getSize(){
        return this.set.length;
    }

    public boolean isEmpty(){
        for (T item:
            this.set) {
            if(item!=null)
                return false;
        }
        return true;
    }

    public boolean add(T item){
        boolean isAdded=false;
        if(this.position==this.set.length && !contains(item)){
            isAdded=true;
            T[] newset=(T[]) new Object[this.set.length+1];
            this.position=0;

            for (int i = 0; i <this.set.length ; i++,position++) {
                newset[i]=this.set[i];
            }
            newset[position]=item;
            this.position++;
            this.set=newset;
        }
        else if(!contains(item)) {
            isAdded=true;
            this.set[position] = item;
            this.position++;
        }
        return isAdded;
    }

    public void remove(int index){
        if(index>=0 && index<this.set.length){
            T[] newset=(T[]) new Object[this.set.length-1];
            int temp=this.position;
            this.position=0;

            for (int i = 0; i <this.set.length ; i++,this.position++) {
                if(this.position==index)
                    i--;
                else
                    newset[i] = this.set[this.position];
            }
            this.position=temp-1;
            this.set=newset;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public boolean contains(T item){
        for (int i = 0; i <this.set.length ; i++) {
            if(this.set[i]==item)
                return true;
        }
        return false;
    }

    public void clear(){
        position=0;
        this.set=(T[]) new Object[0];
    }

    public int hashCode(){
        return this.set.hashCode();
    }

}
