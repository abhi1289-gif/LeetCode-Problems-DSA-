class Solution {

    public void travel(int x, int y, int n, int m, boolean visited[][], int nums[][]){
        if(x<0 || y<0 || x>=n || y>=m || visited[x][y] || nums[x][y]==0) return;
        visited[x][y] = true;
        nums[x][y] = 2;

        travel(x+1, y, n, m, visited, nums);
        travel(x, y-1, n, m, visited, nums);
        travel(x, y+1, n, m, visited, nums);
        travel(x-1, y, n, m, visited, nums);
    }

    public class Pair{
        int x;
        int y;
        int f;

        Pair(int x, int y, int f){
            this.x = x;
            this.y = y;
            this.f = f;
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        loop:
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    travel(i, j, n, m, visited, grid);
                    break loop;
                }
            }
        }

        Queue<Pair> qu = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i, j, 0));
                }
            }
        }

        int dist[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(qu.size() > 0){
            Pair curr = qu.poll();
            int i = curr.x;
            int j = curr.y;
            int f = curr.f;

            for(int d[]: dist){
                int x = i + d[0];
                int y = j + d[1];

                if(x<0 || y<0 || x>=n || y>=m) continue;

                if(grid[x][y] == 1) return f;

                if(grid[x][y] == 0){
                    grid[x][y] = 2;
                    qu.add(new Pair(x, y, f+1));
                }
            }
        }


        return -1;

    }
}