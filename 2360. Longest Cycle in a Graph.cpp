class Solution {
public:
    int longestCycle(vector<int>& edges) {
        int ans = -1;
        int n = edges.size ();
        vector<bool> vis (n, 0);
        for (int i = 0; i < edges.size (); i++) {
            unordered_map<int, int> mp;
            int dis = 0, node = i;
            //mp[node] = 0;
            if (vis[node] == 0) {
                while (node != -1) {
                    if (mp.find (node) != mp.end ()) {
                        ans = max (ans, dis-mp[node]);
                        break;
                    }
                    if (vis[node] == 1) {
                        break;
                    }
                    vis[node] = 1;
                    mp[node] = dis;
                    dis++;

                    node = edges[node];
                }
            }
        }
        return ans;
    }
};
