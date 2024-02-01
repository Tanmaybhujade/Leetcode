class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        int counter = 0;
        
        for(int i = 0 ; i <= nums.length-3 ; i+=3){
            if(nums[i+2] - nums[i] <= k){
                ans[counter][0] = nums[i];
                ans[counter][1] = nums[i+1];
                ans[counter][2] = nums[i+2];
            }
            else{
                return new int[0][0];
            }
            counter++;
        }
        
        return ans;
    }
}
