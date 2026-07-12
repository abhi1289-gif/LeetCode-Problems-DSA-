class Solution {

    public boolean isPossible(int x, int y, char num, char board[][]){
        char ch = num;

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

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(!isPossible(i, j, board[i][j], board)) return false;
            }
        }

        return true;
    }
}