class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int start, int end) {
        unordered_map<int, vector<int>> graph; 
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]); 
            graph[edge[1]].push_back(edge[0]); 
        }
        stack<int> stk; 
        stk.push(start); 
        unordered_set<int> seen = {start}; 
        while (stk.size()) {
            int n = stk.top(); stk.pop(); 
            if (n == end) return true; 
            for (auto& nn : graph[n]) 
                if (!seen.count(nn)) {
                    seen.insert(nn); 
                    stk.push(nn); 
                }
        }
        return false; 
    }
};
