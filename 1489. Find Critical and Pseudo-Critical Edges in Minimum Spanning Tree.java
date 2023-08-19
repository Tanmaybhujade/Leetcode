class Solution {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Comparator<int[]> myComp = new MyComp();
        PriorityQueue<int[]> pq;
        UnionFind u;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pseudocritical = new ArrayList<>();
        List<Integer> critical = new ArrayList<>();
        List<Integer> noncritical = new ArrayList<>();

        pq = new PriorityQueue<>(myComp);
        u = new UnionFind(n);

        for (int i=0;i<edges.length;i++){
            pq.add(edges[i]);
        }

        int minSum = MST(pq,u);


        for (int i=0;i<edges.length;i++){
            pq = new PriorityQueue<>(myComp);
            u = new UnionFind(n);

            for (int j=0;j<edges.length;j++){
                if (j != i){
                    pq.add(edges[j]);
                }
            }

            int sum = MST(pq,u);
            if (sum != minSum){
                critical.add(i);
            } 
        }              

        for (int i=0;i<edges.length;i++){
            pq = new PriorityQueue<>(myComp);
            u = new UnionFind(n);
            int adder = 0;

            for (int j=0;j<edges.length;j++){
                if (j == i){
                    int[] e = new int[3];
                    e[0] = edges[j][0];
                    e[1] = edges[j][1];
                    adder = edges[j][2];
                    e[2] = 0;
                    pq.add(e);
                    continue;
                }
                pq.add(edges[j]);
            }

            int sum = MST(pq,u) + adder;
            if (sum != minSum){
                noncritical.add(i);
            } 
        }

        for (int i=0;i<edges.length;i++){
            if (!critical.contains(i) && !noncritical.contains(i)){
                pseudocritical.add(i);
            }
        }
                            
        result.add(critical);
        result.add(pseudocritical);

        return result;
    }

    int MST(PriorityQueue<int[]> pq, UnionFind u){
        int sum = 0;
        while (!pq.isEmpty()){
            int[] e = pq.remove();
            int v1 = e[0];
            int v2 = e[1];
            int w = e[2];

            if (!u.isConnected(v1,v2)){
                u.unite(v1,v2);
                sum += w;
            }
        }

        return sum;
    }

    class MyComp implements Comparator<int[]> {
        public int compare(int[] e1, int[] e2){
            return (e1[2]-e2[2]);
        }
    }

    class UnionFind {
        int[] _id; 
        int[] rank;

        UnionFind(int n){
            _id = new int[n];
            rank = new int[n];
            for (int i=0;i<n;i++){
                _id[i] = i;
                rank[i] = 1;
            }
        }

        int root(int p){
            while (p != _id[p]){
                _id[p] = _id[_id[p]];
                p = _id[p];
            }

            return p;
        }

        boolean isConnected(int p,int q){
            return (root(p) == root(q));
        }

        void unite(int p, int q){
            if (rank[root(p)] > rank[root(q)]){
                _id[root(q)] = root(p);
            } else if (rank[q] > rank[p]){
                _id[root(p)] = root(q);
            } else {
                _id[root(q)] = root(p);
                rank[root(p)] +=1;
            }      
        }
    }
}
