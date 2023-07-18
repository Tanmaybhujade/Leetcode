class LRUCache {
    private int capacity;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            int value = (int)map.get(key);
            map.remove(key);
            map.put(key, value);
            
            return value; 
        }
        
        return -1;
    }
    
    public void put(int key, int value) { 
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
            
        } else {
            map.put(key, value);
            int size = map.size();
            
            if(size > capacity){
                int oldest_key = map.keySet().iterator().next();
                map.remove(oldest_key);
            }
        }
    }
}
