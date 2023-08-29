class Solution {
    public int bestClosingTime(String c) {
        int n=c.length();
        //count the number of Y after including this point
        int[] yc=new int[n];
        //count the number of N before including this point
        int[] nc=new int[n];
        nc[0]=c.charAt(0)=='N'?1:0;
        yc[0]=c.charAt(0)=='Y'?1:0;
        for(int i=1;i<n;i++){
            if(c.charAt(i)=='N')nc[i]=nc[i-1]+1;
            else  nc[i]=nc[i-1];
            if(c.charAt(i)=='Y')yc[i]=yc[i-1]+1;
            else yc[i]=yc[i-1];
            
        }

        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<n+1;i++){
            //number of Y after the shop is closed
            int yp=(i==0)?yc[n-1]:yc[n-1]-yc[i-1];
            //number of N when he shop was open
            int np=(i==0)?0:nc[i-1];

            //finding the penalty 
            int pen=yp+np;
            //checking if it is the minimum one
            if(pen<min){
                min=pen;
                index=i;
            }
        }
        return index;
    }
}
