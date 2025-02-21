class FindElements {
    Set<Integer> set ;
    public FindElements(TreeNode root) {
        root.val = 0 ; 
        set = new HashSet<>();
        set.add(0);
        recoverTree(root);
    }
    public boolean find(int target) {
        return set.contains(target);
    }
    public void recoverTree(TreeNode root){
        if(root == null){
            return ; 
        }
        if(root.left != null){
            root.left.val = root.val*2 + 1;
            set.add(root.left.val);
            recoverTree(root.left); 
        }
        if(root.right != null){
            root.right.val = root.val*2 + 2 ;
            set.add(root.right.val);
            recoverTree(root.right);
        }
        return ;
    }
}
