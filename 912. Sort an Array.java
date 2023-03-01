
class Solution {
public int[] sortArray(int[] arr) {
    int n = arr.length;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    
    for(int i: arr){
        max = Math.max(max, i);
        min = Math.min(min, i);
    }
    
    int range = max - min + 1;
    int countArray[] = new int[range];
    int output[] = new int[n];
    
  
    
    for(int i: arr)
        countArray[i-min]++;    
    
    
  
    for(int i=1; i<range; i++)
        countArray[i] += countArray[i-1];
    
    
    // filling values
    for(int i=n-1; i>=0; i--){
        // int val = countArray[arr[i]-min]-1;
        output[countArray[arr[i]-min]-1] = arr[i];
        countArray[arr[i]-min]--;
    }
    
   
    /
    for(int i=0; i<n; i++)
        arr[i] = output[i];
    
    return arr;
 }
}
