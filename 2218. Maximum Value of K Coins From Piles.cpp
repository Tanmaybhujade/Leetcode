class Solution {
    vector<vector<int>> dp;
public:
    int solver(int ind,vector<vector<int>>& a,int k){
        if(ind>=a.size())
            return 0;
        if(dp[ind][k]>=0)
            return dp[ind][k];
        int take=0,next=solver(ind+1,a,k);
        int poss=k;
        if(poss>a[ind].size())
            poss=a[ind].size();
        for(int i=0;i<poss;i++){
            take+=a[ind][i];
            next=max(next,take+solver(ind+1,a,k-i-1));
        }
        return dp[ind][k]=next;
    }
    
    int maxValueOfCoins(vector<vector<int>>& a, int k) {
        dp.resize(a.size()+2,vector<int>(k+2,-1));
        return solver(0,a,k);
    }
};
