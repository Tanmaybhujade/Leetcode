class SnapshotArray {
    HashMap<Integer,Integer>[]maps;
    int snapId;
    HashMap<Integer,Integer>tempMap;
    
    public SnapshotArray(int length) {
        snapId=-1;
        maps=new HashMap[length];
        tempMap=new HashMap<>();
        
        //intialize
        for(int i=0; i<length; i++){
            maps[i]=new HashMap<>();
        }
    }
    
    public void set(int index, int val) {
        
        tempMap.put(index,val);
    }
    
    public int snap() {
        snapId++;
        for(Map.Entry<Integer,Integer>m:tempMap.entrySet()){
            maps[m.getKey()].put(snapId,m.getValue());
        }
        tempMap=new HashMap<>();
        return snapId;
    }
    
    public int get(int index, int snap_id) {
        while(snap_id>=0){
             if(maps[index].containsKey(snap_id))
                 return maps[index].get(snap_id);
            snap_id--;
        }
        return 0;
    }
}
