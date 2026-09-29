class Solution {

    Boolean dp[][][];

    public boolean travel(int x, int y, int n, int m, int opn,  char nums[][]){
        if(x >= n || y >= m) return false;

        if(nums[x][y] == '(') opn++;
        else opn--;

        if(opn < 0) return false;

        if(x == n-1 && y == m-1){
            if(opn == 0) return dp[x][y][opn] = true;
            return dp[x][y][opn] = false;
        }

        if(dp[x][y][opn] != null) return dp[x][y][opn];

        return dp[x][y][opn] = travel(x+1, y, n, m, opn, nums) || travel(x, y+1, n, m, opn, nums);
    }

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int opn = n+m+1;
        dp = new Boolean[n][m][opn];
        return travel(0, 0, n, m, 0, grid);
    }
}