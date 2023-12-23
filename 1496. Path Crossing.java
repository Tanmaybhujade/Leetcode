class Solution {
    public boolean isPathCrossing(String path) {

        int x = 0, y = 0;
        Set<String> visited = new HashSet();
        visited.add("0,0");

        for (char dir : path.toCharArray()) {
            if (dir == 'E')
                x++;
            else if (dir == 'W')
                x--;
            else if (dir == 'N')
                y++;
            else if (dir == 'S')
                y--;

            String currPos = x + "," + y;

            // return true if already visited else just add the pos
            if (!visited.add(currPos))
                return true;
        }

        return false;
    }
}
