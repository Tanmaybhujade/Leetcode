class Solution {
    private long get(int[] nums , int l , int r , int minK,  int maxK) {
        long ans = 0;
        int lastMinKIndex = - 1 , lastMaxKIndex = - 1;
        for (int i = l; i <= r; i++) {
            if (nums[i] == minK) {
                lastMinKIndex = i;
            }
            if (nums[i] == maxK) {
                lastMaxKIndex = i;
            }
            if (lastMaxKIndex >= 0 && lastMinKIndex >= 0) {
                int last = Math.min(lastMinKIndex , lastMaxKIndex);
                ans += (last - l + 1);
            }
        }
        return ans;
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int i , n = nums.length;
        for (i = 0; i < n; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                int l = i , r = i;
                while (i < n && (nums[i] >= minK && nums[i] <= maxK)) {
                    r = i;
                    i++;
                }
                i--;
                ans += get(nums , l , r , minK , maxK);
            }
        }
        return ans;
    }
}
