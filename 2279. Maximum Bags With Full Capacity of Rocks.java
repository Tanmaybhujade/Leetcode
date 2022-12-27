class Solution {
    public int maximumBags(int[] c, int[] r, int a) {
        int k=c.length;
        int b[]=new int[k];
        for(int i=0;i<k;i++)
        {
            b[i]=c[i]-r[i];
        }
        Arrays.sort(b);
        int m=0;
        for(int i=0;i<k;i++)
        {
            if(a-b[i]<0)
                break;
            a-=b[i];
            m++;
        }
        return m;
    }
}
