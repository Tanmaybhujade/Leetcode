class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> digitSumToMaxSum = new HashMap<>();
        int maxValue = -1;
        for (int num : nums) {
            int digitSum = findDigitsSum(num);
            if (digitSumToMaxSum.containsKey(digitSum)) {
                int maxSum = digitSumToMaxSum.get(digitSum);
                maxValue = Math.max(maxValue, maxSum + num);
                digitSumToMaxSum.put(digitSum, Math.max(maxSum, num));
            } else {
                digitSumToMaxSum.put(digitSum, num);
            }
        }
        return maxValue;
    }
    public int findDigitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

