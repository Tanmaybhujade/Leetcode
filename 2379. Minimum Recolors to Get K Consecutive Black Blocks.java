class Solution {
    public int minimumRecolors(String s, int k) {
        int n = s.length();
        int w = 0;
        for (int i = 0; i < k; ++i)
            if (s.charAt(i) == 'W') ++w;
        int minw = w;
        for (int i = k; i < n; ++i) {
            if (s.charAt(i) == 'W') ++w;
            if (s.charAt(i - k) == 'W') --w;
            minw = Math.min(minw, w);
        }
        return minw;
    }
}
