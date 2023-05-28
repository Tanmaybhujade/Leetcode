class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length, dp[][] = new int[m+2][m+2];
        for(int cnt = 3; cnt <= m+2; ++cnt){//cnt: how many delimiters are included
            for(int e = (-1+(cnt-1)); e <= m; ++e){//cuts[-1...m]
                int s = (e-(cnt-1));
				//s: start index of delimiter, e: end index of delimiter in cuts array
                int len = (e==m?n:cuts[e])-(s<0?0:cuts[s]);//len: length of the stick to be cut
                dp[s+1][e+1] = Integer.MAX_VALUE;
                for(int i = s+1; i < e; ++i){//dp[0...m+1]
				    //dp maps [-1...m] cuts delimiter index range to [0...m+1] index range, all inclusive
                    dp[s+1][e+1] = Math.min(dp[s+1][e+1],len+dp[s+1][i+1]+dp[i+1][e+1]);
                }
            }
        }
        return dp[0][m+1];
    }
}
