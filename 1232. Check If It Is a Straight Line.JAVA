class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int dx=coordinates[0][0]-coordinates[1][0];
        int dy=coordinates[0][1]-coordinates[1][1];
        for(int[] p:coordinates){
            if(dx*(coordinates[0][1]-p[1])!=dy*(coordinates[0][0]-p[0])){return false;} //comparing slopes dy/dx=x0-x/y0-y where dy/dx is the initial slope 
        }
        return true;
    }
}
