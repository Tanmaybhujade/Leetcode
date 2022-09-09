class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        sort(properties.begin(), properties.end(), [](vector<int>& a, vector<int>& b){return a[0] > b[0];});

        multiset<int> dScores;
        for (auto ad : properties)
            dScores.insert(ad[1]);

        int weak = 0;

        int maxbsofar = 0;
        for (int i = 0; i < properties.size()-1; i++){
            auto it = dScores.find(properties[i][1]);
            if (it != dScores.end()) dScores.erase(it);

            maxbsofar = max(maxbsofar, properties[i][1]);
            if (properties[i][0] == properties[i+1][0]) continue;

            for (auto it = dScores.begin(); it != dScores.end() && *it < maxbsofar; ){
                dScores.erase(it++);
                weak++;
            }

            if (dScores.empty()) break;
        }

        return weak;
    }
};
