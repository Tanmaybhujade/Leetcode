class WordDictionary {
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWord;
        TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.isWord;
        }
        if (word.charAt(idx) == '.') {
            for (char c : node.children.keySet()) {
                if (search(word, idx + 1, node.children.get(c))) {
                    return true;
                }
            }
        }
        else {
            if (node.children.get(word.charAt(idx)) != null) {
                return search(word, idx + 1, node.children.get(word.charAt(idx)));
            }
        }
        return false;
    }
}
