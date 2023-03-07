class Solution {
  public long minimumTime(int[] time, int totalTrips) {
    long start = 0;
    // largest possible time: 10 ^ 7 * totalTrips
    long end = 1_000_000_0L * totalTrips;
    while (start < end) {
      long middle = (end - start) / 2 + start;
      long trip = 0;
      for (int t : time) {
        trip += middle / t;
      }
      if (trip < totalTrips) {
        start = middle + 1;
      } else {
        end = middle;
      }
    }

    return start;
  }
}
