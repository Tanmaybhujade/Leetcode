class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int i=0, j=0, countT=0, countF=0, max=0;
        while(j<s.length()) {
            if(s.charAt(j)=='T') {
                countT++;
            }else {
                countF++;
            }
            while(Math.min(countT, countF)>k) {
                if(s.charAt(i)=='T') {
                    countT--;
                }else {
                    countF--;
                }
                i++;

            }
            max = Math.max(max, countT+countF);
            j++;

        }
        return max;
    }
}
