class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // Total number of elements in the input array.
        int n = nums.length;
        // Array of maps to store the count of arithmetic slices ending at each index.
        Map<Long, Integer>[] countMaps = new Map[n];
        // Initialize each map in the array.
        Arrays.setAll(countMaps, element -> new HashMap<>());
        // Variable to store the final answer.
        int totalCount = 0;

        // Iterate through each element in the array starting from the second element.
        for (int i = 0; i < n; ++i) {
            // For each element, check all previous elements to calculate the differences.
            for (int j = 0; j < i; ++j) {
                // Calculate the difference between the current and previous elements.
                Long diff = 1L * nums[i] - nums[j];
                // Get the current count of arithmetic slices with the same difference ending at index j.
                int count = countMaps[j].getOrDefault(diff, 0);
                // Accumulate the total number of found arithmetic slices.
                totalCount += count;
                // Update the countMap for the current element (index i).
                // Increment the count of the current difference by the count from the previous index plus 1 for the new slice.
                countMaps[i].merge(diff, count + 1, Integer::sum);
            }
        }
      
        // Return the accumulated count of all arithmetic slices found in the array.
        return totalCount;
    }
}
    
