public class Solution {
    public void rotate(int[] nums, int k) {
        //Inspired by Tang:)
        if(nums == null || k < 1 || nums.length < 2){
            return;
        }
        int len = nums.length;
        k = k % len;//Make sure k<len
        //First, we divided our array nums = [a_1,a_2,...,a_(len-k),b_1,b_2,...,b_k] into two parts,
        //A = [a_1,a_2,...,a_(len - k)] and B = [b_1,b_2,...,b_k]
        
        //Reverse A and B separately, O(n)
        for(int i = 0; i < (len-k)/2; i++){
            nums[i] ^= nums[len-k-1-i];
            nums[len-k-1-i] ^= nums[i];
            nums[i] ^= nums[len-k-1-i];
        }
        for(int i = 0; i < k/2; i++){
            nums[len-k+i] ^= nums[len-1-i];
            nums[len-1-i] ^= nums[len-k+i];
            nums[len-k+i] ^= nums[len-1-i];
        }
        //Now, A = [a_(len-k),a_(len-k-1),...,a_2,a_1]; B = [b_k,b_(k-1),...,b_2,b_1].
        //nums = [a_(len-k),a_(len-k-1),...,a_2,a_1,b_k,b_(k-1),...,b_2,b_1].
        
        //Reverse current nums, O(n)
        for(int i = 0; i < len/2; i++){
            nums[i] ^= nums[len-1-i];
            nums[len-1-i] ^= nums[i];
            nums[i] ^= nums[len-1-i];
        }
    }
}
