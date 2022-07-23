class Solution {
    int[] BITree;

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        for (int i : nums) {
            minValue = Math.min(minValue, i);
        }

        int[] diff = new int[nums.length];
    
        for (int i = 0; i < nums.length; i++) {
        
            diff[i] = nums[i] - minValue + 1;
            maxValue = Math.max(maxValue, diff[i]);
        }

        this.BITree = new int[maxValue + 1];
        Integer[] rst = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
        
            rst[i] = query(diff[i] - 1);
            
            update(diff[i]);
        }

        return Arrays.asList(rst);
    }

    private void update(int index) {
    
        while (index < BITree.length) {
            BITree[index]++;
            index += index & -index;
        }
    }

    private int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += BITree[index];
            index -= index & -index;
        }
        return sum;
    }
}
