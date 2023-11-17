class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        int sum=Integer.MIN_VALUE;
        Arrays.sort(nums);
       for(int i=0;i<n/2;i++){   //loop half of array
           sum=Math.max(sum,nums[i]+nums[n-i-1]); //store maxpair
       }
       
        return sum;
        }
}
