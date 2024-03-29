class Solution {
    
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int start = 0, length = 0;
        for (int i = 0; i < words.length; i++) {
            /**
             * Try to add words till its under maxWidth length
             */
            if (words[i].length() <= (maxWidth - length)) {
                // + 1 because after each word there should be a space
                length += words[i].length() + 1;
                continue;
            }
            /**
             * Process the words which can be part of the justified sentence
             */
            else {
                /**
                 * Intention is try to get the remaining Spaces number and number of words part of the sentence
                 * As we have to distribute the spaces as evenly as possible, we can figure put the in between spaces
                 * between the words by doing remainingSpaces / noOfWords
                 * and there is a possibility that after evenly distributed the spaces also there can be some extra spaces
                 * which are pending.
                 *  Like for an example
                 *      remainingSpaces = 8 and noOfWords = 3
                 *      So in between spaces will be 8 / 3 = 2 spaces. But still 8 - (3 * 2) = 2 spaces are remaining
                 *      As per the problem those spaces can be placed sequentially between the words (till possible)
                 */

                /**
                 * Adding + 1 because none of the justified sentence should end with " " (space) and we have added space
                 * for each word while calculating the length of the words. So, just removing the space after last word
                 */
                int remainingSpaces = maxWidth - length + 1;

                /**
                 * Decreasing the number of word by 1 because
                 * If for a sentence 3 words are eligible the spaces should be distributed between
                 *  (word1 - word2) And (word2 - word3)
                 *  There should not be any trailing spaces.
                 */
                int noOfWords = i - start - 1;
                int extraSpaceBetweenWords = 0;

                if (noOfWords > 0) {
                    extraSpaceBetweenWords = remainingSpaces / noOfWords;
                    remainingSpaces = remainingSpaces % noOfWords;
                }

                /**
                 * Append the word, extra space & remainingSpaces (if present)
                 * Iterating till (i - 1) position as we want to add those extra spaces in between words not at end
                 * Like if for a sentence 3 words are eligible the spaces should be distributed between
                 *  (word1 - word2) And (word2 - word3)
                 */
                while (start < i - 1) {
                    sb.append(words[start++]).append(" ");
                    int k = 0;
                    while (k < extraSpaceBetweenWords) {
                        sb.append(" ");
                        k++;
                    }
                    if (remainingSpaces > 0) {
                        sb.append(" ");
                        remainingSpaces--;
                    }
                }
                // Appending the last word part of sentence
                sb.append(words[start]);

                /**
                 *  This will execute only for the cases where there is only 1 word part of the sentence
                 *  and its not covered as part of the previous while loop
                 */
                while (remainingSpaces > 0) {
                    sb.append(" ");
                    remainingSpaces--;
                }
                result.add(sb.toString());

                /**
                 * reset start position to current position
                 * update the length of the current word
                 * resetting the StringBuilder
                 */
                start = i;
                length = words[i].length() + 1;
                sb.setLength(0);
            }
        }

        /**
         * Processing the last sentence, which should be left-justified and no extra space is inserted between words.
         *
         * Iterating till (words.length - 1) position as we want to add those extra spaces in between words not at end
         * Like if for a sentence 3 words are eligible the spaces should be distributed between
         *  (word1 - word2) And (word2 - word3)
         */
        sb.setLength(0);
        while (start < words.length - 1) {
            sb.append(words[start++]).append(" ");
        }
        // Appending the last word part of sentence
        sb.append(words[start]);

        /**
         * Filling the rest position with extra spaces
         */
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        result.add(sb.toString());

        return result;
    }
    
}
