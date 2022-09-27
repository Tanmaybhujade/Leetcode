class Solution {
    
    public String pushDominoes(String s) {
        
        Queue<Integer> que = new LinkedList<>();
        StringBuilder ans = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '.') que.add(i);
        }
        
        
        while(que.size() > 0) {
            int size = que.size();
            HashSet<Integer> hash = new HashSet<>();
            while(size-- > 0) {
                int i = que.poll();
                
                if(ans.charAt(i) == 'L') {
                    if(i - 1 >= 0 && ans.charAt(i - 1) == '.') {
                        ans.setCharAt(i - 1, 'L');
                        hash.add(i - 1);
                        que.add(i - 1);
                    } else if( i - 1 >= 0 && ans.charAt(i - 1) == 'R') {
                        if(hash.contains(i - 1)) {
                            ans.setCharAt(i - 1, '.');
                        }
                    }
                } else if(ans.charAt(i) == 'R') {
                    if(i + 1 < ans.length() && ans.charAt(i + 1) == '.') {
                        ans.setCharAt(i + 1, 'R');
                        hash.add(i + 1);
                        que.add(i + 1);
                    } else if( i + 1 < ans.length() && ans.charAt(i + 1) == 'L') {
                        if(hash.contains(i + 1)) {
                            ans.setCharAt(i + 1, '.');
                        }
                    }
                }
            }
        }  
        return ans.toString();
    }
}
