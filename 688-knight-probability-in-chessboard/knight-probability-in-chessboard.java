class Solution {

    double dp[][][];

    public double travel(int x, int y, int n, int rem){
        if(x<0 || y<0 || x>=n || y>=n){
            return 0.0;
        }

        if(rem == 0){
            return 1.0;
        }

        if(dp[x][y][rem] != -1) return dp[x][y][rem];

        int dir[][] = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}};
        
        double a = 0;

        for(int d[]: dir){
            a += travel(x+d[0], y+d[1], n, rem-1)/8.0;
        }

        return dp[x][y][rem] = a;
    }

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int p=0; p<=k; p++){
                    dp[i][j][p] = -1;
                }
            }
        }
        return travel(row, column, n, k);
    }
}