class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        
        //Create 2 pq
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        //Initialize capital pq
        for(int i = 0; i < Profits.length; i++)
            pqCap.add(new int[] {Capital[i], Profits[i]});
        
        //For each project, find the max profit
        for(int i = 0; i < k; i++){
            while(!pqCap.isEmpty() && pqCap.peek()[0] <= W)
                pqPro.add(pqCap.poll());
            
            if(pqPro.isEmpty()) break;
            
            W += pqPro.poll()[1];
        }
        return W;
    }
}
