class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,LinkedList<Integer>> hm=new HashMap<>();
        int ptr=0;
        int idx=0;
        int n=nums.length;
        int ans=0;

        while(idx<n){
            int num=nums[idx];
            if(hm.containsKey(num)){
                hm.get(num).addLast(idx);
            }else{
                LinkedList q=new LinkedList<>();
                q.addLast(idx);
                hm.put(num,q);
            }

            LinkedList tq=hm.get(num);
            if(tq.size()>k){
                //System.out.println(tq.remove());
                int nidx=Integer.parseInt(tq.remove()+"");
                ptr=Math.max(ptr,nidx+1);
            }

            ans=Math.max(idx-ptr+1,ans);
            idx++;
        }

        return ans;
    }
}
