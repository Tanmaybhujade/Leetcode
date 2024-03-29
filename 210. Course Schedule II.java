class Solution {
    public int[] findOrder(int n, int[][] pre) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] in = new int[n];
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] p: pre) {
            in[p[0]]++;
            map.get(p[1]).add(p[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 0) q.add(i);
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int curr = q.peek();
            q.poll();
            result.add(curr);
            for(int child: map.get(curr)) {
                in[child]--;
                if(in[child] == 0) q.add(child);
            }
        }
        if(result.size() != n) return new int[]{};
        return result.stream().mapToInt(i->i).toArray();
        
    }
}
