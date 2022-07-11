class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.addLast(root);
        while (!dq.isEmpty()) {
            res.add(dq.peekLast().val);
            
            Deque<TreeNode> tmp = new LinkedList<TreeNode>();
            while (!dq.isEmpty()) {
                TreeNode node = dq.removeFirst();
                if (node.left != null) tmp.addLast(node.left);
                if (node.right != null) tmp.addLast(node.right);
            }
            
            dq = tmp;
        }
        
        return res;
    }
}
