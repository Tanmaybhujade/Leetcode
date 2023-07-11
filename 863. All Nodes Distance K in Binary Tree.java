class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentPointer = new HashMap<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        parentTracker(root, parentPointer);
                                  
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target, true);
        int currLevel = 0;
        
        while(!q.isEmpty()){
            if(currLevel++ == k) break;
            int n = q.size();
            for(int i = 0 ; i<n ;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && !visited.containsKey(curr.left)){
                    visited.put(curr.left, true);
                    q.add(curr.left);
                }
                if(curr.right!=null && !visited.containsKey(curr.right)){
                    visited.put(curr.right, true);
                    q.add(curr.right);
                }
                if(parentPointer.get(curr) != null && !visited.containsKey(parentPointer.get(curr))){
                    visited.put(parentPointer.get(curr), true);
                    q.add(parentPointer.get(curr));
                }
            }
        }
        List<Integer> ans = new LinkedList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
        
    } 
    public void parentTracker(TreeNode root, HashMap<TreeNode, TreeNode> hm) {
        if(root == null) return ;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ; i<n ;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    hm.put(curr.left, curr);
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    hm.put(curr.right, curr);
                    q.add(curr.right);
                }
            }
        }
    }
}
