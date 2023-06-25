class Solution {
public:
    typedef pair<int,int> PII;
    int MO=1e9+7;
    void addv(int &x,int y)
    {
        if(x==-1) x=0;
        x+=y;
        if(x>=MO) x-=MO;
    }
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        int n=locations.size();
        vector<vector<int> > dp(n,vector<int>(fuel+1,-1));
        dp[start][fuel]=1;
        for(int j=fuel;j>0;j--)
        {
            for(int u=0;u<n;u++)
            {
                if(dp[u][j]==-1) continue;
                // cout<<u<<" "<<j<<endl;
                for(int v=0;v<n;v++)
                {
                    if(u==v) continue;
                    int d=abs(locations[u]-locations[v]);
                    if(d>j) continue;
                    addv(dp[v][j-d],dp[u][j]);
                }
            }
        }
        int ans=0;
        for(int i=0;i<=fuel;i++)
            if(dp[finish][i]!=-1) addv(ans,dp[finish][i]);
        return ans;
    }
};
