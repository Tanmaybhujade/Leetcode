class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
       int ans[] = arr.clone();
        

        Arrays.sort(ans);

        ans[0] = 1; 
        int max=ans[0];
        for(int i = 0; i < ans.length; i++)
        {
            if( (i != 0) && (Math.abs(ans[i]-ans[i-1]) > 1))
            {
                ans[i] = ans[i-1] + 1; 
            }
            if(ans[i]>max){
                max=ans[i];
            }
        }
        
        
        return max; 
    }
}
