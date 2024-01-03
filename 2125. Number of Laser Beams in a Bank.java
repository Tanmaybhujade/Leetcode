class Solution {
    // Method to calculate the number of beams created by laser security systems in the bank.
    public int numberOfBeams(String[] bank) {
        // Initial count for the previous row that had at least one security device.
        int previousCount = 0;
        // Initialize the total number of beams to 0.
        int totalBeams = 0;
      
        // Iterate over each row in the bank.
        for (String row : bank) {
            // Initialize the count of security devices in the current row.
            int currentCount = 0;
            // Convert the current row to a character array for iteration.
            char[] devices = row.toCharArray();
            for (char device : devices) {
                // Check if the current spot has a security device (denoted by '1').
                if (device == '1') {
                    // Increment the count of devices in the current row.
                    ++currentCount;
                }
            }
            // If the current row has at least one security device, calculate beams.
            if (currentCount > 0) {
                // Add the number of beams formed between the previous and current row to totalBeams.
                totalBeams += previousCount * currentCount;
                // Update previousCount to be the count of the current row for the next iteration.
                previousCount = currentCount;
            }
        }
        // Return the total number of beams formed in the bank.
        return totalBeams;
    }
}
