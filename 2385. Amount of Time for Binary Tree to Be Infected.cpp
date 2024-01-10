
class Solution {
public:
    unordered_map<TreeNode* ,pair<TreeNode*,bool>> parent;
    //unordered_set<TreeNode*> visited;
    void Assignparent(TreeNode* root,TreeNode* &node){
        if(!root)return ;
        if(root->val == node->val){
            node = root;
        }
        if(root->left) parent[root->left].first = root;
        Assignparent(root->left,node);
        if(root->right) parent[root->right].first =root;
        Assignparent(root->right,node);
    }
    void distance(TreeNode* root,int k, int &ans){
         if(!root || parent[root].second )return ;
         parent[root].second = 1;
         k = k+1;
         ans = max(ans,k);
         distance(root->left,k,ans);
         distance(root->right,k,ans);
         if(parent[root].first)distance(parent[root].first,k,ans);
    }
    int amountOfTime(TreeNode* root, int start) {
        TreeNode* node = new TreeNode(start);
        Assignparent(root,node);
        int ans = 0;
        distance(node,0,ans);
        return ans-1;        
    }
};
