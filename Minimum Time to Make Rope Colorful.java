class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totaltime=0;
        int max = Integer.MIN_VALUE;
        int total=0;
        for(int i=1; i<neededTime.length; i++){
            
            if(colors.charAt(i)==colors.charAt(i-1))
            {   total = total+ neededTime[i-1];
                max = Math.max(max, neededTime[i-1]);
                
            }
            else{
                // System.out.println("i->"+i+" max->"+max);
                totaltime = totaltime+(max==Integer.MIN_VALUE?0:total+neededTime[i-1]-Math.max(max, neededTime[i-1]));
                total=0;
                max= Integer.MIN_VALUE;
            }
                
            
            
        }
        return totaltime+(max==Integer.MIN_VALUE?0:total+neededTime[neededTime.length-1]-Math.max(max, neededTime[neededTime.length-1]));
        
    }
}
