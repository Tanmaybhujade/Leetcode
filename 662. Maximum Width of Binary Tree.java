class Solution {
    class Pair{
        TreeNode node;
        int i;
        public Pair(TreeNode node,int i){
            this.node=node;
            this.i=i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,1));
        int maxw=1;
        while(!q.isEmpty()){
            int size=q.size();
            int start=0,end=0;
            while(size-->0){
                Pair front=q.poll();
                if(start==0){
                    start=front.i;
                }
                end=front.i;
                if(front.node.left!=null){
                    q.add(new Pair(front.node.left,front.i*2));
                }
                if(front.node.right!=null){
                    q.add(new Pair(front.node.right,front.i*2+1));
                }
            }
            maxw=Math.max(maxw,end-start+1);
        }
        return maxw;
    }
}
