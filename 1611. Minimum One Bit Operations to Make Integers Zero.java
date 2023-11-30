class Solution {
    public int minimumOneBitOperations(int n) {
        int f[]=new int[31];
        f[0]=1;
        for(int i=1;i<31;i++){
            f[i]=2*f[i-1]+1;

        }
        int ans=0;
        int count=0;
        for(int i=30;i>=0;i--){
            if(((1<<i)&n)!=0){
                count++;
                if(count%2==0)
                ans-=f[i];
                else
                ans+=f[i];
            }
        }
        return ans;
        
    }
}
