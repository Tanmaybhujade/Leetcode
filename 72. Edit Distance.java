public class Solution {
    public int minDistance(String _1, String _2) {
        int[][] dp = new int[_1.length()+1][_2.length()+1];
        for(int i = 0; i < _1.length(); i++) dp[i+1][0] = dp[i][0] + 1; 
        for(int j = 0; j < _2.length(); j++) dp[0][j+1] = dp[0][j] + 1; 
        for(int i = 0; i < _1.length(); i++){
            for(int j = 0; j < _2.length(); j++){
                dp[i+1][j+1] = Math.min(dp[i][j+1] + 1, dp[i+1][j] + 1);
                dp[i+1][j+1] = Math.min(dp[i+1][j+1] , dp[i][j] + (_1.charAt(i) == _2.charAt(j)? 0:1));
            }
        }
        return dp[_1.length()][_2.length()];
    }


    
}
