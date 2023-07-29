


import java.util.Arrays;

public class Solution{
    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }

        int m = (int) Math.ceil(n / 25.0);
        Double[][] memo = new Double[m + 1][m + 1];
        return serveHelper(m, m, memo);
    }

    private double serveHelper(int a, int b, Double[][] memo) {
        if (a <= 0 && b <= 0) {
            return 0.5; // Half the probability that both become empty at the same time
        }
        if (a <= 0) {
            return 1.0; // A is empty, so probability is 1
        }
        if (b <= 0) {
            return 0.0; // B is empty, so probability is 0
        }
        if (memo[a][b] != null) {
            return memo[a][b];
        }

        memo[a][b] = 0.25 * (
                serveHelper(a - 4, b, memo) +
                        serveHelper(a - 3, b - 1, memo) +
                        serveHelper(a - 2, b - 2, memo) +
                        serveHelper(a - 1, b - 3, memo)
        );
        return memo[a][b];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n1 = 50;
        int n2 = 100;
        System.out.println("Output 1: " + solution.soupServings(n1)); // Output: 0.62500
        System.out.println("Output 2: " + solution.soupServings(n2)); // Output: 0.71875
    }
}
