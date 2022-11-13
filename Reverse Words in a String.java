public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String pre = "";
        int start = -1;
        int end = -1;
        for (int i = s.length() - 1; i >= -1; i--) {
            if (i == - 1 || s.charAt(i) == ' ') {
                end = i + 1;
                if (start >= end) {
                    sb.append(pre);
                    sb.append(s.substring(end, start + 1));
                    pre = " ";
                }
                start = -1;
            } else {
                start = start == -1 ? i : start;
            }
        }
        return sb.toString();
    }
}
