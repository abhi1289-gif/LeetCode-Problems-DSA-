class Solution {

    public boolean isPossible(int x, int y, int num, char board[][]){
        char ch = (char)(num + '0');

        for(int i=0; i<9; i++){
            if(i == x) continue;
            if(board[i][y] == ch) return false;
        }

        for(int j=0; j<9; j++){
            if(j == y) continue;
            if(board[x][j] == ch) return false;
        }

        int a = (x/3)*3;
        int b = (y/3)*3;

        for(int i=a; i<a+3; i++){
            for(int j=b; j<b+3; j++){
                if(i==x && j==y) continue;
                if(board[i][j] == ch) return false;
            }
        }

        return true;
    }

    public boolean fill(int row, int col, char[][] board){
        if(row == 9) return true;
        else if(col == 9) return fill(row+1, 0, board);
        else if(board[row][col] != '.') return fill(row, col+1, board);


        for(int i=1; i<=9; i++){
            if(isPossible(row, col, i, board)){
                board[row][col] = (char)(i + '0');
                boolean possible = fill(row, col+1, board);
                if(possible) return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        fill(0, 0, board);
    }
}