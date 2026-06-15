class Solution {

    public int travel(int board[][], int i, int j, int dir[][], int n, int m){
        int ans = 0;

        for(int d[]: dir){
            int x = i + d[0];
            int y = j + d[1];

            if(x<0 || y<0 || x>=n || y>=m) continue;

            if(board[x][y] == 1) ans++;
        }

        return ans;
    }

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int temp[][] = new int[n][m];

        int dir[][] = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                int nebr = travel(board, i, j, dir, n, m);

                if(board[i][j] == 1){
                    if(nebr<2) temp[i][j] = 0;
                    else if(nebr>3) temp[i][j] = 0;
                    else temp[i][j] = 1;
                }
                else{
                    if(nebr == 3) temp[i][j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = temp[i][j];
            }
        }
    }
}