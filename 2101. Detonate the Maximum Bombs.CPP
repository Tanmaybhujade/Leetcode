class Solution {
public:
    
    double cal(int x1, int x2, int y1,int y2)
    {
        double temp = pow(x1-x2,2) + pow(y1-y2,2);
        return sqrt(temp);
    }
    void dfs(int src,vector<bool >&visit,int &count,vector<vector<int >>&graph)
    {
        count++;
        visit[src]=true;
        for(int  i =0;i<graph[src].size();i++)
        {
            if(visit[graph[src][i]]==false)
            {
                dfs(graph[src][i],visit,count,graph);
            }
        }
    }
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<vector<int >>graph(n);
        
        for(int  i =0;i<n;i++)
        {
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r1 = bombs[i][2];
            for(int j = 0;j<n;j++)
            {
                if(i==j)
                {
                    continue;
                }
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                
                double dis = cal(x1,x2,y1,y2);
                if(dis<=r1)
                {
                    graph[i].push_back(j);
                }
                    
            }
        }
        
        
        int ma = 1;
        for(int i = 0;i<n;i++)
        {
            int count = 0;
            vector<bool >visit(n,false);
            dfs(i,visit,count,graph);
            ma = max(ma,count);
        }
        return ma;       
    }
};
