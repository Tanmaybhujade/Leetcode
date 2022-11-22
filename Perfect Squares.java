class Solution {
    public int numSquares(int n) { 

        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                int counter = 1;
                int next = 1;
                while (next > 0) {
                    next = current - (counter * counter);
                    if (next == 0) {
                        return level + 1;
                    }
                    if (next > 0) {
                        queue.offer(next);
                    }
                    counter++;
                }
            }
            level++;
        }
        return level;
    
    }
}
