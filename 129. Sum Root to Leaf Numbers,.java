class Solution {
    public int sumNumbers(TreeNode root) {
        List<String>a=new ArrayList<>();
        dfs(root,a,"");
        System.out.println(a);
        int cnt=0;
        for(String i:a){
            cnt+=Integer.parseInt(i);
        }return cnt;
        
    }
    public void dfs(TreeNode node,List<String>a,String s){
        if(node==null)return;
        s+=node.val;
        if(node.left==null && node.right==null){a.add(s);s="";}
        dfs(node.left,a,s);
        dfs(node.right,a,s);
    }
}
