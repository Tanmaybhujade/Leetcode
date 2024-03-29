class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> maps = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            maps.put(t.charAt(i), maps.getOrDefault(t.charAt(i), 0)+ 1);
        }
        int count = 0;//s.length();
        int begin = 0, head = 0, len = s.length() + 1;
        for(int end = 0; end < s.length(); end++) {
            if(maps.containsKey(s.charAt(end))) {
                maps.put(s.charAt(end), maps.getOrDefault(s.charAt(end), 0) - 1);
                //maps.put(s.charAt(end),maps.get(s.charAt(end))-1);
              if(maps.get(s.charAt(end)) >= 0) {
                    count++;
                } 
                while(count == t.length()) {
                    if(end - begin + 1 < len){
                        len = end - begin + 1;
                        head = begin;
                    }
                    if(maps.containsKey(s.charAt(begin))){
                        maps.put(s.charAt(begin), maps.getOrDefault(s.charAt(begin), 0) + 1);
                        //maps.put(s.charAt(begin),maps.get(s.charAt(begin))+1);
                        if(maps.get(s.charAt(begin)) > 0){
                            count--;
                        }
                    }
                    begin++;
                }
            }
        }
        if(len > s.length()){
            return "";
        }
        return s.substring(head, head + len);
    }
                
}
