class Solution {
    public boolean exist(char[][] board, String word) {
        char[] worda = word.toCharArray();
        int wordlen = word.length();
        int len = board.length;
        int height = board[0].length;
        for(int i=0; i < len ; ++i){
            for(int j = 0; j < height; ++j){
                if(board[i][j] == worda[0]){
                    boolean res =dfs(worda, wordlen, 0, board, i, j, len, height);
                    if(res == true)
                        return true;
                }
            }
        } 
        return false;
    }
    
    public boolean dfs(char[] worda, int wordlen, int pos, char[][] board, int i, int j, int len, int height){
        if(i < 0 || j < 0 || i == len || j == height){
            return false;
        }
        
        if(board[i][j] == worda[pos]){
             char hold = board[i][j];
             board[i][j]='&';

            if(pos == wordlen-1){
                return true;
            }
            
            boolean a = dfs(worda, wordlen, pos+1, board, i+1, j, len, height)
            || dfs(worda, wordlen, pos+1, board, i-1, j, len, height)
            || dfs(worda, wordlen, pos+1, board, i, j+1, len, height)
            || dfs(worda, wordlen, pos+1, board, i, j-1, len, height);
            
            board[i][j] = hold;
            
            return a;
        }
        
        return false;
    
                
    }
}
