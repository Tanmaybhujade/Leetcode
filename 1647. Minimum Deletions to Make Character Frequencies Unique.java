class Solution {
    public int minDeletions(String str) {
        char s[] = str.toCharArray();
        int freq[] = new int[26];
        for(var c : s){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        reverse(freq);
        HashSet<Integer> unqFreq = new HashSet<>();
        for(var f : freq){
            if(f != 0)unqFreq.add(f);
        }
        int dels = 0;
        int missFreq = -1;
        for(int indx = 0; indx < 26; indx++){
            if(freq[indx] == 0)break;
            if(indx + 1 < 26 && freq[indx] == freq[indx+1]){
               int currFreq = freq[indx];
               missFreq = currFreq;
               while(missFreq > 0 && unqFreq.contains(missFreq))missFreq--;
               dels += currFreq - missFreq;
               if(missFreq != 0)unqFreq.add(missFreq);
            }
        }
        return dels;
    }
    private static void reverse(int[] array)
    {
 
      
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }
}
