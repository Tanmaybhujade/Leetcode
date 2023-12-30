class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];

        for(String word : words){
            for(char ch : word.toCharArray()){
                count[ch - 'a']++;
            }
        }

        int len = words.length;

        for(int val : count){
            if(val % len != 0) return false;
        }

        return true;
    }
}
