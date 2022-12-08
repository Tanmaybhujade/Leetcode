class Solution {
    public List<Integer> printDFS (TreeNode root) {
        Stack <TreeNode> stack = new Stack<>();
        List <Integer> sequence = new ArrayList<>();
        stack.push (root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n != null && n.left == null && n.right == null)
                sequence.add (n.val);           
            if (n.right != null) stack.push (n.right);
            if (n.left != null) stack.push (n.left);
        }
        return sequence;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List <Integer> list1 = printDFS (root1);
        List <Integer> list2 = printDFS (root2);
        return list1.equals (list2);
    }
}
