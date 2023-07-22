class Solution {
    int[][] directions = {{-2,-1}, {2,-1}, {-2,1}, {1,-2}, {-1,2}, {-1,-2}, {1,2}, {2,1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        
        return dyn(n,k,row,column, dp);
    }
    
    private double dyn(int n, int k, int r, int c, double[][][] dp){
        if(r<0 || r>=n || c<0 || c>=n) return 0;
        if(k == 0) return 1;
        if(dp[k][r][c] != 0.00) return dp[k][r][c];
        double prob = 0;
        
        for(int i=0; i<directions.length; i++){
            int[] dir = directions[i];
            prob += dyn(n, k-1, r+dir[0], c+dir[1], dp)/8.0;
        }
        dp[k][r][c] = prob;
        
        return dp[k][r][c];
        
    }
}
