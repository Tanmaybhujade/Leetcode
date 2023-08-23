
 class Solution {
    public static String reorganizeString(String s) {
        int[] charCount = new int[26]; // Assuming lowercase English letters
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount[b - 'a'] - charCount[a - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (charCount[c - 'a'] > 0) {
                maxHeap.offer(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            if (result.length() == 0 || current != result.charAt(result.length() - 1)) {
                result.append(current);
                charCount[current - 'a']--;
                if (charCount[current - 'a'] > 0) {
                    maxHeap.offer(current);
                }
            } else {
                if (maxHeap.isEmpty()) {
                    return "";  // Impossible to rearrange
                }
                char next = maxHeap.poll();
                result.append(next);
                charCount[next - 'a']--;
                if (charCount[next - 'a'] > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(current);
            }
        }
        
        return result.toString();
    }
    
}
