class Solution {
public:
    int calculate(string s)
    {
        s = "(" + s + ")";
        int idx = 0;
        return helper(s, idx);
    }
    
    int helper(string& s, int& idx)
    {
        int res = 0, sign = 1;
        while(idx < s.length())
        {
            if(s[idx] == ')') 
            {
                idx++;
                return res;
            }
            else if(s[idx] == '(')
            {
                idx++;
                res += sign * helper(s, idx);
            }
            else if(s[idx] == '+') 
            {
                sign = 1;
                idx++;
            }
            else if(s[idx] == '-') 
            {
                sign = -1;
                idx++;
            }
            else if(isNumber(s[idx]))
                res += sign * getNumber(s, idx);
            else idx++;
        }
        return res;
    }
    
    int getNumber(string& s, int& idx)
    {
        int n = 0;
        while(idx < s.length() && isNumber(s[idx]))
        {
            n *= 10;
            n += (int)(s[idx] - '0');
            idx++;
        }
        return n;
    }
    
    bool isNumber(char ch)
    {
        return '0' <= ch && ch <= '9';
    }
};
