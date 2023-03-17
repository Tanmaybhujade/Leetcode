class TrieNode 
{
    // Initialize your data structure here.
    char content;
    boolean isEnd;
    LinkedList<TrieNode> childList;
    public TrieNode(char c) 
    {
        content = c;
        isEnd = false;
        childList = new LinkedList<TrieNode>();
    }
    
    public TrieNode haveSubNode(char c)
    {
        if(childList != null)
        {
            for(TrieNode n : childList)
            {
                if(n.content == c)
                    return n;
            }
        }
        return null;
    }
}

public class Trie
{
    private TrieNode root;

    public Trie() 
    {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word)
    {
        if(search(word))
            return;
        TrieNode cur = root;
        for(char c : word.toCharArray())
        {
            if(cur.haveSubNode(c) != null)
                cur = cur.haveSubNode(c);
            else
            {
                TrieNode child = new TrieNode(c);
                cur.childList.add(child);
                cur = cur.haveSubNode(c);
            }
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) 
    {
        TrieNode cur = root;
        for(char c : word.toCharArray())
        {
            if(cur.haveSubNode(c) == null)
                return false;
            else
                cur = cur.haveSubNode(c);
        }
        if(cur.isEnd == true)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) 
    {
        TrieNode cur = root;
        for(char c : prefix.toCharArray())
        {
            if(cur.haveSubNode(c) == null)
                return false;
            cur = cur.haveSubNode(c);
        }
        return true;
    }
}
