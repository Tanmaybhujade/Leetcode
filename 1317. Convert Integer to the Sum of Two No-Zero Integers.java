class Solution {
    public int[] getNoZeroIntegers(int n) {
        String nstr = Integer.toString(n);
        if (nstr.length() == 1) {
            return new int[]{1, n - 1};
        }

        char[] bstr = new char[nstr.length() - 1];
        for (int i = 1; i < nstr.length(); ++i) {
            if (nstr.charAt(i) < '9') {
                bstr[i - 1] = (char)(nstr.charAt(i) + 1);
            } else {
                bstr[i - 1] = '1';
            }
        }

        int b = Integer.parseInt(new String(bstr));
        int a = n - b;
        return new int[]{a, b};
    }
}
