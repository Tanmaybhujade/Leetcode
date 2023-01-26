class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < flights.length; i++){
            int start = flights[i][0];
            int end = flights[i][1];
            map.putIfAbsent(start, new HashMap<Integer, Integer>());
            map.get(start).put(end, flights[i][2]);
        }
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        queue.add(new Pair(src, 0, k + 1));
        visited.put(src, 0);
        while(!queue.isEmpty()){
            Pair curr = queue.pollFirst();
            int index = curr.getKey();
            int cost = curr.getValue();
            int time = curr.getTime();
            if(time > 0 && map.containsKey(index)){
                for(Map.Entry<Integer, Integer> adj : map.get(index).entrySet()){
                    int i = adj.getKey();
                    int c = adj.getValue();
                    int sum = cost + c;
                    if(!visited.containsKey(i) || visited.get(i) > sum){ //Does not contain or cna be cheaper
                        queue.addLast(new Pair(i, sum, time - 1));
                        visited.put(i, sum);
                    }
                }
            }
        }
        return (visited.containsKey(dst) ? visited.get(dst) : -1);
    }
}
class Pair {
    public int index;
    public int cost;
    public int time;
    public Pair(int i, int c, int t){
        index = i;
        cost = c;
        time = t;
    }
    public int getKey(){
        return index;
    }
    public int getValue(){
        return cost;
    }
    public int getTime(){
        return time;
    }
}
