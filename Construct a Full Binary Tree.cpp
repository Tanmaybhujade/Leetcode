class Solution{
  public:
  Node* helper(int pre[],int l,int r){
        int mid =(l+r)/2;
        Node* temp=new Node(pre[l]);
        if(l<r){
         temp->left=helper(pre,l+1,mid);
         temp->right=helper(pre,mid+1,r);
        }
    return temp;
    }

    Node* constructBinaryTree(int pre[], int preMirror[], int size)
    {
        // Code here
        return helper(pre,0,size-1);
    }
};
