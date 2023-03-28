class Solution {
public int mincostTickets(int[] days, int[] costs) {

    int cost30 = Integer.MAX_VALUE, cost7 = Integer.MAX_VALUE;
    int start7 = 0, start30 = 0;
    
    int dp[] = new int[days.length + 1];
    
    for(int i = 1; i <= days.length; i++){

        while(days[i-1] - days[start30] >= 30)
            start30++;
        cost30 = dp[start30] + costs[2];
        
        while(days[i-1] - days[start7] >= 7)
            start7++;   
        cost7 = dp[start7] + costs[1];
       
        dp[i] = Math.min(dp[i-1] + costs[0], Math.min(cost7, cost30));
        
    }
    
    return dp[days.length];
}
}
