class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
        if(s== null || s.length() == 0) return res;
        dfs(res, s, new ArrayList<String>() , 0);
        return res;
    }
    
    public void dfs(List<List<String>> res, String s, List<String> cur, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(cur));
        }
        for(int i = index; i < s.length(); i++){
            String tmp = s.substring(index, i + 1);
            if(isValid(tmp)){
                cur.add(tmp);
                dfs(res, s, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public boolean isValid(String s){
        int start =0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
