import java.util.*;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int len = rectangles.length;
        int[][] xIntervals = new int[len][2];
        int[][] yIntervals = new int[len][2];
        
        // Step 1: Extract X and Y intervals
        for (int i = 0; i < rectangles.length; i++) {
            xIntervals[i][0] = rectangles[i][0];
            yIntervals[i][0] = rectangles[i][1];
            xIntervals[i][1] = rectangles[i][2];
            yIntervals[i][1] = rectangles[i][3];
        }
        
        // Step 2: Check if either X or Y intervals form separate sections
        if (mergeIntervals(xIntervals)) {
            return true;
        }
        if (mergeIntervals(yIntervals)) {
            return true;
        }
        return false;
    }
    
    private boolean mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        int[] currentInterval = intervals[0];
        int count = 0;
        
        // Step 3: Merge intervals and check for separation
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (currentInterval[1] > start) {
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
            } else {
                count++;
                currentInterval = intervals[i];
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
}
