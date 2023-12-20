class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int a=prices[0]+prices[1];
        int k=money-a;
        return (k<0)?money:k;
    
    }
}
