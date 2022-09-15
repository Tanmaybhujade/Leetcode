class Solution {
public:
    vector<int> findOriginalArray(vector<int>& ch) {
        int n=ch.size();
        vector<int>ans;
        if(n%2)return ans;
        unordered_map<int,int>mp;
        for(auto i:ch)mp[i]++;
        sort(ch.begin(),ch.end());
        for(int i=0;i<n;i++){
            if(mp[ch[i]]==0)continue;
            else{
                if(mp.find(ch[i]*2)!=mp.end()&&mp[ch[i]*2]){
                    ans.push_back(ch[i]);mp[ch[i]]--;mp[ch[i]*2]--;
                }
                else{
                   return {};
                }
            }
        }
       return ans;
    }
};
