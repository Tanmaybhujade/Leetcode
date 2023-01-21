public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s==null || s.length() < 4 || s.length() > 12) return res;
        helper(s, 0, res, new ArrayList<String>());
        return res;
    }
    
    public void helper(String s, int startIndex, List<String> res, List<String> path){
        if(path.size() == 4){
            if(startIndex == s.length()){
                String str = "";
                for(int i = 0; i < 4; i++){
                    str += path.get(i);
                    if(i != 3) str += '.';
                }
                res.add(str);
            }
            return;
        }
        
        for(int i = startIndex; i < startIndex + 3 && i < s.length(); i++){
            if(s.charAt(startIndex) == '0' && i != startIndex) break;
            String cur = s.substring(startIndex, i+1);
            if(Integer.valueOf(cur) <= 255){
                path.add(cur);
                helper(s, i+1, res, path);
                path.remove(path.size()-1);
            }
        }
    }
}
