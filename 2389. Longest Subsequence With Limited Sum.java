class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            result[i] = maxSizeSubsequence(query, nums); 
        }
        return result;
    }
    public int maxSizeSubsequence(int query, int[] nums) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > query) {
                return count;
            }
            count++;
        }
        return count;
    }
}
