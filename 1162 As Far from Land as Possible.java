class Solution {
	class Pair{
		int r;
		int c;
		Pair(int x,int y){
			r=x;
			c=y;
		}
	}
	public int maxDistance(int[][] grid) {
		int lvl=-1;
		Queue<Pair> q=new ArrayDeque<>();
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==1){
					q.add(new Pair(i,j));
				}
			}
		}
		while(q.size()!=0){
			lvl++;
			int sz=q.size();
			for(int i=0;i<sz;i++){
				Pair rp=q.remove();
				int [][]dir={{-1,0},{1,0},{0,1},{0,-1}};
				for(int j=0;j<dir.length;j++){
					int nr=rp.r+dir[j][0];
					int nc=rp.c+dir[j][1];
					if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==0){
						grid[nr][nc]=1;
						q.add(new Pair(nr,nc));
					}
				}
			}
		}

		return lvl==0? -1 : lvl;
	}
}
