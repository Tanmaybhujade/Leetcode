class Solution {
public:
int largestPerimeter(vector<int>& nums) {
    sort(nums.begin(),nums.end());
    int n=nums.size();
    int param=0;
    for(int i=0;i<n-2;i++){
        int sum=0;
        if(nums[i]+nums[i+1]>nums[i+2]){
            sum=nums[i]+nums[i+1]+nums[i+2];
            param=max(sum,param);
        }
    }
    return param;
}
};

