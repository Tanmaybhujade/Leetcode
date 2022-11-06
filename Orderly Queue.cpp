class Solution {
public:
    string orderlyQueue(string s, int k) {
        if(k == 1){
            int length = s.length();
            s += s;
            string str = s.substr(0, length);
            for(int i = 0; i < length; ++i)
                str = min(str, s.substr(i, length));
            return str;
        }
        sort(begin(s), end(s));
        return s;
    }
};
