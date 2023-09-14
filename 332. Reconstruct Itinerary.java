class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> hm=new HashMap<>();
        
        List<String> res=new ArrayList<>();
        
        for(List<String> ticket: tickets){
            if(!hm.containsKey(ticket.get(0))){
                hm.put(ticket.get(0),new PriorityQueue<>());
            }
            
            PriorityQueue<String> pq=hm.get(ticket.get(0));
            pq.add(ticket.get(1));
            hm.put(ticket.get(0),pq);
        }
        
        dfs(hm,res,"JFK");
        
        return res;
        
    }
    
    public void dfs(HashMap<String,PriorityQueue<String>> hm, List<String> res, String str){
        
        while(hm.get(str)!=null && !hm.get(str).isEmpty()){
            String curr=hm.get(str).remove();
            
            dfs(hm,res,curr);
        }
        
        res.add(0,str);
    }
}
