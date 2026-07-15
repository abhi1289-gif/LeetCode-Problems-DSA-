class Solution {

    int mod = 1000000007;
    int dp[][][];

    public int travel(int x, int y, int n, int m, int rem){
        if(x<0 || y<0 || x>=n || y>=m){
            if(rem >= 0) return 1;
            return 0;
        }

        rem--;

        if(rem < 0) return 0;

        if(dp[x][y][rem] != -1) return dp[x][y][rem];

        int a = travel(x-1, y, n, m, rem);
        int b = travel(x+1, y, n, m, rem);
        int c = travel(x, y-1, n, m, rem);
        int d = travel(x, y+1, n, m, rem);


        long sum = (long)a + b + c + d;
        int ans = (int)(sum % mod);

        return dp[x][y][rem] = ans;
    }

    public int findPaths(int n, int m, int maxMove, int startRow, int startColumn) {
        dp = new int[n][m][maxMove+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<=maxMove; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return travel(startRow, startColumn, n, m, maxMove);
    }
}   