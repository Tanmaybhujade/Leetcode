class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap();
        int sz = 0;
        
        for(String w : words){    
                String rev = new StringBuilder(w).reverse().toString();
                if(map.containsKey(rev)){
                    sz += 4;
                    if(map.get(rev)==1){
                        map.remove(rev);
                    }else{
                        map.put(rev, map.get(rev)-1);
                    }
                }else{
                    map.put(w,map.getOrDefault(w, 0)+1);
                }
        }
            
        for (String key : map.keySet()) {
            Integer value = map.get(key);
                if(key.charAt(0)==key.charAt(1)){
                    sz += 2;
                    break;
                }
        }    
        
        return sz;        
    }
}
