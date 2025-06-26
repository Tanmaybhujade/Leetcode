class Solution {
    public int longestSubsequence(String s, int k) {
    long currValue = 0, power = 1, reqLen = 0;
    int n = s.length();
    for(int i = n - 1; i >= 0; i--){
        char ch = s.charAt(i);
        //Can always include all '0s' to increase the length
        if(ch == '0') reqLen++;
        else {
            //Include '1s' only if doesn't exceed k
            if(currValue + power <= k){
                reqLen++;
                currValue += power;
            }
        }
        //Simulate power
        if(power <= k) power <<= 1;
    }   
    return (int)reqLen;
    }
}
