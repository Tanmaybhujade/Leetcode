class Solution {
public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int indx = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[indx++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) / 2];
        int operations = 0;
        for (int num : arr) {
            if (num == mid) {
                continue;
            }
            if (Math.abs(num - mid) % x != 0) {
                return -1;
            }
            operations += (Math.abs(num - mid) / x);
        }
        
        return operations;
    }
}
