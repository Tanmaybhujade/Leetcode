class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root  == null ) {
            return false;
        }    
        return traverse(root, 0, sum);
    }
    
    boolean traverse(TreeNode root, int currentSum, int reqSum) {
        if(root == null) {
            return false;
        }
        currentSum += root.val;
        if(root.left == null && root.right == null) {
            return currentSum == reqSum;
        }
        
        boolean res = traverse(root.left, currentSum, reqSum);
        if(!res) {
            res = traverse(root.right, currentSum, reqSum);
        }
        return res;
    }
}
