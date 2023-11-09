#include <string>
using namespace std;

class Solution {
public:
    int countHomogenous(string s) {
        int c = 1;
        int res = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s[i] == s[i-1]) {
                c++;
            }
            else {
                c = 1;
            }
            res = (res + c) % 1000000007;
        }
        return res + 1;
    }
};
