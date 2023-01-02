class Solution {
    public boolean detectCapitalUse(String word) {
        String str = word.toLowerCase();
		if (word.substring(1).equals(str.substring(1)))
			return true;
		if (word.equals(str.toUpperCase()))
			return true;
		return false;
    }
}
    
