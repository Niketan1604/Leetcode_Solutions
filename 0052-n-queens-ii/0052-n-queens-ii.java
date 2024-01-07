class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        return helper(0,board);
    }

    int helper(int col, char[][] board){
        
        if(col == board.length){
            return 1;
        }
        int ans = 0;
        for(int row=0; row<board.length; row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                ans += helper(col+1,board);
                board[row][col] = '.';
            }
        }

        return ans;

    }

    boolean isSafe(int row, int col, char[][] board){
        int dupRow = row;
        int dupCol = col;

        //checking the upper left diagonal
        while(row>=0 && col>=0){
            if(board[row--][col--] == 'Q') return false;
        }
        
        //checking the row
        col = dupCol;
        row = dupRow;
        while(col>=0){
            if(board[row][col--]=='Q') return false;
        }

        //checking the lower left diagonal
        col = dupCol;
        row = dupRow;
        while(row<board.length && col>=0){
            if(board[row++][col--] == 'Q') return false;
        }

        return true;
    }
}