class Solution {

    public int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                // best[state]: stores min(prevA - prevB) for prefix with specific parity state
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);

                int totalA = 0, totalB = 0;   // Count from start to current position
                int leftA = 0, leftB = 0;     // Count from start to `left` pointer
                int left = -1;

                for (int right = 0; right < n; right++) {
                    if (s.charAt(right) == a) totalA++;
                    if (s.charAt(right) == b) totalB++;

                    while (right - left >= k && totalB - leftB >= 2) {
                        int state = getStatus(leftA, leftB);
                        best[state] = Math.min(best[state], leftA - leftB);

                        left++;
                        if (s.charAt(left) == a) leftA++;
                        if (s.charAt(left) == b) leftB++;
                    }

                    int currState = getStatus(totalA, totalB);
                    int requiredState = currState ^ 0b10; // flip a's parity

                    if (best[requiredState] != Integer.MAX_VALUE) {
                        int currentDiff = totalA - totalB - best[requiredState];
                        maxDiff = Math.max(maxDiff, currentDiff);
                    }
                }
            }
        }
        return maxDiff;
    }

    private int getStatus(int countA, int countB) {
        return ((countA & 1) << 1) | (countB & 1); // bit 1: parity of A, bit 0: parity of B
    }
}
