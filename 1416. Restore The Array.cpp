class Solution {
public:
    int numberOfArrays(string nums, int k) {
        int n=nums.size();
        vector<int>x(n+1,0);
        x[n]=1;
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]=='0')continue;
            long long a=0;
            for(int j=1;i+j<=n;j++)
            {
                a= a* 10 + nums[i + j - 1] - '0';
            if (a> k)
                break;
            x[i] = (x[i] + x[i + j]) % 1000000007;
            }
        }
        return x[0];
    }
};
