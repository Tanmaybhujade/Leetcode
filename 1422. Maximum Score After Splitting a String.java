class Solution {
    public int countones(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)-'0'==1) {
                ans++;
            }
        }
        return ans;
    }
    public int maxScore(String s) {
        int cntzeros = s.charAt(0)-'0'==0?1:0;
        int cntones = countones(s.substring(1));
        int ans = 0;
        for(int i=1;i<s.length();i++) {
            ans = Math.max(ans, cntzeros+cntones);
            if(s.charAt(i)-'0'==0) {
                cntzeros++;
            } else {
                cntones--;
            }
        }
        return ans;
         
    }
}
