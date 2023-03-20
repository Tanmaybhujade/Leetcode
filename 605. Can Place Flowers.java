class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] arr = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, arr, 1, flowerbed.length);
        //Ex:10001-->0100010，add arr[i - 1] & arr[i + 1]
        for (int i = 1; i < arr.length - 1 && n > 0; i++) {
            if (arr[i - 1] + arr[i] + arr[i + 1] == 0) { //if have 3 continous 0s
                arr[i] = 1;                              //arr[i] = 1
                n--;
            }
        }
        return n == 0;
    }
}

