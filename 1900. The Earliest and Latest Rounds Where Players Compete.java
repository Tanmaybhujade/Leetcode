import java.util.*;

public class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        Map<String, int[]> memo = new HashMap<>();
        return dfs(n, firstPlayer, secondPlayer, memo);
    }

    private int[] dfs(int n, int a, int b, Map<String, int[]> memo) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (a + b == n + 1) return new int[]{1, 1}; // they fight this round
        if (a + b > n + 1) {
            int newA = n + 1 - a;
            int newB = n + 1 - b;
            return dfs(n, newA, newB, memo);
        }

        String key = n + "," + a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;

        for (int mask = 0; mask < (1 << (n / 2)); mask++) {
            List<Integer> nextRound = new ArrayList<>();
            if (n % 2 == 1) nextRound.add((n + 1) / 2); // middle player auto advances

            for (int i = 1; i <= n / 2; i++) {
                int x = i;
                int y = n + 1 - i;

                if ((x == a && y == b) || (x == b && y == a)) continue;

                if (x == a || y == a) {
                    nextRound.add(a);
                } else if (x == b || y == b) {
                    nextRound.add(b);
                } else {
                    if (((mask >> (i - 1)) & 1) == 1) nextRound.add(x);
                    else nextRound.add(y);
                }
            }

            Collections.sort(nextRound);
            int newA = -1, newB = -1;
            for (int i = 0; i < nextRound.size(); i++) {
                if (nextRound.get(i) == a) newA = i + 1;
                if (nextRound.get(i) == b) newB = i + 1;
            }

            if (newA == -1 || newB == -1) continue;

            int[] result = dfs(nextRound.size(), newA, newB, memo);
            minRound = Math.min(minRound, result[0] + 1);
            maxRound = Math.max(maxRound, result[1] + 1);
        }

        int[] answer = new int[]{minRound, maxRound};
        memo.put(key, answer);
        return answer;
    }

    // Optional: for local testing
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.earliestAndLatest(11, 2, 4))); // Output: [3, 4]
        System.out.println(Arrays.toString(s.earliestAndLatest(5, 1, 5)));  // Output: [1, 1]
    }
}
