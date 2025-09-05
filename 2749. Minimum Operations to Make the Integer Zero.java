class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
     for (int k = 1; k <= 60; k++) {
            long remain = (long) num1 - (long) k * num2;
            if (remain < k) continue;
            if (Long.bitCount(remain) <= k) return k;
        }
        return -1;   
    }
}
