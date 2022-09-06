class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (root == null) return result;
        Queue<Node> q = new LinkedList();
        q.add(root);
        
        while (!q.isEmpty()) {
            List<Node> currentLevelNodes = new ArrayList(q);
            q.clear();
            List<Integer> currentLevelInt = new ArrayList();
            for (Node n: currentLevelNodes) {
                currentLevelInt.add(n.val);
                for (int i = 0; i < n.children.size(); i++) {
                    q.add(n.children.get(i));
                }
            }
            result.add(currentLevelInt);
        }
        return result;
    }
}
