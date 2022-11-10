class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        char ch[]=s.toCharArray();
        for(char c:ch){
            
			
            if(!st.isEmpty() && st.peek()==c)st.pop();
            else{
                //add to stack
                st.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char ss : st) sb.append(ss);
        return sb.toString();
        
    }
}
