class Solution {
    vector<vector<int>> graph;

    pair<long,long> dfs(int i, int prev, int seats) {
        long res = 0;
        long cnt = 1;
        for (auto c : graph[i]) {
            if (c == prev) {
                continue;
            }
            auto [sub_res, sub_cnt] = dfs(c, i, seats);
            res += sub_res; // accumulate sub_res
            res += (sub_cnt + seats - 1) / seats; // from c to i, there are sub_cnt people
            cnt += sub_cnt;
        }
        return {res, cnt};
    }
    
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        int N = roads.size()+1;
        graph.resize(N);

        for (auto &r : roads) {
            graph[r[0]].push_back(r[1]);
            graph[r[1]].push_back(r[0]);
        }

        return dfs(0, -1, seats).first;
    }
};
