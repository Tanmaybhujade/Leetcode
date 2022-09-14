class Solution {
public:
    void helper(TreeNode *root,int &count,vector<int>&freq)
    {
        if(root==NULL)return;
        if(root->left==NULL && root->right==NULL)
        {
            //cout<<root->val<<" ";
            freq[root->val]++;
            bool valid=true;
            bool one_freq=false;
            for(int i=0;i<10;i++)
            {
                if(freq[i]%2==1)
                {
                    if(one_freq==false)
                    {
                        one_freq=true;
                    }
                    else
                    {
                        valid=false;\
                        break;
                    }
                }
            }
            if(valid)
            {
                count++;
            }
            freq[root->val]--;
            return ;
            
        }
        
        freq[root->val]++;
        helper(root->left,count,freq);     
        helper(root->right,count,freq);
        freq[root->val]--;

    }
    int pseudoPalindromicPaths (TreeNode* root) {
        
        int count=0;
        vector<int>freq(10,0);
        helper(root,count,freq);
        return count;
    }
};
