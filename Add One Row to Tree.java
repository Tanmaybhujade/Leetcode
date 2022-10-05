class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root==null) return null;
        if (d==1) {
            TreeNode node= new TreeNode(v);
            node.left=root;
            return node;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=1;
        while(!q.isEmpty()){
           int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(level==d-1){
                    TreeNode tempL=cur.left;
                    TreeNode tempR=cur.right;
                    cur.left=new TreeNode(v,tempL,null);
                    cur.right=new TreeNode(v,null,tempR);
                }else{
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                }
            }
            level++;
        }
        return root;
    }
}
