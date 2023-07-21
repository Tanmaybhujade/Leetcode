class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        // for(int[] item : dp){
        //     Arrays.fill(item, 1);
        // }
        int max = 1;
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i = 1 ; i < nums.length ; i ++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            for(int j = i -1 ; j >= 0 ; j --){
                if(dp[i][0] > j  + 2) break;
                // 0th -> max len 1st-> count
                if(nums[i] > nums[j]){
                    if(dp[j][0] + 1 > dp[i][0]){
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }else if(dp[j][0] + 1 == dp[i][0]){
                        dp[i][1] += dp[j][1];
                    }
                }
            max = Math.max(max, dp[i][0]);
            }
        }
        int count = 0;
        for(int[] len : dp){
            if(len[0] == max) count += len[1];
        }
        return count;
    }
}
