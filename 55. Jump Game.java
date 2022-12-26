public class Solution {
    public boolean canJump(int[] nums) {
        int s=1;
        for(int i=0; i <nums.length-1; i++){
            if(s > 0){
                s = Math.max(s-1,nums[i]);
            }
        }
        if(s > 0) return true;
        return false;
    }
}
