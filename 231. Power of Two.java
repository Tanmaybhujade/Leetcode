class Solution {
    public boolean isPowerOfTwo(int n) {
        
        // If you think about it - take 10 in binary as 1010 - here we get 2^1 + 2^3
        // So, if there was only one set bit in the binary of a number - then for sure it would have been a number which can be expressed as a power of 2
        
        // To check if a number has only one set bit - we can use the flip last LSB set concept here
        
        // if we apply n = n&(n-1) here it will flip the LSB set bit 
        // And then if the n results as 0 - our answer will be true, else false
        
        if(n<=0)    // any negative number cannot be a power of 2
        {
            return false;
        }

        n = n & (n-1);
        if(n == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
