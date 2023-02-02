class Solution {
    public boolean isAlienSorted(String[] words, String order) {
    	String[] temp = new String[words.length];
    	for (int i = 0; i < words.length; i++)
    		temp[i] = words[i];
        Arrays.sort(words, new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
        			if (s1.charAt(i) != s2.charAt(i))
        				return order.indexOf(s1.charAt(i)) - order.indexOf(s2.charAt(i));
        		}
                if (s1.length() > s2.length())
                    return 1;
                else if (s2.length() > s1.length())
                    return -1;
                return 0;
        	}
        });
        for (int i = 0; i < words.length; i++)
        	if (!words[i].equals(temp[i]))
        		return false;
        return true;
    }
}
