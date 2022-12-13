class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] f = new int[A.length][A[0].length];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            f[0][i] = A[0][i];
        }
        for (int i = 1; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                int a = j > 0 ? f[i - 1][j - 1] : Integer.MAX_VALUE;
                int b = f[i - 1][j];
                int c = j < f.length - 1 ? f[i - 1][j + 1] : Integer.MAX_VALUE;
                int min = Math.min(a, Math.min(b, c));
                f[i][j] = A[i][j] + min;
            }
        }
        for (int i = 0; i < f[f.length - 1].length; i++) {
            ans = Math.min(ans, f[f.length - 1][i]);
        }
        return ans;
    }
}
