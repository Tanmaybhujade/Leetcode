public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int myGuess = n / 2;
        int response = guess(myGuess);
        while (response != 0) {
            if (response < 0) {
                high = myGuess - 1;
            } else {
                low = myGuess + 1;
            }
            myGuess = low + ((high - low) / 2);
            response = guess(myGuess);
        }
        return myGuess;
    }
}
