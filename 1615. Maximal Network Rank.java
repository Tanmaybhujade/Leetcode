class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][]visited=new boolean[n][n];

        for(int[]a:roads)
        {
            visited[a[0]][a[1]]=true;
            visited[a[1]][a[0]]=true;
        }

        //count each edge adjacant nodes.

        int[]adjct=new int[n];
        for(int x:adjct)
            x=0;
        for(int[]a:roads)
        {
            for(int x:a)
            adjct[x]++;
        }

        //Update MAX RANK
        int max=Integer.MIN_VALUE;

        for(int i=0;i<adjct.length;i++)
        {
            for(int j=i+1;j<adjct.length;j++)
            {
                int count=0;

                //if edge present 
                if(visited[i][j]==true)
                {
                    count=adjct[i]+adjct[j]-1;
                }

                // If edge not present
                else 
                count=adjct[i]+adjct[j];

                //update max count
                if(count>max)
                max=count;
            }
        }
        return max;
    }
}
