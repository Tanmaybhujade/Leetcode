/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIdx=findPeak(mountainArr);
        int left=findInLeft(mountainArr, 0, peakIdx, target);
        int right=findInRight(mountainArr, peakIdx, mountainArr.length()-1, target);
        if(left!=-1) return left;
        return right;
    }

    private int findPeak(MountainArray arr) {
        int l=0;
        int h=arr.length()-1;
        while(l+1<h) {
            int mid=(l+h)/2;
            if(arr.get(mid)<arr.get(mid+1)) {
                l=mid;
            }else {
                h=mid;
            }
        }
        return h;
    }

    private int findInLeft(MountainArray arr, int start, int end, int target) {
        int l=start;
        int h=end+1;
        while(l+1<h) {
            int mid=(l+h)/2;
            if(arr.get(mid)<=target) {
                l=mid;
            }else {
                h=mid;
            }
        }
        return arr.get(l) == target ? l : -1 ;
    }

    private int findInRight(MountainArray arr, int start, int end, int target) {
        int l=start-1;
        int h=end;
        while(l+1<h) {
            int mid=(l+h)/2;
            if(arr.get(mid)<=target) {
                h=mid;
            }else {
                l=mid;
            }
        }
        return arr.get(h) == target ? h : -1 ;
    }
}
