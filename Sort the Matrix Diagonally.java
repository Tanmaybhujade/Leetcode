class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int i,j,k;
        int begin;
        // Traverses the diagonals from left to right
        // i.e. all diagonals whose beginning element will
        // be the element in the first row
        for(begin=0;begin<cols;begin++){
            k = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for(j=begin;j<Math.min(cols,begin+rows);j++){
                arr.add(mat[k++][j]);
            }
            Collections.sort(arr);
            
            k = 0;
            i = 0;
            for(j=begin;j<Math.min(cols,begin+rows);j++){
                mat[k++][j] = arr.get(i);
                i++;
            }
        }
        
        // Traverses the remaining diagonals from top to bottom
        // i.e. all diagonals whose beginning element will 
        // be the element in the first column.
        for(begin=1;begin<rows;begin++){
            k = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for(j=begin;j<rows && k<cols;j++){
                arr.add(mat[j][k++]);
            }
            
            Collections.sort(arr);
            
            k = 0;
            i = 0;
            for(j=begin;j<rows && k<cols;j++){
                mat[j][k++] = arr.get(i);
                i++;
            }
        }
        
        return mat;
    }
}
