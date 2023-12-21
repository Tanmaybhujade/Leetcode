import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int max = -1;

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(final int[] point1, final int[] point2) {
                if (point1[0] > point2[0]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // Uncomment the following block for debugging
        // for (int i = 0; i < points.length; i++) {
        //     System.out.print(points[0] + " " + points[1]);
        // }

        int len = points.length;
        for (int i = len - 1; i > 0; i--) {
            int diff = points[i][0] - points[i - 1][0];
            if (diff > max) {
                max = diff;
            }
        }

        return max;
    }
}
