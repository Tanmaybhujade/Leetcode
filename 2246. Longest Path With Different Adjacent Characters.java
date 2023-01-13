class TreeNode {
    public char ch;
    public List<TreeNode> childrens;
    
    TreeNode(char ch) {
        this.ch = ch;
        childrens = new ArrayList<>();
    }
}

class Solution {
    private int answer;
    public int longestPath(int[] parent, String s) {
        TreeNode root = constructTree(parent, s.toCharArray());
        answer = 0;
        dfs(root);
        return answer;
    }
    
    private TreeNode constructTree(int[] parent, char[] str) {
        int n = parent.length;    
        TreeNode[] arr = new TreeNode[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = new TreeNode(str[i]);
        }
        
        for (int i = 1; i < n; ++i) {
            arr[parent[i]].childrens.add(arr[i]);
        }
        
        return arr[0];
    }
    
    private int dfs(TreeNode root) {
        int max = 0, secondMax = 0;
        for (TreeNode child : root.childrens) {
            int value = dfs(child);
            if (root.ch != child.ch) {
                if (max <= value) {
                    secondMax = max;
                    max = value;
                } else if (secondMax < value) {
                    secondMax = value;
                }
            } else {
                answer = Math.max(answer, value);
            }
        }
        answer = Math.max(answer, max + secondMax + 1);
        return max + 1;
    }
}
