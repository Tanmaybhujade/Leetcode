class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 1) return trust[0][1];
        int doesnthTrust[] = new int[n];
        int isnthTrusrted[] = new int[n];
        for(int i = 0;i<trust.length;i++){
            doesnthTrust[trust[i][0]-1]++;
            isnthTrusrted[trust[i][1]-1]++;
        }
        for(int j = 0;j<doesnthTrust.length;j++){
            if(doesnthTrust[j] == 0 && isnthTrusrted[j] == (n-1)){
                return j+1;
            }
        }
        return -1;
    }
}
