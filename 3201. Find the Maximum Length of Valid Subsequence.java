class Solution {
    public int maximumLength(int[] nums) {
        int oddCount = 0; // Count of odd numbers
        int evenCount = 0; // Count of even numbers
        int oddEvenCount = 1; // Alternating odd-even subsequence length
        int prev = 0; // 0 = odd, 1 = even

        if (nums[0] % 2 == 0) prev = 1; // Set initial parity

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) evenCount++;
            else oddCount++;

            // Alternate parity check and transition
            if (nums[i] % 2 == 1 && prev == 1) {
                prev = 0;
                oddEvenCount++;
            } else if (nums[i] % 2 == 0 && prev == 0) {
                prev = 1;
                oddEvenCount++;
            }
        }

        return Math.max(oddCount, Math.max(evenCount, oddEvenCount));
    }
}
