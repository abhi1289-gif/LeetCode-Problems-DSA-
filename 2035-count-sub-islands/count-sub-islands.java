class Solution {

    boolean always;

    public void travel(int[][] grid1, int[][] grid2, boolean visited[][], int x, int y, int n, int m){
        if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || grid2[x][y] == 0) return;

        if(grid1[x][y] == 0 && grid2[x][y] == 1) always = false;
        visited[x][y] = true;

        travel(grid1, grid2, visited, x+1, y, n, m);
        travel(grid1, grid2, visited, x, y+1, n, m);
        travel(grid1, grid2, visited, x-1, y, n, m);
        travel(grid1, grid2, visited, x, y-1, n, m);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        boolean visited[][] = new boolean[n][m];
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid1[i][j] == 1 && grid2[i][j] == 1){
                    always = true;
                    travel(grid1, grid2, visited, i, j, n, m);
                    if(always) ans++;
                }
            }
        }

        return ans;
    }
}