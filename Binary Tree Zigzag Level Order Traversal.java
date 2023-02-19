public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> zigzag = new ArrayList<List<Integer>>();
        
        if (root == null)
            return zigzag;

        LinkedList<QItem> queue = new LinkedList<QItem>();
        queue.addFirst(new QItem(root, 0));
        
        int currLevel = 0;
        List<Integer> currentLevelList = new ArrayList<Integer>();
        
        while (queue.size()>0){
            QItem h = queue.removeFirst();
            
            if (h.level == currLevel){
                    if (currLevel % 2 == 0){
                        currentLevelList.add(h.node.val);
                    }else{
                        currentLevelList.add(0, h.node.val);
                    }
            }else{
                zigzag.add(currentLevelList);
                currentLevelList = new ArrayList<Integer>();
                currentLevelList.add(h.node.val);
                currLevel++;
            }
            
            if (h.node.left != null){
            	queue.add(new QItem(h.node.left,currLevel+1));    
            }
            
            if (h.node.right != null){
                queue.add(new QItem(h.node.right,currLevel+1));    
            }
            
        }

        zigzag.add(currentLevelList);

        return zigzag;
    }        
}

class QItem{
    TreeNode node;
    int level;
    
    public QItem(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
