class Solution {
public:
    int minImpossibleOR(vector<int>& nums) {
        map<int,int>mp;
        for(auto x: nums) mp[x]++;
        int x=1;
        while(true){
            if (mp.find(x)==mp.end()) return x;
            x=x*2;
        }
        return x;
    }
    
};
        
