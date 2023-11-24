class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        
        int result = 0;
        for(int M = n/3; M < n; M+=2){
            result += piles[M];
        }
        return result;    
    }
}
