class Solution{

public:
    string findLargest(int N, int S){
        string ans;
        if(S>9*N){
            ans = ans + to_string(-1);
            return ans;
        }
        if(N>1 && S ==0){
            ans = ans + to_string(-1);
            return ans;
        }
        int i = 1;
        int sum = S;
        while(i<=N){
            if(sum >= 10){
                ans =  ans + to_string(9);
            }
            else {
                if(sum < 0){
                    ans = ans + to_string(0);
                }
                else {
                    ans = ans + to_string(sum);
                }
            }
            sum = sum - 9;
            i++;
        }
        return ans;
    }
};
