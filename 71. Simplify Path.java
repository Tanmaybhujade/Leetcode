class Solution {
public:
    string simplifyPath(string s) {
        list<string> st;
        int n = s.size();
        int i = 0; 
        while(i < n) {
            if (s[i] == '/') {
                i++;
                continue;
            }
            size_t pos = s.find('/',i);
            int end = pos != string::npos?pos-1 : n-1;
            string temp = string(s,i,end-i+1);
            if (temp == ".." && st.size() > 0) {
                st.pop_back();
            } else if (temp != "." && temp != "..") {
                st.push_back(temp);
            }
            i = end+1;
        }
        
        string res = "";
        while(!st.empty()) {
            string t = st.front();
            st.pop_front();
            res += "/"+t;
        }
        return res.size() > 0 ? res : "/";
    }
};
