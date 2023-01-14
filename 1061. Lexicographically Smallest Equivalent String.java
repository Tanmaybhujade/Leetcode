  class Solution {
    char[] id = new char[26];
    public String smallestEquivalentString(String A, String B, String S) {
        for (int i = 0; i < 26; i++) id[i] = (char)('a' + i);
        for (int i = 0; i < A.length(); i++) union(A.charAt(i), B.charAt(i));
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) s[i] = find(s[i]);
        return new String(s);
    }
    
    char find(char i) {
        if (id[i-'a'] != i) {
            int min = Integer.MAX_VALUE;
            while(i != id[i-'a']) {
                min = Math.min(min, id[i-'a']);
                i = id[i-'a'];
            }
            min = Math.min(min, id[i-'a']);
            return (char)min;
        }
        return id[i-'a'];
    }
    
    void union(char i, char j) {
        char a = find(i), b = find(j);
        if (a == b) return;
        if (a < b) {
            id[b-'a'] = a;
        } else id[a-'a'] = b;
    }
}
