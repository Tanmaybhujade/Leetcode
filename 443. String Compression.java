class Solution {
    public int compress(char[] chars) {
        int pos=0;
        int i=0;
        
        while (i<chars.length){
            int j=i+1;
            while (j<chars.length && chars[i]==chars[j]){
                j++;
            }
            //the ith character repeats till j-1th index
            chars[pos]=chars[i];
            pos++;
            
            int occurrences=j-i;
            if (occurrences==1){
                i=j;
            } else {
                String s=Integer.toString(j-i);
                int lv=0;
                while (lv!=s.length()){
                    chars[pos]=s.charAt(lv);
                    lv++;
                    pos++;
                }
                i=j;
            }
            
        }
        return pos;
    }
}
