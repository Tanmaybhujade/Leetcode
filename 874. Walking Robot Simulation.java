class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions represent North, East, South, West in terms of (dx, dy)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Convert obstacles array into a set for O(1) lookup time
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        int x = 0, y = 0;  // Robot's starting position
        int direction = 0; // Starting direction (North)
        int maxDistance = 0;

        // Iterate through each command
        for (int command : commands) {
            if (command == -1) {
                // Turn right
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                // Turn left
                direction = (direction + 3) % 4;  // equivalent to (direction - 1 + 4) % 4
            } else {
                // Move forward k units
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    
                    // Check if the next position is an obstacle
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        // Calculate the distance squared from the origin
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    } else {
                        break;  // Stop moving if there's an obstacle
                    }
                }
            }
        }

        return maxDistance;
    }
}
