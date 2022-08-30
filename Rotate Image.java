class Solution {
    public void rotate(int[][] matrix) {
       
        
        for(int i=0;i<matrix.length;i++){
            
            for(int j=i;j<matrix[0].length;j++){
                
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        int mid=0+((matrix.length-1)-0)/2;
        
        for(int i=0;i<matrix.length;i++){
            int c=matrix.length-1;
            for(int j=0;j<=mid;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][c];
                matrix[i][c]=temp;
                c--;
            }
        }
    }
}
