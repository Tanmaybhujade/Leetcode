class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findAllPaths(graph, ans, currentPath, 0);
        return ans;
    }

    private static void findAllPaths(int[][] graph, List<List<Integer>> ans, List<Integer> currentPath, int index) {
        if (index == graph.length - 1) {
            currentPath.add(index);
            ans.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        for (int i : graph[index]) {
            currentPath.add(index);
            findAllPaths(graph, ans, currentPath, i);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
