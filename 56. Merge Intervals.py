

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # Check if the input intervals list is empty
        if not intervals:
            return []

        # Sort the interval list based on the start times of intervals
        intervals.sort()
      
        # Initialize the merged_intervals list with the first interval
        merged_intervals = [intervals[0]]
      
        # Iterate over the intervals, starting from the second interval
        for start, end in intervals[1:]:
            # Assign the last interval in merged_intervals to a variable for readability
            last_interval = merged_intervals[-1]

            # Check if the current interval does not overlap with the last interval in merged_intervals
            if last_interval[1] < start:
                # If it does not overlap, add the current interval to merged_intervals
                merged_intervals.append([start, end])
            else:
                # If it does overlap, merge the current interval with the last one by
                # updating the end time of the last interval to the maximum end time seen so far
                last_interval[1] = max(last_interval[1], end)
      
        # Return the merged intervals
        return merged_intervals
