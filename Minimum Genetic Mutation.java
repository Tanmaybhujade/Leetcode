class Solution {

	int ans=Integer.MAX_VALUE;
	public int minMutation(String start, String end, String[] bank) {

		path(start,bank,end,0);

		return ans==Integer.MAX_VALUE?-1:ans;
	}

	void path(String start,String[] bank,String end,int steps){
		if(steps>=ans) return;

		for(int i=0;i<bank.length;i++){

			if(bank[i]!="" && isValidPath(start,bank[i])){
				String val=bank[i];
				bank[i]="";
				path(val,bank,end,steps+1);
				bank[i]=val; 
				if(bank[i].equals(end)){
					ans=Math.min(ans,steps+1);
					return;
				}
			}
		}
	}


	boolean isValidPath(String s,String d){
		if(s.equals(d)) return false;
		boolean once=false;
		for(int i=0;i<8;i++){
			if(s.charAt(i) != d.charAt(i)){
				if(once){
					return false;
				}
				once=true;
			}
		}

		return true;
	}

}
