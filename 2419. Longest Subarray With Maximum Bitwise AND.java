class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int count = 0;
        int res = 0;
        for (int n : nums) {
            if (n > maxi) {
                maxi = n;
                count = 1;
                res = 1;
            } else if (n == maxi) {
                count++;
                res = Math.max(count, res);
            } else {
                count = 0;
            }
        }
        return res;
    }
}
