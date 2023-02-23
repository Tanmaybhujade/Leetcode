




class Solution {
   public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {return false;}
    HashMap<Character, Integer> mapS = new HashMap<>();
    HashMap<Character, Integer> mapT = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        if (!mapS.containsKey(s.charAt(i))) {
            if (mapT.containsKey(t.charAt(i))) {return false;}
        } else {
            int index = mapS.get(s.charAt(i));
            if (!mapT.containsKey(t.charAt(i)) || mapT.get(t.charAt(i)) != index) {return false;}
        }
        mapS.put(s.charAt(i), i);
        mapT.put(t.charAt(i), i);
    }
    return true;
}
}
