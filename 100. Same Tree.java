class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<Integer>();
        in(list1,p,0);
        List<Integer> list2 = new ArrayList<Integer>();
        in(list2,q,0);
        if(list1.equals(list2))
            return true;
        return false;
    }
    void in(List<Integer> l1,TreeNode node,int a){
        if(node==null)
            return;
        in(l1,node.left,a++);
        l1.add(node.val);
		//for differentiating trees having same values
        l1.add(a);
        in(l1,node.right,a++);
    }
}
