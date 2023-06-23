class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        dp = {}
        max_length = 2

        for i in range(len(nums)):
            for j in range(i):
                difference = nums[i] - nums[j]
                if (j, difference) in dp:
                    dp[(i, difference)] = dp[(j, difference)] + 1
                else:
                    dp[(i, difference)] = 2

                max_length = max(max_length, dp[(i, difference)])

        return max_length
