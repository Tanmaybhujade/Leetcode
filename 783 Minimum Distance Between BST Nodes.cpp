class Solution {
public:
    stack<int> st;
    
    void inorder(TreeNode* root){ // inorder traversal gives sorted order of tree values
        if(!root){
            return;
        }
        inorder(root->left);
        st.push(root->val);
        inorder(root->right);
    }

    int minDiffInBST(TreeNode* root) {
        inorder(root);
        int ans = INT_MAX;
        int a = st.top();
        st.pop();
        int b;
        while(!st.empty()){
            b = st.top();
            st.pop();
            ans = min(ans , abs(a-b));
            a = b;
        }
        return ans;
    }
};
