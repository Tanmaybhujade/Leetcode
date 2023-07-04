
class Solution {
    public int singleNumber(int[] nums) {
        int o = 0, t = 0;
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            // int oo = ((~t) & o & (~x)) | ((~t) & (~o) & x); // position of this statement doesn't matter
            int tt = (t & (~o) & (~x)) | ((~t) & o & x);
            int oo = ((~t) & o & (~x)) | ((~t) & (~o) & x);
            
            o = oo;
            t = tt;
        }
        return o;  
    }
}
