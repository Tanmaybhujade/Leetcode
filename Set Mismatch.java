class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        for(int i = 0; i<nums.length;){
            if(nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
            else i++;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=i+1){
                arr[0] = nums[i];
                arr[1] = i+1;
            }
        }
        
        return arr;
    }
    
    public void swap(int[]nums, int first , int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
