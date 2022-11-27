class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
    
    
        HashMap<Integer, Integer>[] counts = new HashMap[n];
        
        
        int totalCount = 0;
        
        
        for(int end = 0; end < n; end++){
            
            counts[end] = new HashMap<>(end);
            
            for(int start = 0; start < end; start++){
                
                long diffInLong = (long)nums[end] - (long)nums[start];
                
    
                if(diffInLong < Integer.MIN_VALUE || diffInLong > Integer.MAX_VALUE) continue;
                
        
                int diff = (int)diffInLong;
                
                int count = counts[start].getOrDefault(diff, 0);
                
                totalCount += count;
                
                int prevCount = counts[end].getOrDefault(diff, 0);
                
            
                counts[end].put(diff, prevCount + count + 1);
            }
            
        }
        
        
        return totalCount;
        
    }
}
