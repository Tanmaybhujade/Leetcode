class Solution {
    public int minSteps(String s, String t) {
        // Initialize an array to count the frequency of each character in the string s
        int[] charFrequency = new int[26];
      
        // Populate the character frequency array with the count of each character in s
        for (int i = 0; i < s.length(); ++i) {
            charFrequency[s.charAt(i) - 'a']++;
        }
      
        // This variable will keep track of the minimum number of steps (character changes)
        int minSteps = 0;
      
        // Iterate over the string t and decrease the frequency of each character in the charFrequency array
        for (int i = 0; i < t.length(); ++i) {
            // If the character's frequency after decrementing is negative,
            // it means that t has an extra occurrence of this character
            // that is not matched by a character in s.
            if (--charFrequency[t.charAt(i) - 'a'] < 0) {
                // Since this character is extra and unneeded, increase the minSteps
                minSteps++;
            }
        }
        // Return the total minimum number of steps to make t an anagram of s
        return minSteps;
    }
}
