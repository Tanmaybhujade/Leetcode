class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       return buildTree(inorder,postorder,0,inorder.length-1,postorder.length-1);
    }
     public TreeNode buildTree(int[] inorder, int[] postorder,int inStart, int inEnd,int postEnd){
     if (postEnd < 0 || inEnd < inStart) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i =inStart; i <=inEnd; i++){
            if (inorder[i] == postorder[postEnd]){
                inIndex = i;
                break;
            }
        }
        root.left = buildTree(inorder, postorder,inStart, inIndex - 1,postEnd - inEnd + inIndex - 1);
        root.right = buildTree(inorder, postorder,inIndex + 1, inEnd,postEnd - 1);
        return root;
    }
}
