class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 ||
                grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int rst = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = infect(grid, i, j, rows, cols, 0);
                    rst = Math.max(rst, area);
                }
            }
        }

        return rst;
    }

    // DFS
    private int infect(int[][] grid, int i, int j, int rows, int cols, int area) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return area;
        }

        // Mark the explored island cells with 2.
        grid[i][j] = 2;
        area++;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            area = infect(grid, i + dir[0], j + dir[1], rows, cols, area);
        }

        return area;
    }
}
