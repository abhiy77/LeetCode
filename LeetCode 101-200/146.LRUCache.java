class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int capacity;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity,1,true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) return cache.get(key);
        else return -1;
    }
    
    public void put(int key, int value) {
         if(cache.containsKey(key)){
             cache.put(key,value);
         }
        else{
            if(cache.size()>= capacity){
                for(Map.Entry<Integer,Integer> entry : cache.entrySet()){
                cache.remove(entry.getKey());
                break;
            }
            }
            cache.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
