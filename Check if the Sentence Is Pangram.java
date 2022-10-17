class Solution {
 public static boolean checkIfPangram(String sentence) {

        boolean[] is = new boolean[26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (char c : sentence.toCharArray()){

            is[c - 'a'] = true;
        }

        for (char m : alphabet.toCharArray()){

            if (!is[m-'a']){

                return false;
            }

        }

        return true;
    }
}
