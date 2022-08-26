class Solution {
public:
    bool reorderedPowerOf2(int n) {
        string a = to_string(n);
        sort(a.begin(), a.end());
        for(int i = 0; i<31; i++){
            int num = pow(2,i);
            string b = to_string(num);
            sort(b.begin(), b.end());
            if(a == b) return true;
        }
        return false;
    }
};
