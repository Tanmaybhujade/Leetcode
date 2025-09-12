class Solution {
public:
    bool doesAliceWin(string s){
        for(auto el : s){
            if(el == 'a' || el == 'e' || el == 'i' || el == 'o' || el == 'u') return true;
        }
        return false;
    }
};
