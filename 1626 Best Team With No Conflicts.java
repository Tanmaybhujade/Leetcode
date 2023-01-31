class Solution {
      // Question is -> Maximum Sum Increasing Subsequence
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        if(n == 1)  return scores[0];
        int [][] team = new int[n][n];
        
        for(int i = 0; i < n; i++){
            int age = ages[i];
            int score = scores[i];
            
            team[i][0] = age;
            team[i][1] = score;
        }
        
        Arrays.sort(team, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int [] dp = new int[n]; // Dp -> longest Increasing Subsequnce Array
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            int maxSum = 0;
            for(int j = 0; j < i; j++){
                if(team[j][1] <= team[i][1]){
                    maxSum = Math.max(maxSum, dp[j]);
                }
            }
            dp[i] = maxSum + team[i][1];
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
}       
