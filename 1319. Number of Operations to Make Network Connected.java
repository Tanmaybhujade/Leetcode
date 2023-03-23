class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        
         ArrayList<ArrayList<Integer>> graph = buildingGraph(n , connections);
        int ans = solve(n , graph);
        return ans-1;
    }
    public static int solve(int noOfNodes,  ArrayList<ArrayList<Integer>> graph){
        int count=0;
        boolean[] visited = new boolean[noOfNodes];
        for(int i=0 ; i<noOfNodes ;i++){
            if(visited[i]==false){
                count++;
                DFS(i, graph, visited );
            }
        }
        return count;
    }
    public static void DFS(int src , ArrayList<ArrayList<Integer>> graph , boolean[] visited){
        //solution.add(src);
        visited[src]=true;
        for(int element : graph.get(src)){
            if(visited[element]==false){
                DFS(element , graph , visited );
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> buildingGraph(int n , int[][] connections){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] row: connections){
            int u = row[0];
            int v = row[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
}
