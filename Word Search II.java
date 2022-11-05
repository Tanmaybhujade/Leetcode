class Solution {
    private final int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private int M, N;

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String wd : words)
            trie.addWord(wd);

        M = board.length;
        N = board[0].length;
        List<String> rt = new ArrayList<>();
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char cr = board[i][j];
                if (!visited[i][j] && trie.startsWith(cr)) {
                    helper(board, i, j, visited, trie.root(), rt);
                }
            }
        }

        return rt;
    }

    private void helper(char[][] board, int i, int j, boolean[][] visited, TrieNode node, List<String> rt) {
        if (node.end) {
            rt.add(node.word);
            node.end = false;
        }

        if (i == M || i < 0 || j == N || j < 0 || visited[i][j])
            return;
        char cr = board[i][j];
        if (node.letters[cr - 'a'] == null)
            return;

        visited[i][j] = true;
        for (int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];
            helper(board, ni, nj, visited, node.letters[cr - 'a'], rt);
        }
        visited[i][j] = false;
        
        // optimization
        if(node.letters[cr - 'a'].isTailNode()){
            node.letters[cr - 'a'] = null;
        }
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        char[] arr = word.toCharArray();
        for (char cr : arr) {
            if (cur.letters[cr - 'a'] == null)
                cur.letters[cr - 'a'] = new TrieNode();
            cur = cur.letters[cr - 'a'];
        }
        cur.end = true;
        cur.word = word;
    }

    public boolean startsWith(char cr) {
        return this.root.letters[cr - 'a'] != null;
    }

    public TrieNode root() {
        return this.root;
    }
}

class TrieNode {
    TrieNode[] letters;
    boolean end;
    String word;

    public TrieNode() {
        this.letters = new TrieNode[26];
        this.end = false;
        this.word = null;
    }
    
    public boolean isTailNode(){
        for(int i=0; i<26 ; i++) {
            if(this.letters[i] != null)
                return false;
        }
        return true;
    }
}
