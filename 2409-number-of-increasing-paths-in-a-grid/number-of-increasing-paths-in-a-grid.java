class Solution {
    int mod = 1000000007;

    int dp[][];

    public int travel(int x, int y, int n, int m, int nums[][], int prev){
        if(x<0 || y<0 || x>=n || y>=m || prev>=nums[x][y]) return 0;

        if(dp[x][y] !=  -1) return dp[x][y];

        int a = travel(x+1, y, n, m, nums, nums[x][y]);
        int b = travel(x-1, y, n, m, nums, nums[x][y]);
        int c = travel(x, y+1, n, m, nums, nums[x][y]);
        int d = travel(x, y-1, n, m, nums, nums[x][y]);

        long temp = (1 + a + b + c + d)%mod;
        int res = (int)temp;
        
        return dp[x][y] = res;
    }

    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) dp[i][j] = -1;
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int res = travel(i, j, n, m, grid, -1);
                ans = (ans + res)%mod;
            }
        }

        return ans;
    }
}