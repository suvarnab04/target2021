package DataStructures;

class MyEntry<K,V>{
    private K key;
    private V value;
    private MyEntry<K,V> next;

    public MyEntry(K key, V value, MyEntry next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public K getKey(){
        return key;
    }
    public void setKey(K key){
        this.key = key;
    }
    public V getValue(){
        return value;
    }
    public void setValue(V value){
        this.value = value;
    }
    public MyEntry getNext(){
        return next;
    }
    public void setNext(MyEntry next){
        this.next = next;
    }
}


class MyHashMap {


    private int capacity = 16;


    MyEntry<Integer, Integer> [] map; //pick a prime number so that the data is distributed evenly
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new MyEntry[capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        MyEntry<Integer, Integer> entry = map[getIndex(key)];

        MyEntry<Integer, Integer> newEntry = new MyEntry(key, value, null);

        if(entry == null){ //key not present
            map[index] = newEntry;
        }else{ //collision happened, key is already in the map
            MyEntry<Integer, Integer> prev = null;
            MyEntry<Integer, Integer> currentNode = map[index];
            while(currentNode!=null){
                if(currentNode.getKey().equals(key)){ // sam ekey found then override the value
                    currentNode.setValue(value);
                    break;
                }
                prev = currentNode;
                currentNode = currentNode.getNext();
            }
            if(prev!=null){
                prev.setNext(newEntry);
            }
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int index = getIndex(key);
        MyEntry<Integer, Integer> entry = map[getIndex(key)];
        if(entry == null){
            return -1;
        }else{
            MyEntry<Integer, Integer> currEntry = entry;
            while(currEntry != null){
                if(currEntry.getKey().equals(key)){
                    return currEntry.getValue();
                }
                currEntry = currEntry.getNext();
            }
        }
        return -1;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int index = getIndex(key);
        MyEntry<Integer, Integer> entry = map[getIndex(key)];

        MyEntry<Integer, Integer> prev = null;
        MyEntry<Integer, Integer> currEntry = entry;

        //1. delete first entry
        //2. delete last entry
        //3. delete inbetween entry

        while(currEntry!=null){

            if(currEntry.getKey().equals(key)){
                if(prev == null){ //head
                    map[index] = currEntry.getNext();
                    return;
                }else{
                    prev.setNext(currEntry.getNext());
                    return;
                }
            }
            prev = currEntry;
            currEntry = currEntry.getNext();
        }

    }
    public int getIndex(int key){
        final int hashKey = 2069;
        return (key % hashKey) % capacity;
    }


}
/* //simple implementation with out collision handling//
class MyHashMap {


    public MyHashMap() {
        values = new Integer[2069];
    }


    public void put(int key, int value) {

        values[getIndex(key)] = value;
    }

     public int get(int key) {

        return values[getIndex(key)] != null ? values[getIndex(key)]  : -1;

    }

     public void remove(int key) {
        values[getIndex(key)] = null;
    }
    public static int getIndex(int key){
        return key % HASH_KEY;
    }

}*/
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
