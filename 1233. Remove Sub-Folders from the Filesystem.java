class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); //Sort the folder by lexicological order

        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        String lastAdded = folder[0] + '/';
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(lastAdded)) {
                result.add(folder[i]);
                lastAdded = folder[i] + '/';
            }
        }
        return result;
    }
}
