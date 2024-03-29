class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans=new ArrayList<>();

        int[] nums=new int[n];
        boolean[] flag=new boolean[n];

        for(int i=0;i<n;i++)
        {
            nums[i]=i+1;
        }
        solve(nums,k,new ArrayList<>(),ans,flag,0);

    
        return ans;

            
    }

    public void   solve(int[] nums,int k,List<Integer> arr,List<List<Integer>> ans,boolean[] flag,int index)
    {
        if(arr.size()==k)
        {
          
                ans.add(new ArrayList<>(arr));
                return ;
        }

        for(int i=index;i<nums.length;i++)
        {
            if(!flag[i])
            {
                flag[i]=true;
                arr.add(nums[i]);  
                solve(nums,k,arr,ans,flag,i+1);
                arr.remove(arr.size()-1);
                flag[i]=false;

            }
        }
            
    }
    
}
