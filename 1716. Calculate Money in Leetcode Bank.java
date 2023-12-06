class Solution {

    /**
     * Calculates the total amount of money after n days, with the money amount increasing every day and resetting every week.
     *
     * @param n Total number of days.
     * @return Total amount of money accumulated over n days.
     */
    public int totalMoney(int n) {
        // Calculate the number of complete weeks.
        int completeWeeks = n / 7;
      
        // Calculate the remaining days after the complete weeks.
        int remainingDays = n % 7;
      
        // Calculate the total money saved during the complete weeks.
        // The first week, a person saves 1+2+...+7 = 28. The amount increases by 7 for every subsequent week.
        int totalCompleteWeeksMoney = (28 + (28 + 7 * (completeWeeks - 1))) * completeWeeks / 2;
      
        // Calculate the total money saved during the remaining days.
        // Starting day of the week determines the money saved on the first day of remaining days.
        int totalRemainingDaysMoney = ((completeWeeks * 2) + remainingDays + 1) * remainingDays / 2;
      
        // Return the sum of money saved during the complete weeks and the remaining days.
        return totalCompleteWeeksMoney + totalRemainingDaysMoney;
    }
}
