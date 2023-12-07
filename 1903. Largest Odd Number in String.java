class Solution {
    public String largestOddNumber(String num) {
        // Iterate from the end of the string to the beginning
        for (int index = num.length() - 1; index >= 0; index--) {
            // Convert the character at the current index to an integer
            int digit = num.charAt(index) - '0';
          
            // Check if the digit is odd
            if ((digit & 1) == 1) {
                // If it's odd, return the substring from the start to the current index + 1
                // This is because substring function in Java is end-exclusive
                return num.substring(0, index + 1);
            }
        }
      
        // If no odd digit is found, return an empty string
        return "";
    }
}
