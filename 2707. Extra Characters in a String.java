class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet();
        for(String str:dictionary){
            set.add(str);
        }
        int DP[] = new int[s.length()+1];
        for(int i=s.length()-1; i>=0; i--){
            int ans = 0;
            for(int j=i; j<s.length(); j++){
                String str = s.substring(i,j+1);
                if(set.contains(str)){
                    ans = Math.max(str.length()+DP[j+1], ans);
                }
            }
            if(ans==0){
                DP[i] = DP[i+1];
            }
            else{
                DP[i] = Math.max(DP[i+1],ans);
            }
        }
        return s.length()-DP[0];
    }
}
