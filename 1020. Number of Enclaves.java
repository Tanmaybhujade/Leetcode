class Solution {
    int dir[][]=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] A) {
        int m=A.length;
        int n=A[0].length;
        //boolean visited[][]=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j== n-1) && A[i][j]==1){
                   dfs(A,m,n,i,j);
                }
            }
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(A[i][j]==1) count++;
            }
        }
        return count;
    }
    void dfs(int[][]A,int m,int n,int i,int j){
        if(i<0 || i>=m || j<0 || j>=n || A[i][j]==0) return;
        A[i][j]=0;
        for(int d[]:dir){
            int x=i+d[0];
            int y=j+d[1];
            dfs(A,m,n,x,y);
        }
    }
}
    
