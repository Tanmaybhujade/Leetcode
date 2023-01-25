class Solution {
public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        int n = edges.size();
        vector<int> vis1(n , -1);
        vector<int> vis2(n , -1);
        
        dfs(0 , node1 , edges , vis1) ;
        dfs(0 , node2 , edges , vis2) ;
        
        int ans = -1;
        int dist = 1e8; 
        for(int i=0; i< n; i++){
            if(vis1[i] >=0 && vis2[i] >=0) {
                if( max(vis1[i] , vis2[i])  < dist ){
                    ans = i;                   
                    dist = max(vis1[i] , vis2[i]);
                }
            }
        }
        return ans;
        
    }
    
    void dfs(int dist , int node , vector<int> &edges , vector<int> &vis){
        
        if(node == -1) return;
        
        if(vis[node] != -1 )return;
        vis[node] = dist;
        dfs(dist + 1 , edges[node] , edges , vis);
    }
};
