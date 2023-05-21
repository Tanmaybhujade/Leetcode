 class Solution {
    int dir[][] = {{0,-1}, {0,1}, {-1, 0}, {1, 0}};
    public int shortestBridge(int[][] grid) {
      int n = grid.length;
      int count =0;
      Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
          for(int j=0;j<n;j++){
            
            if(grid[i][j]==1 && count<1){
              dfs(grid, i, j, q);
              count++;
            }
          }
        }
      
      
        while(!q.isEmpty()){
          int[] p = q.poll();
          int x = p[0];
          int y = p[1];
          int dis = p[2];
       
           for (int[] d : dir) {
                 int r = x + d[0];
                 int c = y + d[1];
                if (r >= 0 && r < n && 
                    c>= 0 && c < n &&
                    grid[r][c]!=-1) {
                    
                    if (grid[r][c] == 0){
                         q.offer(new int[]{r, c, dis+1});
                         grid[r][c] = -1;
                    }
                  if(grid[r][c]==1){
                  
                    return dis;
                  }
                }
            }
        }
      return -1;
    }
  
     public void dfs(int[][] grid, int r, int c, Queue<int[]> q){
        if(r>=grid.length||r<0|c>=grid[0].length||c<0)return;
       
        if(grid[r][c]==-1 || grid[r][c]==0)return;
        
        grid[r][c] = -1;
        q.add(new int[]{r, c, 0});
       
        dfs(grid, r-1, c, q);
        dfs(grid, r+1, c, q);
        dfs(grid, r, c-1, q);
        dfs(grid, r, c+1, q);
     }
}
