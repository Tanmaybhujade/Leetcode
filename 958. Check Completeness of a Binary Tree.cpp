class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        
        return leftCount + rightCount + 1;
    }
    public boolean validateTree(TreeNode root , int index , int nodesCount) {
        if(root == null) {
            return true;
        }
        
        if(index >= nodesCount) {
            return false;
        }
        
        boolean left = validateTree(root.left , 2 * index + 1 , nodesCount);
        boolean right = validateTree(root.right , 2 * index + 2 , nodesCount);
        
        return left && right;
    }
    public boolean isCompleteTree(TreeNode root) {
        int nodesCount = countNodes(root);
        int index = 0;
        return validateTree(root , index , nodesCount);
    }
}
