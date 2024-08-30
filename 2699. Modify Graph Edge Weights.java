class Solution {
    HashMap<Integer, Integer>[] map;
    int[] neg;
    int neg_ct, s, t, n;
    long targ;
    int[][] edges;
    static int MAX = 2000000000;
    static long INF = 100000000000000000L;
    static long[] dist = new long[101];
    static PriorityQueue<Long> q = new PriorityQueue<Long>((p1, p2) -> (p1 - p2 > 0L ? 1 : -1));
    
    public void process(){
        for(int[] e : edges){
            e[2] = map[e[0]].get(e[1]);
        }
    }
    //sets all negative edges to weight v
    public void all(int v){
        for(int ind : neg){
            int[] e = edges[ind];
            map[e[0]].put(e[1], v);
            map[e[1]].put(e[0], v);
        }
    }
    public void partial(int v, int count){
        for(int i = 0; i < count; ++i){
            int ind = neg[i];
            int[] e = edges[ind];
            map[e[0]].put(e[1], v + 1);
            map[e[1]].put(e[0], v + 1);
        }
        for(int i = count; i < neg_ct; ++i){
            int ind = neg[i];
            int[] e = edges[ind];
            map[e[0]].put(e[1], v);
            map[e[1]].put(e[0], v);
        }
    }
    public long encode(int a, long b){
        return (b << 8) + a;
    }
    public long dijkstra(){
        Arrays.fill(dist, INF);
        q.add(encode(s, 0L));
        while(!q.isEmpty()){
            long p = q.poll();
            int cur = (int)(p & 255);
            long d = p >> 8;
            if(d > dist[cur]){
                continue;
            }
            dist[cur] = d;
            for(int nei : map[cur].keySet()){
                long nd = d + map[cur].get(nei);
                if(nd < dist[nei]){
                    q.add(encode(nei, nd));
                    dist[nei] = nd;
                }
            }
        }
        return dist[t];
    }
    public int[][] modifiedGraphEdges(int n, int[][] edges, int s, int t, int targ_int) {
        this.n = n;
        this.edges = edges;
        this.s = s;
        this.t = t;
        targ = (long)targ_int;
        neg_ct = 0;
        map = new HashMap[n];
        for(int i = 0; i < n; ++i){
            map[i] = new HashMap<>();
        }
        //setting up adjacency_list
        for(int[] e : edges){
            if(e[2] == -1){
                ++neg_ct;
            }
            map[e[0]].put(e[1], e[2]);
            map[e[1]].put(e[0], e[2]);
        }
        neg = new int[neg_ct];
        int neg_ind = 0;
        for(int i = 0; i < edges.length; ++i){
            int[] e = edges[i];
            if(e[2] == -1){
                neg[neg_ind] = i;
                ++neg_ind;
            }
        }
        all(1);
        long shortest = dijkstra();
        all(MAX);
        long longest = dijkstra();
        if(shortest > targ || longest < targ){
            return new int[0][0];
        }
        if(shortest == targ){
            all(1);
            process();
            return edges;
        }
        if(longest == targ){
            all(MAX);
            process();
            return edges;
        }
        int st = 1, end = MAX;
        while(st < end){
            int mid = st + (end - st) / 2;
            all(mid);
            long dist = dijkstra();
            if(dist < targ){
                st = mid;
            }
            else if(dist > targ){
                end = mid;
            }
            else{
                process();
                return edges;
            }
            if(st + 1 == end){
                all(end);
                dist = dijkstra();
                if(dist < targ){
                    st = end;
                }
                else if(dist > targ){
                    end = st;
                }
                else{
                    process();
                    return edges;
                }
            }
        }
        
        int val = st;
        st = 0;
        end = neg_ct;
        while(st < end){
            int mid = (st + end) / 2;
            partial(val, mid);
            long dist = dijkstra();
            if(dist < targ){
                st = mid + 1;
            }
            else if(dist > targ){
                end = mid - 1;
            }
            else{
                st = mid;
                break;
            }
        }
        partial(val, st);
        process();
        long dist = dijkstra();
        return edges;
    }
}
