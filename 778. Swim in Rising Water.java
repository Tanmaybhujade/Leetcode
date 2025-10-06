class Solution {
    public int swimInWater(int[][] grid) {
        int low = 0;
        int high = 10000;
        int n = grid.length;
        int m = grid[0].length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean[][] vis = new boolean[n][m];

            if (isPossible(grid, mid, 0, 0, vis, n, m)) {
                high = mid - 1; // try to find smaller possible time
            } else {
                low = mid + 1; // increase water level
            }
        }
        return low; // minimum time when path is possible
    }

    public boolean isPossible(int[][] grid, int val, int row, int col, boolean[][] vis, int n, int m) {
        // Out of bounds or too high elevation or already visited
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] > val || vis[row][col]) 
            return false;

        // Reached destination
        if (row == n - 1 && col == m - 1) 
            return true;

        vis[row][col] = true;

        // Explore 4 directions
        boolean up = isPossible(grid, val, row - 1, col, vis, n, m);
        boolean down = isPossible(grid, val, row + 1, col, vis, n, m);
        boolean left = isPossible(grid, val, row, col - 1, vis, n, m);
        boolean right = isPossible(grid, val, row, col + 1, vis, n, m);

        return up || down || left || right;
    }
}
