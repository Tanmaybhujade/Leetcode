class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        solution = set()
        nums.sort()

        for i in range(len(nums) - 2):
            num1 = nums[i]
            target = 0 - num1
            l, r = i + 1, len(nums) - 1

            while l < r:
                if nums[l] + nums[r] == target:
                    solution.add((num1, nums[l], nums[r]))
                    l += 1
                    r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    r -= 1

        return solution 
    Tab
