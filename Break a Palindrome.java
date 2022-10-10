class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1){
            return "";
        }
        for(int i = 0; i< palindrome.length();i++){
            StringBuilder sb = new StringBuilder(palindrome);
            //check if char is greater than 'a'
            if(palindrome.charAt(i) > 'a'){
                sb.setCharAt(i,'a');
                String val = sb.toString();
            //check if on changing it is a palindrome
                if(!(val.equals(sb.reverse().toString()))){
                   return val;
                }else{
                    sb.replace(0,n,palindrome);
                }
            }
            //check if it is  the last character
            if(i == palindrome.length() -1){
                sb.setCharAt(i,'b');
                return sb.toString();
            }
        }
        return palindrome;
    }
}
