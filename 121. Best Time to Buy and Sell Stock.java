public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int cur = 0;
        for(int i = 1; i < prices.length; i++){
            int tmp = prices[i] - prices[i - 1];
            cur = cur > 0 ? cur + tmp : tmp;
            sum = sum > cur ? sum : cur;
        }
        return sum;
    }
}
