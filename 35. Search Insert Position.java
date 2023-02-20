public class Solution {
    public int searchInsert(int[] A, int target) {
        
        if(A.length == 0)return 0;
        
        int left = 0, right = A.length - 1;
        int mid = 0;
        
        while(left <= right){
            
            if(target<A[left])return left;
            if(target>A[right])return right+1;
            
            mid = (left+right)/2;
            
            if(A[mid]==target)return mid;
            else if(target < A[mid]){
                right = mid-1;
            }else{
                left = mid +1;
            }
            
        }
        return -1;
        
        
    }
}
