class Solution {
    public int minFlipsMonoIncr(String s) {
        int res=0;
        int count1=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1'){
			// if the last character is '1'
                count1++;
            }else{
			// if the last character is '0', we will check minimum of both options.
                int tmp1=count1;
                int tmp2=res+1;
                res=Math.min(tmp1,tmp2);
            }
        }
        return res;
    }
}
