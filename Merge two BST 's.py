
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        
        TreeMap<Node, Integer> map = new TreeMap<>((n1, n2)->{
            int cmp = Integer.compare(n1.data, n2.data);
            if(cmp==0)
            {
                return Integer.compare(System.identityHashCode(n1), System.identityHashCode(n2));
            }
            return cmp;
        });
        
        List<Node> al1 = bfs(root1);
        List<Node> al2 = bfs(root2);
        
        for(int i=0; i<al1.size(); i++)
        {
            map.put(al1.get(i), 1);
        }
        for(int i=0; i<al2.size(); i++)
        {
            map.put(al2.get(i), 1);
        }
        
        List<Integer> finallist = new ArrayList<>();
        
        for(Map.Entry<Node, Integer> entry: map.entrySet())
        {
            Node a = entry.getKey();
            finallist.add(a.data);
        }
        
        return finallist;
        
    }

    public List<Node> bfs(Node root)
    {
        List<Node> al = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            Node temp = q.remove();
            al.add(temp);
            
            if(temp.left!=null)
            {
                q.add(temp.left);
            }
            
            if(temp.right!=null)
            {
                q.add(temp.right);
            }
        }
        return al;
    }
}
