class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
       int m = s1.length();
int n = s2.length();

	// Base case
	if(s3.length() != m + n) {
		return false;
	}
	if(s1.length() == 0) {
		return s2.equals(s3);
	} 
	if(s2.length() == 0) {
		return s1.equals(s3);
	}

	
	boolean[][] dp = new boolean[m+1][n+1];

	
	dp[0][0] = true;

	for(int i = 1; i < m+1; i++) {
		dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
	}

	for(int i = 1; i < n+1; i++) {
		dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
	}

	for(int i = 1; i < m+1; i++) {
		for(int j = 1; j < n+1; j++) {
			dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) 
					|| (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
		}
	}

	return dp[m][n]; 
    }
}
