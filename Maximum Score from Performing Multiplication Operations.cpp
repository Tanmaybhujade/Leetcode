class Solution {
public:
     
     int solve(vector<int>& nums, vector<int>& multipliers, int idx, int l, int r) {
         if(idx == multipliers.size()) return 0;
        
         // return max of choosing left and right
         int left = multipliers[idx] * nums[l] + solve(nums, multipliers, idx+1, l+1, r);
         int right = multipliers[idx] * nums[r] + solve(nums, multipliers, idx+1, l, r-1);
        
         return max(left, right);
     }
   
    int dp[1005][1005];
    int solve(vector<int>& nums, vector<int>& multipliers, int idx, int l) {
        if(idx == multipliers.size()) return 0;
        
        if(dp[idx][l] != INT_MIN) return dp[idx][l];
        int r = nums.size()-(idx-l)-1;
        int left = multipliers[idx] * nums[l] + solve(nums, multipliers, idx+1, l+1);
        int right = multipliers[idx] * nums[r] + solve(nums, multipliers, idx+1, l);
        
        return dp[idx][l] = max(left, right);
    }
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        // return solve(nums, multipliers, 0, 0, nums.size()-1);
        
        // initialize dp with INT_MIN because -1 is itself an answer for test case:
//         [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//         [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]

        for(int i = 0; i < 1005; i++) 
            for(int j = 0; j < 1005; j++)
                dp[i][j] = INT_MIN;
        
        // memset(dp, -1e5, sizeof(dp));
        return solve(nums, multipliers, 0, 0);
    }
};
