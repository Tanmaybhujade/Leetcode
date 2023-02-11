class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int needleIdx = 0;
        int startIdx = -1;
        boolean allMatch = false;
        boolean matchStart = false;
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(needleIdx) == haystack.charAt(i)) {
                if (!matchStart) {
                    matchStart = true;
                    startIdx = i;
                }

                if (needleIdx == needle.length() - 1) {
                    allMatch = true;
                    break;
                }

                needleIdx++;
            } else {
                if (matchStart) {
                    // 已匹配的 i 回溯
                    i = i - needleIdx;
                    matchStart = false;
                }

                startIdx = -1;
                needleIdx = 0;
            }
        }

        if (allMatch) {
            return startIdx;
        }

        return -1;
    }
}
