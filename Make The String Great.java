class Solution {
   public String makeGood(String s) {
        if(s.length()==0) return s;
        if(s.length()==1) return s;
        int size=s.length();
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        boolean flag;
        while(i<size){
            flag=false;
            if(i+1<size && ((sb.charAt(i)==sb.charAt(i+1)-32) || (sb.charAt(i)==sb.charAt(i+1)+32))){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                size=sb.length();
                flag=true;
                
            }
            if(flag) i=0;
            else i++;
        
        }
        return sb.toString();
        
    }
}
