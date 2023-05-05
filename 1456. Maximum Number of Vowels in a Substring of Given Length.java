class Solution {
    public int maxVowels(String s, int k) {
        int[] map = new int[26];
        char[] vowels = new char[]{'a','e','i','o','u'};
        int maxLength = 0;
        int left = 0, right = 0;
        
        while(right < s.length()){
            char rightChar = s.charAt(right);
            map[rightChar-'a']++;
            right++;
            //Update window and length
            if(right - left == k){
                char leftChar = s.charAt(left);
                int length = 0;
                for(char vowel : vowels){
                    length+=map[vowel-'a'];
                }
                maxLength = Math.max(length, maxLength);
                map[leftChar-'a']--;
                left++;
            }
        }
        
        return maxLength;
    } 
}
