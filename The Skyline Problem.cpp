class Solution {
public:
    vector<array<int,3>> v;
    
    static bool comp(array<int,3> a,array<int,3> b){
        
        if(a[0]==b[0])
        {
           if(a[2]==b[2] and a[2]==0)
               return a[1]>b[1];
            if(a[2]==b[2] and a[2]==1)
                return a[1]<b[1];

            return a[2]<b[2];
                
        }
        return a[0]<b[0];
    }
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        for(auto &it:buildings)
        {
            v.push_back({it[0],it[2],0});
            v.push_back({it[1],it[2],1});
        }
        
        sort(v.begin(),v.end(),comp);
        
        multiset<int> st;
        
        st.insert(0);
        
        int mx=0;
        
        vector<vector<int>> ans;
        
        for(auto &it:v){
            if(it[2]==0){
                st.insert(it[1]);

                auto pt=st.end();
                pt--;

                if(*pt!=mx){
                    ans.push_back({it[0],*pt});
                    mx=*pt;
                }   
            }
            else{
                auto p=st.find(it[1]);
                st.erase(p);
                auto pt=st.end();
                pt--;

                if(*pt!=mx){
                    ans.push_back({it[0],*pt});
                    mx=*pt;
                }      
            }
            
        }
        return ans;
    }
};
