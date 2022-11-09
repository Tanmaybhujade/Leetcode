class StockSpanner {
    Stack<int[]> stack;
    int  i;
    public StockSpanner() {
        stack = new Stack();
        i = -1;
    }
    
    public int next(int price) {
        i+=1;
        while(!stack.isEmpty() && (stack.peek()[1] <= price)){
            stack.pop();
        }
        
        if(stack.isEmpty()){
            stack.push(new int[]{i,price});
            return i+1;
        }
        
        int idx = stack.peek()[0];
        stack.push(new int[]{i,price});
        return i - idx;
    }
}
