class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return helper(coins, coins.length - 1, amount, dp);
    }

    private int helper(int[] coins, int index, int amount, int[][] dp) {
        if(index < 0) {
            if(amount == 0) return 1;
            else return 0;
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int count = 0;
        if(coins[index] <= amount) count += helper(coins, index, amount - coins[index], dp);
        count += helper(coins, index - 1, amount, dp);

        return dp[index][amount] = count;
    }
}
