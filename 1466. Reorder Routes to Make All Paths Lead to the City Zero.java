class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<HashSet<Integer>> adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>> neighbour=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
            neighbour.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            neighbour.get(connections[i][0]).add(connections[i][1]);
            neighbour.get(connections[i][1]).add(connections[i][0]);
        }
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new ArrayDeque<>();
        q.add(0);
        
        int count=0;
        while(q.size()>0){
            int node=q.remove();
            vis[node]=true;
            for(int ele:neighbour.get(node)){
                if(!vis[ele]){
                    q.add(ele);
                    if(adj.get(node).contains(ele)){
                        adj.get(node).remove(ele);
                        adj.get(ele).add(node);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
