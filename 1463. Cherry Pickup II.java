class Solution {
    public int cherryPickup(int[][] grid) {
        int[] p1 = {0, 0};
        int[] p2 = {0, grid[0].length-1};
        int[][][] memo = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] m: memo){
            for(int[] n: m){
                Arrays.fill(n, -1);
            }

        }
        return dfs(grid, p1, p2, memo);
    }

    private int dfs(int[][] grid, int[] p1, int[] p2, int[][][] memo){
        int[] c = {-1, 0, 1};
        int max = Integer.MIN_VALUE;
        int result = 0;

        if(!isValid(grid, p1) || !isValid(grid, p2)){
            return 0;
        }
        if(memo[p1[0]][p1[1]][p2[1]]!=-1){
            return memo[p1[0]][p1[1]][p2[1]];
        }
        result = result + grid[p1[0]][p1[1]];
        if(p1[1]!=p2[1]){
            result = result + grid[p2[0]][p2[1]];
        }

        for(int i=0;i<c.length;i++){
            for(int j=0;j<c.length;j++){
                max = Math.max(max, result + dfs(grid, new int[]{p1[0]+1, p1[1]+c[i]}, new int[]{p2[0]+1, p2[1]+c[j]}, memo));
            }
        }
        memo[p1[0]][p1[1]][p2[1]] = max;
        return max;

    }

    private boolean isValid(int[][] grid, int[] p){
        return p[0] < grid.length && p[1] >=0 && p[1] < grid[0].length;
    }
}
