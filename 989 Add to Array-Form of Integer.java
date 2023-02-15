class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        int carryon = 0;
        int num = K;
        int i = A.length - 1;
        while(num != 0 && i >= 0) {
            int cur = num % 10 + A[i] + carryon;
            res.addFirst(cur % 10);
            carryon = cur / 10;
            num = num / 10;
            i--;
        }
        while(i >= 0) {
            int cur = A[i] + carryon;
            res.addFirst(cur % 10);
            carryon = cur / 10;
            i--;
        }
        while(num > 0) {
            int cur = num % 10 + carryon;
            res.addFirst(cur % 10);
            carryon = cur / 10;
            num = num / 10;
        }
        if(carryon != 0)
            res.addFirst(carryon);
        return res;
    }
}
