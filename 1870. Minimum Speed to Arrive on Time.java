class Solution {
  boolean func(long speed, double time, int[] arr){
    long tot = 0;
    for(int i = 0; i != arr.length - 1; i++){
      tot += arr[i] / speed;
      if( arr[i] % speed != 0) tot++;
    }
      
    return ((double)(arr[arr.length-1])/speed + (double)tot) <= time;
  }

  public int minSpeedOnTime(int[] dist, double hour) {
    long l = 1, r = 10000000;
    
    for(long m = (l + r)>>1; l <= r; m = (l + r)>>1) 
      if(func(m, hour, dist) )  r = m - 1;
      else                      l = m + 1; 
    
    if(l == 10000001) return -1;
    return (int)l;
  }
