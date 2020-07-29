public class MyMap {
    public class Pair<F,S>{
        private F first;
        private S second;

        public Pair(){
            first= null;
            second=null;
        }
        public Pair(F first, S second){
            this.first=first;
            this.second=second;
        }
        public void setFirst(F newValue){first=newValue;}
        public void setSecond(S newValue){second= newValue;}
    }
}
