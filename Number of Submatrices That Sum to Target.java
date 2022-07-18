class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++)
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
        }
        int count = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        for (int k = 0; k < prefixSum[0].length; k++)
        for (int i = k + 1; i < prefixSum[0].length; i++) { // col
            prefix.put(0, 1);
            int sum = 0;
            for (int j = 0; j < prefixSum.length; j++) { // row
                sum = sum + prefixSum[j][i] - prefixSum[j][k];
                if (prefix.containsKey(sum - target)) {
                    count = count + prefix.get(sum - target);
                }
                prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
            }
            prefix.clear();
        }
        return count;
    }
}
