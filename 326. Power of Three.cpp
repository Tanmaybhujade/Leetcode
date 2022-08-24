class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n == 0) return false;
        // cout << (log(n) / log(3)) << ", " << (log(n) / log(3)) - ceil((log(n) / log(3))) << endl;
        //ceil: round up
        //<1e-14: double precision 
        return abs((log(n) / log(3)) - ceil((log(n) / log(3)))) < 1e-14;
    }
};
