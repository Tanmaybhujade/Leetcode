class Solution {
    private int maxTime;
    private Map<Integer,List<Integer>> g = new HashMap<>();
    private int[] informTime;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(manager[i], k -> new ArrayList<Integer>()).add(i);
        }
        dfs(headID, informTime[headID]);
        return maxTime;        
    }
    
    private void dfs(int emp, int currTime) {
        var subs = g.get(emp);
        if (subs == null) return;
        
        maxTime = Integer.max(maxTime, currTime);
        for (var sub: subs) {
            dfs(sub, currTime + informTime[sub]);
        }
    }
}
