
class Solution {
  
  private List<Integer> output = new ArrayList();
    
  public List<Integer> inorderTraversal(TreeNode root) {    
    return traverse(root);
  }
    
  private List<Integer> traverse(TreeNode root) {
    if (root == null) {
      return new ArrayList();
    }
    
    traverse(root.left);
    output.add(root.val);
    traverse(root.right);
    
    return output;
  }
}
