class Solution {

        public int longestOnes(int[] arr, int flips) {
		int start=0,index= 0, end=arr.length, max=0;
		while(index<end){
			if(arr[index]==0){
				/* if we flip this zero, we need to decrease flip */
				flips--;
			}
			if(flips<0){
				/* it means all flips are consumed so calculate current window here and we need to shift start by 1 index for next window */
				max=Math.max(max, index-start);
				if(arr[start++]==0){
					/* increase flip only if current is zero, otherwise no need. */
					flips++;
				}
			}
			index++;
		}
		/* return max length of consucutive one's including flips */
		return Math.max(max, index-start);
    }
    
}
