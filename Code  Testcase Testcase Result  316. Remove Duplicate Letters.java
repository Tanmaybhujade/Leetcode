class Solution {
    Stack<Character> stack;
    StringBuilder resultStr;
    Map<Character, Integer> charFreq;
    public Solution(){
        stack=new Stack<>();
        resultStr=new StringBuilder();
        charFreq=new HashMap<>();
    }
    public String removeDuplicateLetters(String s) {
        this.charFrequencyMapper(s);
        for(int i=0;i<s.length();i++){
            if(!stack.contains(s.charAt(i))){                                 
                while(!stack.isEmpty() && stack.peek()>s.charAt(i) && charFreq.get(stack.peek())>0){
                    stack.pop();
                    resultStr.deleteCharAt(resultStr.length()-1);
                }                                    
                stack.push(s.charAt(i));
                resultStr.append(s.charAt(i));                                
            }            
            charFreq.put(s.charAt(i), charFreq.get(s.charAt(i))-1);                        
        }        
        return resultStr.toString();
    }
    public void charFrequencyMapper(String string){
        for(int i=0;i<string.length();i++){
            charFreq.putIfAbsent(string.charAt(i), 0);
            charFreq.put(string.charAt(i), charFreq.get(string.charAt(i))+1);
        }
    }
}
