class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int ans = 0;
        stack.push(-1); // the previous index for the first one.
        for (var i = 0; i < n;i++){
            while((stack.peek()!=-1) &&(heights[stack.peek()]> heights[i])){
                ans=Math.max(ans,heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            ans=Math.max(ans,heights[stack.pop()]*(n-stack.peek()-1));
        }
        return ans;
    }
}
