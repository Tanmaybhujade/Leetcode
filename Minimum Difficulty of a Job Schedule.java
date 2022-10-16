class Solution {
    int[] hardestJobRemaining;
    int[][] memo;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
		//if there are not enough jobs for each day we return -1 (at least we need one job for each day)
        if(n < d) return -1;
        memo = new int[n][d + 1];
        for(int[] row: memo) Arrays.fill(row, -1);
        hardestJobRemaining = new int[n];
        int hardestJob = 0;
        for(int i = n-1; i >= 0; i--){
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }
		// we start from the first day and zero job is done
        return dp(jobDifficulty, d, 0, 1);
    }
	
 	//we start work from the job i on the day day
    public int dp(int[] jobDifficulty, int d, int i, int day){
        if(day == d) return hardestJobRemaining[i];
        if(memo[i][day] != -1) return memo[i][day];
        int n = jobDifficulty.length;
        int best = Integer.MAX_VALUE;
        int hardest = 0;
        for(int j = i; j < n - (d - day); j++){
            hardest = Math.max(hardest, jobDifficulty[j]);
            best = Math.min(best, hardest + dp(jobDifficulty, d, j + 1, day + 1));
        }
        memo[i][day] = best;
                    
        return memo[i][day];
    }
}
