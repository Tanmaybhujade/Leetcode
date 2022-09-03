class Solution {
public:
    int K;
    vector<int> ans;
    
    void dfs(int N, int num){
        if(N == 0){
            ans.push_back(num);
        }else{
            int d = num%10;
            
            if(d-K >= 0){
                dfs(N-1, num*10 + (d-K));
            }
            
            if(K != 0 && d+K <= 9){
                dfs(N-1, num*10 + (d+K));
            }
        }
    }
    
    vector<int> numsSameConsecDiff(int N, int K) {
        this->K = K;
        
        if(N == 1) ans.push_back(0);
        
        for(int num = 1; num <= 9; ++num){
            dfs(N-1, num);
        }
        
        return ans;
    }
};
