class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++) {
            int tmp = 0;
            int s = 0, e = potions.length;
            while(s < e) {
                int m = s + (e - s) / 2;
                if((long)spells[i] * potions[m] < success) {
                    s = m + 1; continue;
                }
                tmp = potions.length - m;
                e = m;
            }
            
            spells[i] = tmp;
        }

        return spells;
    }
}
