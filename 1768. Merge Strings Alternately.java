class Solution {
    public String mergeAlternately(String word1, String word2){
        int i = 0; int j = 0; 
        StringBuilder ans = new StringBuilder();
        while(true){
           if(i == word1.length()){
               ans.append(word2.substring(j));
               break;
           }
            if(j == word2.length()){
               ans.append(word1.substring(i));
                break;
           }
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(j));
             i++;
            j++;
        }
        return ans.toString();
    }
    
}
