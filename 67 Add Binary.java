import java.math.*;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger m=new BigInteger(a,2);
        BigInteger n=m.add(new BigInteger(b,2));
        
        
        return n.toString(2);
    }
}

//one more solution



class Solution {
    public String addBinary(String a, String b) {
    if (a == null || a == "")
        return b;
    if (b == null || b == "")
        return a;
    int carry = 0;
    String ret = "";
    int l1 = a.length()-1;
    int l2 = b.length()-1;
    while (l1 >= 0 || l2 >= 0 || carry == 1) {
        if (l1 >= 0) {
            carry += Integer.parseInt(a.charAt(l1)+"");
            l1--;
        }
        if (l2 >= 0) {
            carry += Integer.parseInt(b.charAt(l2)+"");
            l2--;
        }
        ret = String.valueOf(carry%2) + ret;
        carry /= 2;
    }
    return ret;
  }
}
