class Solution {
    public int kthGrammar(int n, int k) {
        // base case
        if (n == 1) {
            return 0;
        }
        
        // recursive step
        int parent = kthGrammar(n-1, (k+1)/2);
        
        // if k is odd, return the same value as parent
        // if k is even, return the complement of parent
        return k % 2 == 0 ? 1 - parent : parent;
    }
}
