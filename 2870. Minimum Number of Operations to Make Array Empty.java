class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int op=0;
        for(int i=0;i<nums.length;i++) hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            int freq=e.getValue();

            if(freq==1) return -1;
             op+=freq/3+1;
             if(freq%3==0) op--; 
             
            
        }
        return op;
    }
}
