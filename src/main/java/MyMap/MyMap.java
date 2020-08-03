package MyMap;

import MyArrayList.MyArrayList;

import java.util.Objects;

public class MyMap<K, V> {

    private MyArrayList mapKeys;
    private MyArrayList mapValues;

    public MyMap() {

        mapKeys = new MyArrayList();
        mapValues = new MyArrayList();
    }

    public V put(K key, V value) {

        V temp;
        if(mapKeys.size() <= 0) {

            temp = get(key);
            mapKeys.add(key);
            mapValues.add(value);
            return temp;
        }

        return null;
    }

    public V get(K key) {

        for(int i = 0; i < mapKeys.size(); i++ ){

            if(Objects.equals(mapKeys.get(i), key)){

                return (V) mapValues.get(i);
            }
        }

        return null;
    }
    public V remove(K key) {

        for(int i = 0; i < mapKeys.size(); i++ ){

            if(Objects.equals(mapKeys.get(i), key)){
                V out = (V) mapValues.remove(i);
               mapKeys.remove(i);
               mapValues.remove(i);
               return out;
            }
        }

        return null;
    }

    public void clear() {

        mapKeys.clear();
        mapValues.clear();

    }

    public Integer size(){

        return mapKeys.size();
    }


    public Boolean containsKey(K key) {

        for(int i = 0; i < mapKeys.size(); i++ ){

            if(Objects.equals(mapKeys.get(i), key)){

                return true;
            }
        }

        return false;
    }

    public Boolean isEmpty() {

        return mapKeys.isEmpty();
    }

    public String toString(){

        return mapKeys.toString() + '\n' + mapValues.toString();
    }

}
