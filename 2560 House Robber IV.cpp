class Solution {
public:
    
    bool f(int n, vector<int>& nums, int k)
    {
        int temp = 0;
        for(int i=0; i<nums.size(); i++)
        {
            if(nums[i] <= n && temp == 0)
            {
                k--;
                temp = 1;
                if(k == 0) return true;
            }
            else
            {
                temp = 0;
            }
        }
        return false;
    }
    
    int minCapability(vector<int>& nums, int k) {
        int ans = 0, temp = 0;
        vector<int> v;
        for(auto &c: nums) v.push_back(c);
        sort(v.begin(), v.end());
        int l = k-1, r = v.size()-1, m;
        while(l <= r)
        {
            m = (l+r)/2;
            if(f(v[m], nums, k)) r = m-1;
            else l = m+1;
        }
        return v[l];
    }
};
