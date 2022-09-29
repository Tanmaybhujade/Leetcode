class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l,r = 0,len(arr)-1
        while (r-l+1) != k:
            # print(arr[l])
            if abs(arr[l]-x) > abs(arr[r]-x):
                l+= 1
            else:
                r-= 1
        # print(r)
        return(arr[l:r+1])     
