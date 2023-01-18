class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length == 0)    return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cur = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            cur += nums[i];
            if(cur > max)   max = cur;
            if(cur < 0) cur = 0;
        }
        cur = 0;
        for(int i = 0; i < nums.length; i++){
            cur += nums[i];
            if(cur < min)   min = cur;
            if(cur > 0) cur = 0;
        }
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum == min)  return max;
        return Math.max((sum-min) , max);
    }
}
