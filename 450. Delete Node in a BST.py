class Solution:
    def findSuccessor(self, root):
        root = root.right
        while root.left:
            root = root.left
            
        return root
    
    def findPredecessor(self, root):
        root = root.left
        while root.right:
            root = root.right
            
        return root
    
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None
        
        if key < root.val:
            root.left = self.deleteNode(root.left, key)        
            
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)        
            
        else:
            if not root.left and not root.right:
                return None
            
            if root.left:
                predecessor = self.findPredecessor(root)
                root.val = predecessor.val
                root.left = self.deleteNode(root.left, predecessor.val)
                
            else:
                successor = self.findSuccessor(root)
                root.val = successor.val
                root.right = self.deleteNode(root.right, successor.val)
        
        return root
