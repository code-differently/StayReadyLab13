public class MyArrayList {
    public class myList<T>{
        private T element;
        public T get(){
            return element;
        }
        public void put(T item){
            element=item;
        }
        public myList(){
            element=null;
        }
        public myList(T element){
            this.element=element;
        }

        public void setElement(T element) {
            this.element = element;
        }
        //get all elemnts list separated by a coma
        public <T> T[] getMyList(T...a){
            return a;
        }
        public 

    }
}
