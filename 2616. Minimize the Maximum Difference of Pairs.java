class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while(left < right){
            int mid = (left + right) / 2, count = 0;
            for(int i = 1; i < n; i++){
                if(nums[i] - nums[i - 1] <= mid){
                    count++;
                    i++;
                }
                if(count > p) break;
            }
            if(count < p) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
