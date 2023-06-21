class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        int ans = 0;
        
        int[] prev = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            
            int[] current = intervals[i];
            
            if (current[0] < prev[1]) {
                ans++;
                
                if (current[1] < prev[1]) {
                    prev = current;
                }
                
            } else {
                prev = current;
            }
        }
        return ans;
    }
}
