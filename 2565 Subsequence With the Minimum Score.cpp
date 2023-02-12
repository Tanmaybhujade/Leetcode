class Solution {
public:
    int minimumScore(string s, string t) {
        int n = s.size(), m = t.size(); 
        vector<int> l(m, -1), r(m, -1); 
        int j = 0; 
        for (int i = 0; i < n; ++i) {
            if (j >= m) break; 
            if (s[i] == t[j]) {
                l[j] = i; 
                j++; 
            }
        }
        j = m-1; 
        for (int i = n-1; i >= 0; --i) {
            if (j < 0) break; 
            if (s[i] == t[j]) {
                r[j] = i; 
                j--; 
            }
        }
        int ans = m; 
        for (int i = 0; i < m; ++i) { 
            if (l[i] != -1) ans = min(ans, m-i-1); 
            if (r[i] != -1) ans = min(ans, i); 
        }
        if (r[m-1] == -1) return ans; 
        
        for (int i = 0; i < m-1; ++i) {
            if (l[i] != -1) {
                if (l[i] >= r[m-1]) break; 
                
                int lo = i + 1, hi = m - 1; 
                while (lo < hi) {
                    int md = lo + (hi - lo)/2; 
                    if (l[i] < r[md]) hi = md; 
                    else lo = md + 1; 
                } 
                ans = min(ans, lo - i - 1); 
            }
        }
        return ans; 
    }
};
