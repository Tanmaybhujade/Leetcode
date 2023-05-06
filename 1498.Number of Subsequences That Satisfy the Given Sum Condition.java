class Solution {
    public int numSubseq(int[] nums, int target) {
        int[] pows = new int[nums.length];
        int mod = (int)1e9 + 7;
        pows[0] = 1;
        for (int i = 1 ; i <nums.length; ++i)
            pows[i] = pows[i - 1] * 2 % mod;

        Arrays.sort(nums);
        long res=0;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            if(2*nums[l]>target){
                break;
            }
            while(r>=l&&nums[l]+nums[r]>target){
                r--;
            }
            res+=pows[r-l];
            res=(res+mod)%mod;
            l++;
        }

        return (int)res;
    }
}
