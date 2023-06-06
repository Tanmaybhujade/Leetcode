class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            if(i==0)
                count=arr[i+1]-arr[i];
            else if(count!=arr[i+1]-arr[i])
                return false;
        }
        return true;
    }
}
