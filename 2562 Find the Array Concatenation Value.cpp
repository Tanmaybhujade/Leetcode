class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        
        int i = 0,j = nums.size()-1;
        
        while(i < j)
        {
            string s=to_string(nums[i++])+to_string(nums[j--]);
            long long temp = stol(s);
            ans+=temp;
        }
        
        if(nums.size()%2==1)ans+=nums[j];
        return ans;
    }
};
