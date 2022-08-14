


class Solution
{
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        unordered_map<string, int> distMap;

        queue<string> q;
        int k = beginWord.size();
        q.push({beginWord});
        distMap[beginWord] = 0;

        // BFS to calculate distances
        while (!q.empty())
        {
            int qLen = q.size();
            for (int i = 0; i < qLen; i++)
            {
                string currWord = q.front();
                q.pop();
                int x = distMap[currWord] + 1;
                for (int j = 0; j < k; j++)
                {
                    char origChar = currWord[j];
                    for (char nextChar = 'a'; nextChar <= 'z'; nextChar++)
                    {
                        currWord[j] = nextChar;
                        if (distMap.count(currWord) == 0 &&
                            wordSet.count(currWord) != 0) {
                            distMap[currWord] = x;
                            q.push(currWord);
                        }
                    }
                    currWord[j] = origChar;
                }
            }
        }

        vector<string> currPath;
        vector<vector<string>> res;

        if (distMap.count(endWord) != 0)
            dfs(endWord, beginWord, currPath, res, distMap);
        return res;
    }

    // DFS to get paths
    void dfs(string word, string beginWord, vector<string>& currPath, vector<vector<string>>& res, unordered_map<string, int>& distMap)
    {
        currPath.push_back(word);
        if (word == beginWord)
        {
            vector<string> x = currPath;
            reverse(x.begin(), x.end());
            res.push_back(x);
            currPath.pop_back();
            return;
        }
        int cur = distMap[word];
        for (int i = 0; i < word.size(); i++)
        {
            char c = word[i];
            for (char cc = 'a'; cc <= 'z'; cc++)
            {
                word[i] = cc;
                if (distMap.count(word) && distMap[word] == cur - 1)
                    dfs(word, beginWord, currPath, res, distMap);
            }
            word[i] = c;
        }
        currPath.pop_back();
    }

};
































