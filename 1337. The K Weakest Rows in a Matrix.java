import java.util.*;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Create a list of rows with their respective counts of soldiers
        List<int[]> rows = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break; // Since the soldiers are positioned in front of civilians
                }
            }
            rows.add(new int[]{i, count});
        }

        // Sort the list of rows based on the number of soldiers and row index
        Collections.sort(rows, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // Extract the k weakest rows
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rows.get(i)[0];
        }

        return result;
    }
}
