public class Solution {
    public int evalRPN(String[] tokens) {
        Map<String, IntBinaryOperator> operations = new HashMap<>();
        operations.put("+", (x, y) -> y + x);
        operations.put("-", (x, y) -> y - x);
        operations.put("*", (x, y) -> y * x);
        operations.put("/", (x, y) -> y / x);
        Stack<Integer> res = new Stack<>();
        for(String s : tokens)
            if(operations.containsKey(s)) res.push(operations.get(s).applyAsInt(res.pop(), res.pop()));
            else res.push(Integer.valueOf(s));
        return res.pop();
    }
}
