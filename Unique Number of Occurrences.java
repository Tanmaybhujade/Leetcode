class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        boolean [] c=new boolean[1001];
        int curr=arr[0];int count=1;
        for(int i=1;i<arr.length;i++){
            if(curr==arr[i]){
                count++;
            }
            else{
                if(c[count]){
                    return false;
                }
                else{
                    c[count]=true;
                }
                curr=arr[i];count=1;
            }
        }
        if(c[count]){
            return false;
        }
        else{
            return true;
        }
    }
}
