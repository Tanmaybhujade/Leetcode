class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Initialize a new array to hold the rearranged elements
        int[] rearrangedArray = new int[nums.length];
      
        // Two pointers to place positive and negative numbers in the array.
        // Positives will be placed at even indices and negatives at odd indices.
        int positiveIndex = 0, negativeIndex = 1;
      
        // Iterate through all the numbers in the input array.
        for (int num : nums) {
            if (num > 0) {
                // When we encounter a positive number, we place it at the next even index
                rearrangedArray[positiveIndex] = num;
                positiveIndex += 2; // Move the pointer to the next position for a positive number
            } else {
                // When we encounter a negative number, we place it at the next odd index
                rearrangedArray[negativeIndex] = num;
                negativeIndex += 2; // Move the pointer to the next position for a negative number
            }
        }
      
        // Return the rearranged array where no two consecutive numbers have the same sign
        return rearrangedArray;
    }
}
