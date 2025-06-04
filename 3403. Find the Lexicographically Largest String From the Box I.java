class Solution {
  public String answerString(String word, int numFriends) {
    if (numFriends == 1)
      return word;
    final String str = lastSubstring(word);
    final int size = word.length() - numFriends + 1;
    return str.substring(0, Math.min(str.length(), size));
  }

  // Returns the lexicographically last substring in the given string
  private String lastSubstring(String str) {
    int i = 0;
    int j = 1;
    int k = 0;
    int n = str.length();

    while (j + k < n) {
      if (str.charAt(i + k) == str.charAt(j + k)) {
        k++;
      } else if (str.charAt(i + k) > str.charAt(j + k)) {
        j = j + k + 1;
        k = 0;
      } else {
        i = Math.max(i + k + 1, j);
        j = i + 1;
        k = 0;
      }
    }

    return str.substring(i);
  }
}
