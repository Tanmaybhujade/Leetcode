class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long totalHours = 0;

        for (int hour : batteries) {
            totalHours += hour;
        }

        long startHour = 1, endHour = totalHours / n;

        while (startHour <= endHour) {
            long currentHour = startHour + (endHour - startHour) / 2;

            long extraHours = 0;

            for (int hour: batteries) {
                extraHours += Math.min(hour, currentHour);
            }

            long required = n * currentHour;

            if (extraHours >= required) {
                startHour = currentHour + 1;
            } else {
                endHour = currentHour - 1;
            }
        }

        return endHour;
    }
}
