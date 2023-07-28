class Solution {
    public boolean PredictTheWinner(int[] arr) {
        
        int n=arr.length;
        
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int row=0,col=i;col<n;row++,col++){
                if(i==0){
                    dp[row][col]=arr[col];
                }
                else if(i==1){
                    dp[row][col]=Math.max(dp[row+1][col],dp[row][col-1]);
                }
                else{
                    dp[row][col]=Math.max(arr[row]+Math.min(dp[row+2][col],dp[row+1][col-1]),arr[col]+Math.min(dp[row][col-2],dp[row+1][col-1]));
                    
                }
            }
        }
        int sum=0;
        for(int x:arr)sum+=x;
        return dp[0][n-1]>=sum-dp[0][n-1];
    }
}
