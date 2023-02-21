class Solution{   
public:
    int minIteration(int N, int M, int x, int y){    
         vector<vector<int>> vis(N,vector<int>(M,0));
        vis[x-1][y-1]=1;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        queue<pair<pair<int,int>,int>> q;
        q.push({{x-1,y-1},0});
        int itr=0;
        while(!q.empty()){
            int row=q.front().first.first;
            int col=q.front().first.second;
            itr=q.front().second;
            q.pop();
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<N && ncol>=0 && ncol<M && vis[nrow][ncol]==0){
                    q.push({{nrow,ncol},itr+1});
                    vis[nrow][ncol]=1;
                }
            }
        }
        return itr;
    }
};
