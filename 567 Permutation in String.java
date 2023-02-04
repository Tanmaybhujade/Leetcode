class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        if (window > s2.length()) return false;
        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        int[] map2 = new int[26];
        int start = 0;
        for (int i = start; i < start + window; i++) {
            map2[s2.charAt(i) - 'a']++;
        }
        while (start <= s2.length() - window) {
            boolean flag = true;
            if (start != 0) {
                map2[s2.charAt(start - 1) - 'a']--;
                map2[s2.charAt(start + window - 1) - 'a']++;
            }
            for (int i = 0; i < map1.length; i++) {
                if (map1[i] != map2[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
            start++;
        }
        return false;
    }
}
