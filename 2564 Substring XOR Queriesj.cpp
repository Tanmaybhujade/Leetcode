class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        unordered_map<int, pair<int, int>> mp;
       
        for(auto i: queries){
            mp[i[0] ^ i[1]] = {INT_MAX, INT_MAX};
        }
        long curr;
        //iterating over length
        for(int i = 1;i<=32;i++){
            curr = 0;
            for(int j = 0;j<min(i, (int)s.size());j++){
                curr<<=1;
                curr+=(s[j] - '0');
            }
            if(mp.count(curr) && mp[curr].first == INT_MAX) mp[curr] = {0, i-1};
            //sliding window
            for(int j = i;j<s.size();j++){
                curr &= ~(1<<(i-1));
                curr <<= 1;
                curr += (s[j] - '0');
                if(mp.count(curr)){
                    if(mp[curr].first == INT_MAX){
                        mp[curr] = {j-i + 1, j};
                    }
                }
            }
        }
        vector<vector<int>> ans;
        for(auto i: queries){
            if(mp[i[0] ^ i[1]].first == INT_MAX){
                ans.push_back({-1, -1});
            }else{
                ans.push_back({mp[i[0] ^ i[1]].first, mp[i[0] ^ i[1]].second});
            }
        }
        return ans;
    }
};
