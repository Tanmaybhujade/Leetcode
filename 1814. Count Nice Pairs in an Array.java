class Solution {
    
    
    //return with reverse of the integer int the array
    static int rev(int n){
        int rev = 0;
        while(n!=0){
            int remainder = n%10;
            rev = (rev * 10) +remainder;
            n = n/10;
        }
        
        return rev;
    }
    
    public int countNicePairs(int[] nums) {
        
        HashMap<Long, Long> hm = new HashMap<>();
        int mod=(int)Math.pow(10,9)+7;
        long count = 0;
        
        for(int i = 0; i < nums.length; i++){
            long key = nums[i]-rev(nums[i]);
            
            if(!hm.containsKey(key)){
                count = 1;
            }
            else{
                 count = hm.get(key);
                 count++;
            }
            hm.put(key,count%mod);
        }
        
        
        long result = 0;
        for(long i : hm.values()){
            result += (((i-1)*i)/2);
        }
        return (int)(result % mod);
    }
}
