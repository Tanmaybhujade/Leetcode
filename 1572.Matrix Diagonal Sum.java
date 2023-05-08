class Solution {


    public static int diagonalSum(int[][] mat) 
    {
        int n=mat.length;
        
        int sum=0;
        int i=0,j=0;
        
        while(i<n)
        {
            sum+=mat[i][j];
            i++;
            j++;
        }
        
        i=0;
        j=n-1;
        
        while(i<n)
        {
          if(i!=j)   sum+=mat[i][j];
            
            i++;
            j--;
        }
        
        return sum;
        
    }
    
    public static void main(String args[])
    {
       int[][] mat={
            {1,2,3},
            {4,5,6},
            {7,8,9}  
        };
    
       System.out.println(diagonalSum(mat));
   
    }

    
}
