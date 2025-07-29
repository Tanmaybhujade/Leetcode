class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int length = nums.length;
        int[] resultArray = new int[length];
        //for every index the number would itself give us the highest OR so replacing all values by 1
        Arrays.fill(resultArray, 1);

        for (int i = 0; i < length; i++) {
            int currentNum = nums[i];
            int j = i - 1;
            //with OR the number can only increase or stay the same
            while (j >= 0 && (nums[j] | currentNum) != nums[j]) {
                resultArray[j] = i - j + 1;
            // it would change the orginal array so that we don't need to recompute again.
                nums[j] = nums[j] | currentNum;
                j--;
            }
        }
        return resultArray;
    }
}
