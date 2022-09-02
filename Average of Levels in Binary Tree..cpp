class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> v;
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            double size=q.size(), sum=0;
            for(int i=0; i<size; i++){
                TreeNode *node=q.front();
                sum += node->val;
                q.pop();
                
                if(node->left)
                    q.push(node->left);
                if(node->right)
                    q.push(node->right);
            }
            v.push_back(double(sum/size));
        }
        
        return v;
    }
};
