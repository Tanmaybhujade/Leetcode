class Solution {
    
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        int windowEnd = 0;
        int minWindowSize = Integer.MAX_VALUE;
        
        int currentSum = 0;
        for(windowEnd = 0; windowEnd < nums.length; windowEnd++){
            currentSum += nums[windowEnd];
            while(currentSum >= target){
                minWindowSize = Math.min(minWindowSize, (windowEnd - windowStart +1));
                currentSum -= nums[windowStart];
                windowStart++;
            }
        }
        
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}
