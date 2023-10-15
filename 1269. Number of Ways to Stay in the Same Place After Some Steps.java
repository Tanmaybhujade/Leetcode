class Solution {
    Map<String, Integer> memo;
    int MOD = (int)1e9+7;
    public int numWays(int steps, int arrLen){
        memo = new HashMap<>();
        return dfs(0, steps, arrLen);
    }
    private int dfs(int i, int steps, int n){
        String pos = i + "," + steps;
        if(memo.containsKey(pos))
            return memo.get(pos);
        if(steps == 0 && i == 0)
            return 1;
        if(i < 0 || i > n-1 || steps == 0)
            return 0;

        long left = dfs(i-1, steps-1, n);
        long stay = dfs(i, steps-1, n);
        long right = dfs(i+1, steps-1, n);
        int res = (int)((left + stay + right)%MOD);
        memo.put(pos, res);
        return res;       
    }
}
