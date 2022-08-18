class Solution {
public:

int minSetSize(vector<int>& arr) {
    map<int,int>m;
    for(auto x:arr)
        m[x]++;
    multimap<int,int,greater<int>>mm;
    for(auto x:m)
        mm.insert({x.second,x.first});
    int n=arr.size();
    int sum=n,cnt=0;
    for(auto it=mm.begin();it!=mm.end();it++){
        sum-=it->first;
        cnt++;
        if(sum<=n/2)
            return cnt;
    }
    return cnt;
 }
};
