class Solution {
    
    private class Tuple {
        char ch;
        int occurance;
        private Tuple(char ch, int occurance) {
            this.ch = ch;
            this.occurance = occurance;
        } 
    }
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.occurance - a.occurance);
		/* the heap sorts the characters according to occurance in the reverse order */
        StringBuilder res = new StringBuilder();
        
		/* build a count map */
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (Character ch : map.keySet()) {
            pq.offer(new Tuple(ch, map.get(ch)));
        }
		/* poll from heap and add the character occurance number of times */
        while (pq.size() != 0) {
            Tuple t = pq.poll();
            while (t.occurance-- > 0) res.append(t.ch);
        }
        return res.toString();
    }
}
