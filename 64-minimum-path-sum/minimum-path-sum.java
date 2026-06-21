class Solution {

    int ans = Integer.MAX_VALUE;

    int dp[][];

    public int travel(int x, int y, int n, int m, int grid[][], int sum){
        if(x>=n || y>=m) return Integer.MAX_VALUE;
        if(x == n-1 && y == m-1){
            return grid[x][y];
        }

        if(dp[x][y] != -1) return dp[x][y];

        int a = travel(x+1, y, n, m, grid, sum);
        int b = travel(x, y+1, n, m, grid, sum);

        return dp[x][y] = grid[x][y] + Math.min(a, b);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) dp[i][j] = -1;
        }
        return travel(0, 0, n, m, grid, 0);
    }
}