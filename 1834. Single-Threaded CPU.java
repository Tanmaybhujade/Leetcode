class Solution {
    public int[] getOrder(int[][] tasks) {
        int N = tasks.length;

        // sort available tasks by their start time
        PriorityQueue<Integer> availableTasks = new PriorityQueue<>((a, b) -> tasks[a][0] - tasks[b][0]);
        // sort working tasks by their process time. when 2 tasks have identical process time, sort by task index
        PriorityQueue<Integer> workingTasks = new PriorityQueue<>((a, b) -> tasks[a][1] != tasks[b][1] ? tasks[a][1] - tasks[b][1] : a - b);
        
        int[] result = new int[N];

       for (int i = 0; i < N; i++) {
            availableTasks.offer(i);
        }
        
        int current = 0;
        int i = 0;

        while (!availableTasks.isEmpty()) {
            if (workingTasks.isEmpty() || tasks[availableTasks.peek()][0] <= current) {
                // move task from the availableTask queue to the workingTask queue when their start time is due
                int t = availableTasks.poll();
                current = Math.max(current, tasks[t][0]);
                workingTasks.offer(t);
            } else {
                // otherwise, process the enqued working tasks until new available task is due
                while (!workingTasks.isEmpty() && tasks[availableTasks.peek()][0] > current) {
                    int t = workingTasks.poll();
                    result[i++] = t;
                    current += tasks[t][1];                  
                }
            }
        }

        while (!workingTasks.isEmpty()) {
            result[i++] = workingTasks.poll();
        }
        
        return result;
    }
}
