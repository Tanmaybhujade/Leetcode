/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Long, Long> map = new HashMap<>();
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1L);
        traverse(root, 0L, (long)targetSum);
        return res;
    }
    public void traverse(TreeNode root, long currSum, long targetSum){
        if(root == null) return;
        currSum += root.val;
        res += map.getOrDefault(currSum - targetSum, 0L);
        map.put(currSum, map.getOrDefault(currSum, 0L) + 1);
        traverse(root.left, currSum, targetSum);
        traverse(root.right, currSum, targetSum);
        map.put(currSum, map.get(currSum) - 1);
    }
}
