class Solution {
public:
    int dfs(vector<int>adj[],vector<int>&visit,int node){
        visit[node]=1;
        int count=0;
        for(int i=0;i<adj[node].size();++i){
           if(visit[adj[node][i]]==0)
              count+=dfs(adj,visit,adj[node][i]);
        }
        return count+1;
    }
    long long countPairs(int n, vector<vector<int>>& e) {
        vector<int>adj[n];
        for(int i=0;i<e.size();++i){
            adj[e[i][0]].push_back(e[i][1]);
            adj[e[i][1]].push_back(e[i][0]);
        }
        vector<int>visit(n,0);
        vector<int>ans;
        for(int i=0;i<n;++i){
            if(visit[i]==0)
               ans.push_back(dfs(adj,visit,i));
        }
        long long total=0,sum=ans[ans.size()-1];
        for(int i=ans.size()-2;i>=0;--i){
            total+=ans[i]*sum;
            sum+=ans[i];
        }
        return total;
    }
};
