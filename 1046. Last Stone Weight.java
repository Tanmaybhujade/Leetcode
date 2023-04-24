class Solution {
    public int lastStoneWeight(int[] stones) {
         Queue <Integer>q=new PriorityQueue();
        for(int i:stones)
            q.offer(-i);
        while(q.size()>=2){
            int x=q.poll();
            int y=q.poll();
            if(-x>-y)
                q.offer(x-y);
        }
        return !q.isEmpty()?-q.peek():0;
    }
}
