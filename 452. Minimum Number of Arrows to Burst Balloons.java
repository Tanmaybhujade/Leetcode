class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int ans = 0;
        
        int l = 0;
        int n = points.length;
        while (l < n) {
            int currStart = points[l][0];
            int currEnd = points[l][1];
            while (l < n && points[l][0] <= currEnd) {
                currEnd = Math.min(currEnd, points[l][1]);
                ++l;
            }
            
            ++ans;
        }
        
        return ans;
    }
}
