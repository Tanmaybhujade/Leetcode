class Solution {
    public int maxPoints(int[][] points) {
        if(points == null) return 0;
        int solution = 0;
        for(int i = 0; i < points.length; i++){
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            for(int j = i + 1; j < points.length; j++){
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                if(deltaX == 0 && deltaY == 0){
                    max++;
                    continue;
                }
                int gcd = gcd(deltaX, deltaY);
                int dx = deltaX / gcd;
                int dy = deltaY / gcd;
                map.put(dx + "," + dy, map.getOrDefault(dx + "," + dy, 0) + 1);
                max = Math.max(max, map.get(dx + "," + dy));
            }
            solution = Math.max(solution, max + 1);
        }
        return solution;
    }
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
