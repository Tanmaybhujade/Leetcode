class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += matrix[i][j];
                }
            }
            int[] sortedHeights = Arrays.copyOf(heights, n);
            Arrays.sort(sortedHeights);
            for (int k = 0; k < n; k++) {
                ans = Math.max(ans, sortedHeights[k] * (n - k));
            }
        }
        return ans;
    }
}
