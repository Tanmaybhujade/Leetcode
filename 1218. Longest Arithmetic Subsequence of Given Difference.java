class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int x : arr){
            if(map.containsKey(x-diff)){
                int out = map.get(x - diff);
                map.put(x,  out + 1);
                max = Math.max(out + 1, max);
            }
            else{
                map.put(x,1);
                max = Math.max(1, max);
            }
        }
        return max;
    }
}
