class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<words.length;i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq =
            new PriorityQueue<>((k1,k2)->{
                if(k2.getValue() > k1.getValue()){
                    return 1;
                }else if(k1.getValue() > k2.getValue()){
                    return -1;
                }else{
                    return k1.getKey().compareTo(k2.getKey());
                }
                });
        pq.addAll(hm.entrySet());
        int count = 0;
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty() && count!=k){
            Map.Entry<String,Integer> e = pq.poll();
            list.add(e.getKey());
            count++;
        }
        return list;
    }
}
