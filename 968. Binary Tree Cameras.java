class Solution {

    private static final int NULL = 0;

    private static final int COVER = 1;

    private static final int CAMERA = 2;

    private int res;

    public int minCameraCover(TreeNode root) {

        if(dfs(root) == NULL) res++;

        return res;

    }

    private int dfs(TreeNode node){

        if(node == null) return COVER;

        int left = dfs(node.left);

        int right = dfs(node.right);

        if(left == NULL || right == NULL){

            res++;

            return CAMERA;

        }

        if(left == CAMERA || right == CAMERA) return COVER;

        return NULL;

    }

}
