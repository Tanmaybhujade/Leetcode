class Solution {
    static int curr;
    public int maximumScore(int[] nums, int k) {
        int result = nums[k];
        int curr_min=nums[k],i=k,j=k,c=1;
        while (j-i+1<nums.length) {
            if(i!=0||j!=nums.length){
                if (j+1==nums.length||i==0) {
                    if (j+1==nums.length) {
                        curr = nums[i-1];
                        i--;
                        c++;
                    }
                    else{ curr = nums[j+1];j++;c++;}
                    
                }
                else{
                    if (nums[i-1]>=nums[j+1]) {
                        curr = nums[i-1];
                        i--;
                        c++;
                    }
                    else{ curr = nums[j+1];j++;c++;}
                }
                
            }
            if (curr_min>curr) {
                curr_min=curr;
            }
            result=Math.max(result, curr_min*c);
        }
        return result;
        
    }

     
}
