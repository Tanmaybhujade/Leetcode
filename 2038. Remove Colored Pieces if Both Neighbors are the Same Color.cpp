class Solution {
public:
    bool winnerOfGame(string colors) {
        int n = colors.length();
        int aliceWins = 0, bobWins = 0;
        
        // Iterate through the string colors.
        for (int i = 1; i < n - 1; ++i) {
            if (colors[i - 1] == 'A' && colors[i] == 'A' && colors[i + 1] == 'A') {
                aliceWins++;
            } else if (colors[i - 1] == 'B' && colors[i] == 'B' && colors[i + 1] == 'B') {
                bobWins++;
            }
        }
        
        // Alice starts, so if she has more opportunities to remove 'A', she wins.
        if (aliceWins > bobWins) {
            return true;
        }
        
        return false;
    }
};
