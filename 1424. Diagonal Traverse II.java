class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) { return new int[0]; }
        List<int[]> values = new ArrayList<>();
        int nRows = nums.size();
        for (int i = 0; i < nRows; i++) {
            int nCols = nums.get(i).size();
            for (int j = 0; j < nCols; j++) {
                values.add(new int[]{ nums.get(i).get(j), i + j, i});
            }
        }
        
        Collections.sort(values, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            }
            
            return Integer.compare(o2[2], o1[2]);
        });
        
        int n = values.size();
        int[] output = new int[n];
        
        for (int i = 0; i < n; i++) {
            output[i] = values.get(i)[0];
        }
        
        return output;
    }
}
