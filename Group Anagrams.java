public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String sorted = sort(strs[i]);
            List<String> list = null;
            if (map.containsKey(sorted)) {
                list = map.get(sorted);
            } else {
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            map.put(sorted, list);
        }
        for (List<String> list: map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    private String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
