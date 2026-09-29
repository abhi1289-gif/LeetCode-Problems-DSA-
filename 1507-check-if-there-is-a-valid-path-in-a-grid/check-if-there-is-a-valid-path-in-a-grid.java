class Solution {

    public boolean travel(int x, int y, int n, int m, int nums[][], boolean visited[][]){
        if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) return false;

        if(x == n-1 && y == m-1) return true;

        visited[x][y] = true;

        if(nums[x][y] == 1)
            return (y > 0 && (nums[x][y-1] == 1 || nums[x][y-1] == 4 || nums[x][y-1] == 6)
                    && travel(x, y-1, n, m, nums, visited))
                ||
                (y+1 < m && (nums[x][y+1] == 1 || nums[x][y+1] == 3 || nums[x][y+1] == 5)
                    && travel(x, y+1, n, m, nums, visited));

        if(nums[x][y] == 2)
            return (x > 0 && (nums[x-1][y] == 2 || nums[x-1][y] == 3 || nums[x-1][y] == 4)
                    && travel(x-1, y, n, m, nums, visited))
                ||
                (x+1 < n && (nums[x+1][y] == 2 || nums[x+1][y] == 5 || nums[x+1][y] == 6)
                    && travel(x+1, y, n, m, nums, visited));

        if(nums[x][y] == 3)
            return (y > 0 && (nums[x][y-1] == 1 || nums[x][y-1] == 4 || nums[x][y-1] == 6)
                    && travel(x, y-1, n, m, nums, visited))
                ||
                (x+1 < n && (nums[x+1][y] == 2 || nums[x+1][y] == 5 || nums[x+1][y] == 6)
                    && travel(x+1, y, n, m, nums, visited));

        if(nums[x][y] == 4)
            return (y+1 < m && (nums[x][y+1] == 1 || nums[x][y+1] == 3 || nums[x][y+1] == 5)
                    && travel(x, y+1, n, m, nums, visited))
                ||
                (x+1 < n && (nums[x+1][y] == 2 || nums[x+1][y] == 5 || nums[x+1][y] == 6)
                    && travel(x+1, y, n, m, nums, visited));

        if(nums[x][y] == 5)
            return (y > 0 && (nums[x][y-1] == 1 || nums[x][y-1] == 4 || nums[x][y-1] == 6)
                    && travel(x, y-1, n, m, nums, visited))
                ||
                (x > 0 && (nums[x-1][y] == 2 || nums[x-1][y] == 3 || nums[x-1][y] == 4)
                    && travel(x-1, y, n, m, nums, visited));

        return (y+1 < m && (nums[x][y+1] == 1 || nums[x][y+1] == 3 || nums[x][y+1] == 5)
                && travel(x, y+1, n, m, nums, visited))
            ||
            (x > 0 && (nums[x-1][y] == 2 || nums[x-1][y] == 3 || nums[x-1][y] == 4)
                && travel(x-1, y, n, m, nums, visited));
    }

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        return travel(0, 0, n, m, grid, visited);
    }
}