public class Solution {
    List<Integer> list;
    
    public boolean findTarget(TreeNode root, int k) {
        
        list = new ArrayList<Integer>();
        inorder(root);
        int left = 0;
        int right = list.size() - 1;

        while(left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else
                right--;
        }
        
        return false;
    }
    
    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}
