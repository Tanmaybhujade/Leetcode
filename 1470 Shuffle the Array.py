class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        lst = []
        for i, j in zip(range(0,n), range(n, len(nums))):
            lst.append(nums[i])
            lst.append(nums[j])
        return lst
