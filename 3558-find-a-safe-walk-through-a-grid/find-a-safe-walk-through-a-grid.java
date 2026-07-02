class Solution {

    Boolean dp[][][];

    public boolean travel(int x, int y, int n, int m, List<List<Integer>> grid, int health, boolean visited[][]){
        if(x<0 || y<0 || x>=n || y>=m || visited[x][y] || health<1) return false;
        if(grid.get(x).get(y) == 1) health--;

        if(x==n-1 && y==m-1 && health>0) return true;

        if(dp[x][y][health] != null) return dp[x][y][health];

        visited[x][y] = true;

        boolean l = travel(x-1, y, n, m, grid, health, visited);
        boolean d = travel(x, y+1, n, m, grid, health, visited);
        boolean r = travel(x+1, y, n, m, grid, health, visited);
        boolean u = travel(x, y-1, n, m, grid, health, visited);

        visited[x][y] = false;

        return dp[x][y][health] = l || r || u || d;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        dp = new Boolean[n][m][health+1];
        boolean visited[][] = new boolean[n][m];
        return travel(0, 0, n, m, grid, health, visited);
    }
}