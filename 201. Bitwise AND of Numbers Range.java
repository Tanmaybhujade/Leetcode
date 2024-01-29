class Solution {
  
    // Function to find the bitwise AND of all numbers in the range [left, right]
    public int rangeBitwiseAnd(int left, int right) {
      
        // Keep iterating until the right value is greater than or equal to the left value
        while (left < right) {
            // Goal is to remove the least significant bit of 'right' by doing 'right' & (right - 1)
            // to reduce right. This is because we know if left < right, the least significant
            // bits will eventually become zero due to the range of AND operations before we reach 'left'.
            right &= (right - 1);
        }
      
        // By the end, 'right' is modified such that it represents the common bits of
        // all numbers in the range [left, right], thus the bitwise AND result.
        return right;
    }
}
