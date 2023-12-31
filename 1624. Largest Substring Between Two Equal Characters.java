class Solution {
   
  public static int maxLengthBetweenEqualCharacters(String s) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(int i=0;i<26;i++){
            f1[i] = -1;
            f2[i] = -1;
        }
        int n = s.length();
        for(int i=0;i<n;i++){
            if(f1[s.charAt(i)-'a'] == -1)
                f1[s.charAt(i)-'a'] = i;
            else
                f2[s.charAt(i)-'a'] = i;
        }
        
        int ans = -1;
        for(int i=0;i<26;i++)
            if(f2[i] != -1)
                ans = Math.max(ans, f2[i]-f1[i]-1);
        return ans;
    }
    
  public static void main (String[] args) throws java.lang.Exception
  {
    String s = "aa";
    System.out.print(maxLengthBetweenEqualCharacters(s));
  }
}
