
class Solution {
  vector<int>parent;
    vector<int>rank1;
public:
    int find(int x)
    {
        if(parent[x] < 0)
        {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    void union1(int a , int b)
    {
        a = find(a);
        b = find(b);
        
        if(a==b) return;
        
        if(rank1[a] > rank1[b])
        {
            parent[b] = a;
            rank1[a]+=rank1[b];
        }
        else
        {
            parent[a] = b;
            rank1[b]+=rank1[a];
        }
    }
    bool check(string&a , string&b)
    {
        int cnt = 0;
        for(int i = 0 ; i < a.size() ; i++)
        {
            if(a[i]!=b[i])
            {
                cnt++;
            }
        }
        return (cnt==0 || cnt==2);
    }
    int numSimilarGroups(vector<string>& strs) {
      int n = strs.size();
      set<int>output;
      parent.resize(n+1,-1);
      rank1.resize(n+1 , 0);
      for(int i = 0 ; i < n ; i++)
      {
          string temp = strs[i];
          for(int j = i+1 ; j < n ; j++)
          {
             string h = strs[j];
             if(check(temp,h))
             {
                 union1(i,j);
             }
          }
      }
      for(int i = 0 ; i < n ; i++)
      {
          output.insert(find(i));
      }
        return output.size();
    }
};
