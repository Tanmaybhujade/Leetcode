class Solution {
    public int addDigits(int num) {
    //MATH : The original number is divisible by 9 if and only if the sum of its digits is divisible by 9
    //so if it is divisible by 9 get result 9 else reminder will be single digit number that will be the sum
        if(num == 0) return 0;
        if(num%9 == 0) return 9;
        return num%9;
    }
}
