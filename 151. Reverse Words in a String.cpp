class Solution {
public:
    string reverseWords(string s) {
        stack<string> res;
        int len=s.length();
        if(len==0||s.empty())
            return{};
        s=" "+s;
        string tmp;
        for(int i=1;i<s.length();i++)
        {
            if(s[i]!=' '&&s[i-1]==' ')
            {
               // res.push(tmp);
                tmp.clear();
                tmp+=s[i];
            }
            if(s[i]!=' '&&s[i-1]!=' ')
                tmp+=s[i];
            if(s[i]==' ')
                continue;
            if(i==s.length()-1||s[i+1]==' ')
                res.push(tmp);
        }
        string ans;
        if(res.empty()==true)
            return {};
        ans+=res.top();
        res.pop();
        while(res.empty()==false)
        {
            ans+=" ";
            ans+=res.top();
            res.pop();
        }
        return ans;
        
        
    }
};
