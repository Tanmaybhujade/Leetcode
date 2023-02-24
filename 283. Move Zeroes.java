public class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        int ptrIndex = 0;
        while (ptrIndex < nums.length) {
            if (nums[ptrIndex] == 0) {
                ptrIndex++;
            } else {
                int tmp = nums[ptrIndex];
                nums[ptrIndex] = nums[nonZeroIndex];
                nums[nonZeroIndex] = tmp;
                nonZeroIndex++;
                ptrIndex++;
            }
        }
    }
}
