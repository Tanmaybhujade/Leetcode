class Solution {
    public long totalEatingTime(int[] piles, int k){
        long hrs=0;
        for(int p: piles){
            hrs+=(long)Math.ceil((double)p/k);
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=0;
        for(int p: piles) maxPile=Math.max(maxPile, p);
        int lo=1;
        int hi=maxPile;
        int k=hi;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(totalEatingTime(piles, mid)<=h){
                k=Math.min(k, mid);
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }

        return k;
    }
}
