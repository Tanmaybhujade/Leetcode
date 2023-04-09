class Solution {
    ArrayList<Integer>[] graph;
    int max_color = 0;
    boolean isCycle = false;
    HashMap<Integer, HashMap<Character, Integer>> dp = new HashMap<>();
    public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        graph = new ArrayList[N];
        for(int i = 0 ; i < N ; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] vis = new boolean[N];
        for(int i = 0 ; i < N ; i++){
            getPath(colors, vis, i);
            
            if(isCycle) return -1;
        }
        return max_color;
    }
    
    public HashMap<Character, Integer> getPath(String color, boolean[] vis, int src){
        if(vis[src]){
            isCycle = true;
            return new HashMap<>();
        }
        if(dp.containsKey(src)) return dp.get(src);
        vis[src] = true;
        boolean status = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int e : graph[src]){
            HashMap<Character, Integer> f = getPath(color, vis, e);
            
            if(isCycle) return new HashMap<>();
            
            for(char c : f.keySet()){
                int f_val = f.get(c);
                int c_val = map.getOrDefault(c, 0);
                c_val = Math.max(c_val, f_val);
                max_color = Math.max(max_color, c_val);
                map.put(c, c_val);
            }
        }
        map.put(color.charAt(src), map.getOrDefault(color.charAt(src), 0) + 1);
        max_color = Math.max(max_color, map.get(color.charAt(src)));
        vis[src] = false;
        dp.put(src, map);
        return map;
    }
}
