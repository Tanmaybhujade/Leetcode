class Solution {
    String myTarget = null;
    public int[] movesToStamp(String stamp, String target) {
        int M = stamp.length(), N = target.length();
        myTarget = target;
        int count = 0;  
        boolean[] visited = new boolean[N];         
        List<Integer> index = new ArrayList<>();    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append('*');
        }
        
        String replace = sb.toString();

        while (count < N) {
            boolean found = false;
            for (int i = 0; i <= N - M; i++) {
                if (visited[i]) {
                    continue;
                }
                int len = doStamp(stamp, i, replace);
                if (len == 0) {
                    continue;
                }
                visited[i] = true;
                count += len;
                index.add(i);
                found = true;
            }
            if (!found) {
                return new int[]{};
            }
        }

        int size = index.size();
        int[] rst = new int[size--];
        for (int i = 0; i <= size; i++) {
            rst[i] = index.get(size - i);
        }
        return rst;
    }

    
    private int doStamp(String stamp, int start, String replace) {
        int changed = stamp.length();
        for (int i = 0; i < stamp.length(); i++) {
            if (myTarget.charAt(start + i) == '*') {
                changed--;
            } else if (myTarget.charAt(start + i) != stamp.charAt(i)) {
                return 0;
            }
        }

        if (changed != 0) {
            myTarget = myTarget.substring(0, start) + replace + myTarget.substring(start + stamp.length());
        }
        return changed;
    }
}
