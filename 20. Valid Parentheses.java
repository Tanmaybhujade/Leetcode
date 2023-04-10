class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> p = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque stack = new LinkedList<>();
        for (Character c: s.toCharArray()){
            if (p.containsKey(c) && !stack.isEmpty() && stack.getLast()==p.get(c))
                stack.removeLast();
            else stack.add(c);
            }
        return stack.isEmpty();
    }
}
