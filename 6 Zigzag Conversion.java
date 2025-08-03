public class Solution {
    public String convert(String s, int nRows) {
        int length=s.length();
        if(length<2) return s;
        if(nRows<2) return s;
		StringBuffer[] buffer=new StringBuffer[nRows];
		for(int i=0;i<nRows;i++)
			buffer[i]=new StringBuffer();
		for(int i=0;i<length;i++){
			int row=i%(2*nRows-2);
			if(row<nRows) buffer[row].append(s.charAt(i));
			else{
			   buffer[2*nRows-row-2].append(s.charAt(i)); 
			}
		}
		
		StringBuffer result=new StringBuffer();
		for(int j=0;j<nRows;j++){
			result.append(buffer[j]);
		}
		return result.toString();
    }
}
 tanmaybhujade1