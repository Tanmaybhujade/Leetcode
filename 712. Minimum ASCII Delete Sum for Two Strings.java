class Solution {
    
    public int minimumDeleteSum(String s1, String s2) {
        return minimumDeleteSumUtil(s1,s2);
    }
    public int minimumDeleteSumUtil(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0 ;i < s1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        minimumDeleteSum(s1,s2,s1.length()-1,s2.length()-1,dp);  
        return dp[s1.length()-1][s2.length()-1];
    }

    private int minimumDeleteSum(String s1,String s2,int i, int j,int[][] dp){
        if(i < 0 && j < 0){
            return 0;
        }
        if(i < 0 && j >= 0){
            int ans = 0;
            while(j>=0){
                ans = ans + s2.charAt(j--);
            }
            return ans;
        }

        if(j < 0 && i >= 0){
            int ans = 0;
            while(i>=0){
                ans = ans + s1.charAt(i--);
            }
            return ans;
        }    

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = minimumDeleteSum(s1,s2,i-1,j-1,dp);
            return dp[i][j];
        }else{
            dp[i][j] = Math.min(minimumDeleteSum(s1,s2,i-1,j,dp) + s1.charAt(i),
                    minimumDeleteSum(s1,s2,i,j-1,dp)+s2.charAt(j));
            return dp[i][j];
        }
    }
}
