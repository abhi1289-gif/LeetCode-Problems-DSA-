class Solution {

    int dp[][][];
    int mod = 1000000007;

    public int travel(int len, int n, int conse, int abs){
        if(len == n){
            return 1;
        }

        if(dp[len][abs][conse] != -1) return dp[len][abs][conse];

        int a = 0;
        int b = 0;
        int c = 0;

        // for A
        if(abs < 1) a = travel(len+1, n, 0, abs+1);

        // for P
        b = travel(len+1, n, 0, abs);

        // for L
        if(conse < 2) c = travel(len+1, n, conse+1, abs);

        return dp[len][abs][conse] = (int)(((long)a+b+c)%mod);
    }

    public int checkRecord(int n) {
        dp = new int[n+1][2][3];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=1; j++){
                for(int k=0; k<3; k++) dp[i][j][k] = -1;
            }
        }
        return travel(0, n, 0, 0);
    }
}