class Solution {
public:
    int maxSatisfaction(vector<int>& sat) {
        sort(sat.begin(),sat.end());
        int n=sat.size();
        int total=0,res=0;
        for(int i=n-1;i>=0;i--)
        {
            total+=sat[i];  // postfix sum
            int prev_res=res;  
            res=(res+total>res)?res+total:res;
            if(prev_res==res)
                break;
        }
        return res;
    }

};
