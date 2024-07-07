class Solution {
    public int numWaterBottles(int n, int k) {
        if (n < k) return n;
        return k + this.numWaterBottles(n - k + 1, k);
    }
}
