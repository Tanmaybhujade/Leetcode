class Solution {
    public int[] vowelStrings(String[] words, int[][] qr) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0, x = 0;
        for(String word : words){
            char cs = word.charAt(0), ce = word.charAt(word.length()-1);
            if((cs == 'a' || cs == 'e' || cs == 'i' || cs == 'o' || cs == 'u') && (ce == 'a' || ce == 'e' || ce == 'i' || ce == 'o' || ce == 'u')){
                map.put(k, ++x);
            }else{
                map.put(k, x);
            }
            k++;
        }
        
        int ans[] = new int[qr.length], j = 0;
        for(int q[] : qr){
            int start = q[0], end = q[1], val = 0;
            if(start != 0){
                val += (map.get(end) - map.get(start-1));
            }else{
                if(map.get(start) == 0){
                    val += (map.get(end) - map.get(start));
                }else{
                    val += (map.get(end) - map.get(start)) + 1;
                }
            }
            ans[j++] = val;
        }
        return ans;
    }
}
    
