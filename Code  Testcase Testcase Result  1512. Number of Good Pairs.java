import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int num: nums) {
            if (m.containsKey(num)) {
                count += m.get(num);
                m.put(num, m.get(num) + 1);
            } else {
                m.put(num, 1);
            }
        }
        return count;
    }
}
