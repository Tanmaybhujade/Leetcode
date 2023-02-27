class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        // Recursively generate the tree by calling the generateTree function.
        return generateTree(0, n-1, 0, n-1, grid);
    }

    private Node generateTree(int rowStart, int rowEnd, int colStart, int colEnd, int[][] grid){
        // return null if out of bound
        if(rowStart > rowEnd && colStart > colEnd){
            return null;
        }
        boolean isSame = isSameValue(rowStart, rowEnd, colStart, colEnd, grid);
        boolean val = (isSame == true ? (grid[rowStart][colStart] == 1 ? true : false) : true);
        Node root = new Node(val, isSame);
        //If the values in the grid are not equal, then it's not a leaf node. Find the children of the current node.
        if(!isSame){
            root.topLeft = generateTree(rowStart, (rowEnd + rowStart)/2, colStart, (colStart + colEnd)/2, grid);
            root.bottomLeft = generateTree((rowEnd + rowStart)/2+1, rowEnd, colStart, (colStart + colEnd)/2, grid);
            root.topRight = generateTree(rowStart, (rowEnd + rowStart)/2, (colStart + colEnd)/2+1, colEnd, grid);
            root.bottomRight = generateTree((rowEnd + rowStart)/2+1, rowEnd, (colStart + colEnd)/2+1, colEnd, grid);
        }
        return root;
    }

    //Check if all the values in the Grid are equal or not.
    private boolean isSameValue(int rowStart, int rowEnd, int colStart, int colEnd, int[][] grid){
        int val = grid[rowStart][colStart];
        for(int i = rowStart; i <= rowEnd; i++){
            for(int j = colStart; j <= colEnd; j++){
                if(val != grid[i][j]) return false;
            }
        }
        return true;
    }
}
