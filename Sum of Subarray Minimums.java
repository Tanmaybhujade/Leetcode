class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MODULO = (int) Math.pow(10, 9) + 7;
        int n = arr.length;
        Stack<Integer> incStack = new Stack<>();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!incStack.isEmpty() && arr[incStack.peek()] >= arr[i]) {
                incStack.pop();
            }
            if (!incStack.isEmpty()) {
                dp[i] = (dp[i] + dp[incStack.peek()] + arr[i] * (incStack.peek() - i)) % MODULO;
            } else {
                dp[i] = (dp[i] + arr[i] * (n - i)) % MODULO;
            }
            incStack.push(i);
        }
        int ans = 0;
        for (int d : dp) {
            ans = (ans + d) % MODULO;
        }
        return ans;
    }
}
