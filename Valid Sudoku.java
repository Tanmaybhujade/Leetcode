lass Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] table = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int offset = c - '1';

                int bits = 1 << offset;
                if ((table[i] & bits) > 0) {
                    return false;
                } else {
                    table[i] |= bits;
                }

                bits = bits << 9;
                if ((table[j] & bits) > 0) {
                    return false;
                } else {
                    table[j] |= bits;
                }

                bits = bits << 9;
                if ((table[i/3*3+j/3] & bits) > 0) {
                    return false;
                } else {
                    table[i/3*3+j/3] |= bits;
                }
            }
        }
        return true;
