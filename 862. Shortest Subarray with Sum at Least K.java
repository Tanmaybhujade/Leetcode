class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = n + 1;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && prefixSum[i] <= prefixSum[queue.peekLast()])
                queue.pollLast();
            queue.addLast(i);
            while (!queue.isEmpty() && prefixSum[i] - prefixSum[queue.peekFirst()] >= k) {
                ans = Math.min(ans, i - queue.pollFirst());
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
}
