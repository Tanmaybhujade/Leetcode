class Solution {
	public int findKthPositive(int[] arr, int k) {
		int cnt = 0;
		int idx = 1;
		cnt += arr[0] - 1;
		while(cnt < k && idx < arr.length){
			cnt += arr[idx] - arr[idx-1] - 1;
			idx++;
		}
    
		if(cnt < k){
			return arr[idx-1] - cnt + k;        
		}
		else{
			return arr[idx-1] - cnt -1 + k;
		}    
	}
}
