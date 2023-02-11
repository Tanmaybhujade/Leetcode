class Solution {
public:
    
    vector<vector<vector<int>>> adj;
    vector<int> ans;
    
    vector<vector<int>> visited;
    
    void Check(int &n, int clr1){
        
        
        queue<pair<int,int>>q;
        
        q.push({0,clr1});
        int len=0;
        while(!q.empty())
        {
            int s=q.size();
            
            while(s--)
            {
                 pair<int,int> p=q.front();
                q.pop();

                int pos=p.first;
                int clr=p.second;

                if(ans[pos]==-1)
                    ans[pos]=len;
                else
                ans[pos]=min(ans[pos],len);

                visited[pos][clr]=1;
                for(auto a:adj[pos][clr])
                {
                    if(!visited[a][clr^1])
                    q.push({a,clr^1});
                }

            }
           len++;
        }
        
    }
    
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        adj=vector<vector<vector<int>>>(n,vector<vector<int>>(2,vector<int>()));
        ans=vector<int>(n,-1);
        visited=vector<vector<int>>(n,vector<int>(2,0));
      
//         red->0
//         blue->1
        
        for(auto a:redEdges)adj[a[0]][0].push_back(a[1]);
        for(auto a:blueEdges)adj[a[0]][1].push_back(a[1]);
        
        
        
        Check(n,0);
        visited=vector<vector<int>>(n,vector<int>(2,0));
        Check(n,1);
        
        
        return ans;
        
    }
};tanm
