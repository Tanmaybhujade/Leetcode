class Graph {
    List<List<int[]>> graph;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph.get(u).add(new int[]{v,cost});
        }
    }
    
    public void addEdge(int[] edge) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph.get(u).add(new int[]{v,cost});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.add(new int[]{node1,0});
        while(!pq.isEmpty()){
            int [] info = pq.poll();
            int u = info[0];
            int cost = info[1];

            for(int[] next: graph.get(u)){
                int v = next[0];
                int d = next[1];
                if(cost+d < dist[v]){
                    dist[v] = cost+d;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        return dist[node2] ==Integer.MAX_VALUE ? -1 : dist[node2];
    
