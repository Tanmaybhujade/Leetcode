class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans=0;
        if(root==null)
        {
            return 0;
        }
        if(root.val>=low&&root.val<=high)
        {
            ans=ans+root.val;
        }
        if(root.left!=null)
        { ans= ans+rangeSumBST(root.left,low,high);
        }
    if(root.right!=null)
        {
         ans= ans+rangeSumBST(root.right,low,high);
        }
        return ans;
    }
}
